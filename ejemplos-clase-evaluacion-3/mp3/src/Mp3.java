import java.io.File;

import javafx.application.Application;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

/**
 * Necesita JDK8
 * @author alvaro
 *
 */
public class Mp3 extends Application{
  public static void main(final String[] args) {
      new Thread( new Runnable(){
          public void run(){
              Application.launch(Mp3.class,args);
          }
      }).start();

      
      try{
          Thread.sleep(1000);
          System.out.println("Ahora a tocar...");
          String file = new File("090.mp3").toURI().toString();;
          Media hit = new Media(file);
          MediaPlayer mediaPlayer = new MediaPlayer(hit);
          mediaPlayer.play();
          Thread.sleep(20000);
          System.out.println("Ahora a parar...");
          mediaPlayer.stop();
      }catch(Exception e){
          e.printStackTrace();
      }

      System.exit(0);
  }

    @Override
    public void start(Stage arg0) throws Exception {
    }
}
