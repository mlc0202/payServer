package cn.com.yunqitong.util;

import java.io.IOException;
import java.util.Properties;



public class PropertyFactory {
	static Properties pops = new Properties();
	static Properties vpops = new Properties();
	static Properties errorPops = new Properties();
	static {
		try {
			pops.load(PropertyFactory.class.getClassLoader().getResourceAsStream("system.properties"));
//			vpops.load(PropertyFactory.class.getClassLoader().getResourceAsStream("version.properties"));
			errorPops.load(PropertyFactory.class.getClassLoader().getResourceAsStream("errorCode.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private PropertyFactory() {
	}; 

	public static String getProperty(String key) {
		return pops.getProperty(key);
	}
	
	public static String getVsersionProperty(String key) {
		return vpops.getProperty(key);
	}

	public static String getErrorProperty(String key) {
		return errorPops.getProperty(key);
	}
}
