import java.io.File;


public class Students {

	public static String[] students(){
		File dir = new File("students");
		return dir.list();
	}
}
