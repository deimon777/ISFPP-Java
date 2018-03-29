package com.deimon.isfpp.configuracion;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.InputStream;
import java.util.Properties;

public class UtilProperties {

	public static void main(String[] args) {
	}

	public void setDBProperties(String nombre, String db, String dbuser, String dbpassword) {
		Properties prop = new Properties();
		OutputStream output = null;
		
		try {
			output = new FileOutputStream(nombre);
			// set the properties value
			prop.setProperty("database", db);
			prop.setProperty("dbuser", dbuser);
			prop.setProperty("dbpassword", dbpassword);

			// save properties to project root folder
			prop.store(output, null);

		} catch (IOException io) {
			io.printStackTrace();
		} finally {
			if (output != null) {
				try {
					output.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public void getDBProperties(String nombre, String db, String dbuser, String dbpassword) {
		Properties prop = new Properties();
		InputStream input = null;

		try {
			input = new FileInputStream(nombre);
			
			//load a properties file from class path, inside static method
			prop.load(input);

			//get the property value and print it out
			System.out.println(db+": "+prop.getProperty(db));
			System.out.println(dbuser+": "+prop.getProperty(dbuser));
			System.out.println(dbpassword+": "+prop.getProperty(dbpassword));

		} catch (IOException ex) {
			ex.printStackTrace();
		} finally{
			if(input!=null){
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

	}
}
