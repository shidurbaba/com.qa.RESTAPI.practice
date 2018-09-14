package com.testbase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class TestBase {
	static Properties prop;

	TestBase() {
		FileInputStream file;
		try {
			file = new FileInputStream(
					(System.getProperty("user.dir") + "/src/main/java/com" + "/config/Environment.properties"));
			prop = new Properties();
			prop.load(file);
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}

}
