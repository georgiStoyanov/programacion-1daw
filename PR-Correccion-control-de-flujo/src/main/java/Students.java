import java.io.File;
import java.io.FilenameFilter;


public class Students {

	public static String[] students(){
		File dir = new File("students");
		FilenameFilter filter = new FilenameFilter() {
			
			@Override
			public boolean accept(File dir, String name) {
				return name.toLowerCase().contains("moli");
			}
		};
		return dir.list(filter);
	}
}
