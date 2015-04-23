import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import org.mp3transform.Decoder;

/**
 * Con esta clase vale para tocar mp3, sin jdk8
 * @author alvaro
 *
 */
class Mp3Player{
    private InputStream _in;
    private Thread _thread;
    private Decoder _decoder;
    private String _name;
    private boolean _stopped = false;

    public Mp3Player(String name, InputStream in){
        _in = in;
        _name = name;
        _thread = new Thread( new Runnable(){
            public void run(){
                _decoder = new Decoder();
                BufferedInputStream bin = new BufferedInputStream(_in, 128 * 1024);
                try {
                    _decoder.play(_name, bin);
                    System.out.println("El player se acaba:" + _name );
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }
    
    public void play(){
        if( _stopped  ){
            throw new IllegalStateException("No puedo tocar dos veces");
        }
        if( _decoder == null ){
            _thread.start();
        }
    }
    
    public void stop(){
        _stopped = true;
        if( _decoder != null ){
            _decoder.stop();
        }
    }
    
    public void pause(){
        if( _decoder != null ){
            _decoder.pause();
        }
    }
}

public class Shell {
    public static void main(String[] args) throws FileNotFoundException, InterruptedException{
        File file = new File("090.mp3");
        FileInputStream in = new FileInputStream(file);
        Mp3Player p = new Mp3Player( "Florencia", in );
        System.out.println("Tocando...");
        p.play();
        Thread.sleep(10000);
        System.out.println("Parando...");
        p.stop();
    }
}
