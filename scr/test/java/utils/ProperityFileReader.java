package Utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ProperityFileReader {
	
	public static String fileReader(String fileName,String key){
		String filePath="./Data/"+fileName+".properties";
		File oFile = new File(filePath);
		String propertyValue = "";
		try {
			FileInputStream oFIS = new FileInputStream(oFile);
			Properties oProp = new Properties();
			oProp.load(oFIS);
			propertyValue = oProp.getProperty(key);
			return propertyValue;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return propertyValue;
	}

}
