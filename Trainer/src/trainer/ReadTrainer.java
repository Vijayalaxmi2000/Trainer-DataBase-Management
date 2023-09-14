package trainer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ReadTrainer //based on name and subject
{

	public static void main(String[] args)
	{
		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/trainerdet","root","root");
			PreparedStatement preparedStatement = connection.prepareStatement("select * from trainer");
			ResultSet resultSet =preparedStatement.executeQuery();
			while(resultSet.next())
			{
				System.out.println("Tariner id:"+resultSet.getInt(1));
				System.out.println("Tariner name:"+resultSet.getString(2));
				System.out.println("Tariner age:"+resultSet.getInt(3));
				System.out.println("Tariner designation:"+resultSet.getString(4));
				System.out.println("Tariner subject:"+resultSet.getString(5));
				System.out.println("Tariner salary:"+resultSet.getDouble(6));
				
				System.out.println("-------------------------");
			}
			connection.close();
			
		}
		catch (ClassNotFoundException | SQLException e) 
		{
			e.printStackTrace();
		}
		

	}

}
