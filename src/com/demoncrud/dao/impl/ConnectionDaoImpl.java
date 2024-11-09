package com.demoncrud.dao.impl;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionDaoImpl {
	public Connection connectionWithSqlDb() throws ClassNotFoundException, SQLException, IOException {
		InputStream fis=  getClass().getClassLoader().getResourceAsStream("db.properties");
		Properties prop=new Properties();
		prop.load(fis);
		fis.close();
		
		String url= prop.getProperty("db.url");
		String user = prop.getProperty("db.user");
		String password= prop.getProperty("db.password");
		
		Connection c= DriverManager.getConnection(url,user,password);
		if (c == null) {
		    System.out.println("Connection not established");
		}
		return c;
		
	}

}