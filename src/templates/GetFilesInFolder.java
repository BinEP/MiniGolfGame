package templates;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;


public class GetFilesInFolder {

	public GetFilesInFolder() {
		// TODO Auto-generated constructor stub
	}
	
//	public static void main(String[] args) {
//		
//		GetFilesInFolder g = new GetFilesInFolder();
//		g.runStuff();
//	}
	
	public static ArrayList<Class<?>> getClasses(String packageName) {
		
		ArrayList<Class<?>> classes = new ArrayList<Class<?>>();
		File folder = new File("src/" + packageName + "/");
		System.out.println(folder.getAbsolutePath());
		File[] contents = folder.listFiles();
		System.out.println(contents);
		for (File f : contents) {
			String className = removeExtension(f.getName());
			System.out.println(className);
			try {
				classes.add(Class.forName("maps." + className));
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		return classes;
		
	}
	
	public static String removeExtension(String name) {
		
		int pos = name.lastIndexOf(".");
		if (pos > 0) {
		    name = name.substring(0, pos);
		}
		return name;
	}

}
