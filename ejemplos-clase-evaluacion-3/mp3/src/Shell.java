import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import org.mp3transform.Decoder;

public class Shell {
    public static void main(String[] args) throws Exception {
        Decoder decoder = new Decoder();
        File file = new File("090.mp3");
        FileInputStream in = new FileInputStream(file);
        BufferedInputStream bin = new BufferedInputStream(in, 128 * 1024);
        decoder.play(file.getName(), bin);
        in.close();
        decoder.stop();
    }
}
