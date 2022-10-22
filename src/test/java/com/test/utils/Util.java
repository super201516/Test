package com.test.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import com.test.constants.SourcePath;

public class Util {
	public FileInputStream stream=null;

	public  Properties loadfile(String filename) {
			
			Properties propertyFile = new Properties();
			String  PropertyFilePath=null;
			switch(filename) {
			case "getdataProperties":
				PropertyFilePath =SourcePath.CONFIG_PROPERTIES_PATH;
								break;
			case "writedataProperties":
				PropertyFilePath =SourcePath.WRITE_PROPERTIES_PATH;
								break;
			}
			try {
				stream=new FileInputStream(PropertyFilePath);
				propertyFile.load(stream);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return propertyFile;
		}
		
		public String getProperty(String Key,Properties propertyFile) {
			String value = propertyFile.getProperty(Key);
			System.out.println("Property we got from the file is::" + value);
			try {
				stream.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return value;
		}
}
