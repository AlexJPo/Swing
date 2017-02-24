package javaJDBC;

import java.sql.*;

import jdbc.dao.SpectrAero;
import jdbc.frame.JavaJdbcFrame;

public class JavaJdbc {

	public static void main(String[] args) {
		Connection connection = null;
		Statement statment = null;
		ResultSet resultSet = null;
		PreparedStatement preparedStatement = null;
		
		try {
			
			JavaJdbcFrame jdbcFram = new JavaJdbcFrame();
			jdbcFram.run();
			
			//SpectrAero spectrAero = new SpectrAero();
			//System.out.println(spectrAero.findUserRoutes("5f2c"));
			
			/*String url = "jdbc:sqlserver://localhost;databaseName=SpectrAeroNew;user=sa;password=123456;";
			String query = "SELECt * FROM ArticleTypes";
			String selectQuery = "SELECt * FROM ArticleTypes WHERE Title = ?";
			String insertQuery = "INSERT INTO ArticleTypes (Title) VALUES ('Презентации')";
			String deleteQuery = "DELETE FROM ArticleTypes WHERE Title = 'Презентации'";
			
			connection = DriverManager.getConnection(url);
			statment = connection.createStatement();
			resultSet = statment.executeQuery(query);
			
			System.out.println("Select result:");	
			printData(resultSet);

			System.out.println("Delete query:");			
			statment.executeUpdate(deleteQuery);
			System.out.println("Insert query:");
			
			statment.executeUpdate(insertQuery);
			System.out.println("Select result:");
			resultSet = statment.executeQuery(query);			
			printData(resultSet);
			
			System.out.println("Select by params result:");
			
			preparedStatement = connection.prepareStatement(selectQuery);
			preparedStatement.setString(1, "Порталы");
			resultSet = preparedStatement.executeQuery();
			printData(resultSet);*/
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private static void printData(ResultSet result) {
		try {
			while (result.next()) {
				System.out.println(result.getString("IdRecord"));
				System.out.println(result.getString("Title"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("---------------");
	}

}
