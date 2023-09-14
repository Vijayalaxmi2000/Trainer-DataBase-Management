package trainer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Update 
{
	public static void main(String[] args) 
	{
		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/trainerdet","root","root");
			PreparedStatement preparedStatement=connection.prepareStatement("update trainer set sal=? where designation=?");
			preparedStatement.setDouble(1, 50000);
     		preparedStatement.setString(2, "HeadTrainer");
     		preparedStatement.execute();
			connection.close();
			System.out.println("Data updated");
		}
		catch (ClassNotFoundException | SQLException e) 
		{
			e.printStackTrace();
		}

	}
}
