package base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class BaseClass {
	
	

	public String getConfigData(String propName) throws IOException {
		String propValue = "";
		Properties prop = new Properties();
		File f = new File("config.properties");
		FileInputStream fio = new FileInputStream(f);
		prop.load(fio);
		propValue = prop.getProperty(propName);
		return propValue;

	}

}
