package jdbc.dao;

import java.io.FileInputStream;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import jdbc.table.model.UserRoutes;

public class SpectrAero {

	private Connection connection;
	private PreparedStatement prepStatment = null;
	private ResultSet resultSet = null;
	
	private String url;
	private String user;
	private String password;
	
	public SpectrAero() throws Exception {
		Properties properties = new Properties();		
		properties.load(new FileInputStream("config.properties"));
		
		url = properties.getProperty("url");
		user = properties.getProperty("user");
		password = properties.getProperty("password");
		
		connection = DriverManager.getConnection(url, user, password);
		
		System.out.println("Data base connection success!");
	}
	
	private void openConnection() throws SQLException {
		connection = DriverManager.getConnection(url, user, password);
	}
	
	public List<UserRoutes> getAllUserRoutes() {
		UserRoutes userRoute = null;
		List<UserRoutes> userRoutesList= new ArrayList<UserRoutes>();
		 
		try {			
			if (connection.isClosed()) {
				openConnection();
			}
			
			prepStatment = connection.prepareStatement("SELECT * FROM UserRoutes");
			resultSet = prepStatment.executeQuery();
			
			while (resultSet.next()) {
				userRoute = new UserRoutes(
						resultSet.getInt("IdRecord"),
						resultSet.getString("UserId"),
						resultSet.getString("RouteName"),
						resultSet.getString("Route"),
						resultSet.getDouble("Distance"));
				
				userRoutesList.add(userRoute);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		closeConnection();
		return userRoutesList;
	}
	
	public List<UserRoutes> findUserRoutes(String userId) {
		UserRoutes userRoute = null;
		List<UserRoutes> userRoutesList= new ArrayList<UserRoutes>();
		 
		try {
			if (connection.isClosed()) {
				openConnection();
			}
			
			prepStatment = connection.prepareStatement("SELECT * FROM UserRoutes WHERE UserId LIKE ?");
			prepStatment.setString(1, "%" + userId + "%");
			
			resultSet = prepStatment.executeQuery();			
			
			while (resultSet.next()) {
				userRoute = new UserRoutes(
						resultSet.getInt("IdRecord"),
						resultSet.getString("UserId"),
						resultSet.getString("RouteName"),
						resultSet.getString("Route"),
						resultSet.getDouble("Distance"));
				
				userRoutesList.add(userRoute);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		closeConnection();
		return userRoutesList;
	}
	
	private void closeConnection() {
		try {
			resultSet.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
