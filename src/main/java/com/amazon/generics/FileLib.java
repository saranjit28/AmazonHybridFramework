package com.amazon.generics;

import java.io.FileInputStream;

import java.util.Properties;

public class FileLib {
	public String getPropertyValue(String key) throws Exception {
		FileInputStream fis = new FileInputStream("./data/commondata.properties");
		Properties p = new Properties();
		p.load(fis);
		String value = p.getProperty(key);
		return value;

	}

}
