package trainer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Trainer
{
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Trainer Details");
		System.out.println("Enter Id");
		int id=sc.nextInt();
		System.out.println("Enter name");
		String name=sc.next();
		System.out.println("Enter age");
		int age=sc.nextInt();
		System.out.println("Enter designation");
		String designation=sc.next();
		System.out.println("Enter subject");
		String subject=sc.next();
		System.out.println("Enter salary");
		double sal=sc.nextDouble();
		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/trainerdet","root","root");
			PreparedStatement preparedStatement=connection.prepareStatement("insert into trainer values(?,?,?,?,?,?)");
			preparedStatement.setInt(1, id);
			preparedStatement.setString(2, name);
			preparedStatement.setInt(3, age);
			preparedStatement.setString(4, designation);
			preparedStatement.setString(5, subject);
			preparedStatement.setDouble(6, sal);
			preparedStatement.execute();
			System.out.println("Data saved");
			connection.close();
		}
		catch (ClassNotFoundException | SQLException e) 
		{
			e.printStackTrace();
		}
		
	}

}
