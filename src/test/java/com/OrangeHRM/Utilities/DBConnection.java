package com.OrangeHRM.Utilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;



public class DBConnection {
	static Connection connection = null;
	static Statement statement = null;
	static ResultSet resultSet = null;
	static String url = "jdbc:oracle:thin:@localhost:1521:xe";
	static String userName = "sandeep";
	static String password = "sandeep";
	static String query = "select username,password from customers where customer_id =1";

	static List<String> data = new ArrayList<String>();

	public static List<String> returnData() {
		try {

			Class.forName("oracle.jdbc.driver.OracleDriver");
			connection = DriverManager.getConnection(url, userName, password);
			statement = connection.createStatement();
			resultSet = statement.executeQuery(query);

			while (resultSet.next()) {

				data.add(resultSet.getString("username"));
				data.add(resultSet.getString("password"));
				System.out.println(resultSet.getString("username") + " " + resultSet.getString("password"));
			}

			resultSet.close();
			statement.close();
			connection.close();
		} catch (Exception e1) {

			e1.printStackTrace();
		}

		return data;

	}

}
