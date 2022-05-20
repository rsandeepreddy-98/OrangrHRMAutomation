package com.OrangeHRM.Utilities;

import java.awt.RenderingHints.Key;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Properties;

public class ReadConfig {
	
	public Properties properties;
	
	public ReadConfig() {
		// TODO Auto-generated constructor stub
		try {
			FileInputStream fileInputStream = new FileInputStream("D:\\Java Collections\\OrangeHRMLoginFramework\\Configurations\\data.properties");
			properties = new Properties();
			try {
				properties.load(fileInputStream);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public String getApplicationUrl() {
		String url = properties.getProperty("url");
		return url;
	} 
		
	public String getUserName() {
		String userName = properties.getProperty("uName");
		return userName;
	}
	public String getPassword() {
		String password = properties.getProperty("pwd");
		return password;
	}
	public String getPath() {
		String path = properties.getProperty("chromepath");
		return path;
	}
	
	public String getFirstName() {
		String fname=properties.getProperty("fname");
		return fname;
	}
	public String getLastName() {
		String lname=properties.getProperty("lname");
		return lname;
	}
	
	
}
