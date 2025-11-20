package com.college;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAO {
	Connection con;
	Statement stmt;
	PreparedStatement ps1,ps2;
	ResultSet rs;
	private static final String url="jdbc:mysql://localhost:3306/college_db";
	private static final String username="root";
	private static final String password="root";
	public EmployeeDAO()
	{
		try {
				if(con==null)
				{
				    Class.forName("com.mysql.jdbc.Driver");
				    con=DriverManager.getConnection(url,username,password);
				    stmt=con.createStatement();
				    ps1=con.prepareStatement("insert into employee(name,email,salary) values(?,?,?)");
				    ps2=con.prepareStatement("update employee set salary=? where id=?");
				}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public int save(Employee e)
	{
		
		try {
			//ps1.setInt(1,e.id);
			ps1.setString(1, e.getName());
			ps1.setString(2, e.getEmail());
			ps1.setDouble(3,e.getSalary());
			if(ps1.executeUpdate()>0)
			{
				return 1;
			}
			else
			{
				return 0;
			}
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return 0;
		}
		
	}
	public boolean update(Employee e)
	{
		
		try {
			ps2.setInt(2,e.getId());
			//ps2.setString(2, e.getName());
		//	ps2.setString(3, e.getEmail());
			ps2.setDouble(1,e.getSalary());
			if(ps2.executeUpdate()>0)
			{
				return true;
			}
			else
			{
				return false;
			}
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return false;
		}
		
	}
	
	public boolean delete(int id)	
	{
		try
		{
			String q="delete from employee where id="+id;
			stmt.execute(q);
			int i=stmt.getUpdateCount();
			if(i==1)	
				return true;
			else
				return false;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return false;
		}
	}
	public Employee findById(int id)
	{
		try
		{
			String q="select * from employee where id="+id;
			rs=stmt.executeQuery(q);	
			if(rs.next())
			{
				return new Employee(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getDouble(4));
			}
			
			return null;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return null;
		}
	}
	public List<Employee> findAll()
	{
		List<Employee> empList=new ArrayList<Employee>();
		try
		{
			rs=stmt.executeQuery("select * from employee");
			while(rs.next())
			{
				Employee e=new Employee(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getDouble(4));
				empList.add(e);
			}
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return empList;
	}
	

}
