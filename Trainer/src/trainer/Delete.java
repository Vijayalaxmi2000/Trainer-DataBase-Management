package trainer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Delete 
{
	public static void main(String[] args) 
	{
		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/trainerdet","root","root");
			PreparedStatement preparedStatement=connection.prepareStatement("delete from trainer where age>60 and sal<20000");
//			preparedStatement.setInt(1, 60);
//			preparedStatement.setDouble(2,20000);
			preparedStatement.execute();
			connection.close();
			System.out.println("Data Deleted");
		}
		catch (ClassNotFoundException | SQLException e) 
		{
			e.printStackTrace();
		}
		
		
	}

}
