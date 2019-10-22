package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Configuration {
	
	private static Properties prop;
	
	public static void loadConfiguration(){
		File f = new File("src/t/resources/config.properties");
		InputStream is = null;
		try {
			is = new FileInputStream(f);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		prop = new Properties();
		try {
			prop.load(is);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static String getBrowserName(){
		return prop.getProperty("browser");
	}
	public static String getURL(){
		return prop.getProperty("url");
	}

}
