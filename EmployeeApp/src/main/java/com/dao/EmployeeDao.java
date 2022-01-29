package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.MyDatabase.ConnectionProvider;
import com.model.Employee;

public class EmployeeDao {
	//to insert a Record
	//it return integer that why we take a method return type to Integer
	public int InsertEmployee(Employee e)
	{
		int check=0;
		Connection con=null;
		PreparedStatement pstmt=null;
		try {
			con=ConnectionProvider.getConnection();
			String sql="insert into employee(ename,edesignation,ecompany,esalary) values (?,?,?,?)";
			pstmt=con.prepareStatement(sql);
			//Set a values
			pstmt.setString(1, e.getEname());
			pstmt.setString(2, e.getEdesignation());
			pstmt.setString(3, e.getEcompany());
			pstmt.setDouble(4, e.getEsalary());
			check= pstmt.executeUpdate();
			
		} catch (Exception e2) {
			e2.printStackTrace();
		}
		finally
		{
			new ConnectionProvider().CloseConnection(pstmt, con);
		}
		return check;
	}
	
	//to Update a Record
    //it return integer that why we take a method return type to Integer
	
	public int UpdateEmployee(Employee e)
	{
		int check =0;
		Connection con=null;
		PreparedStatement pstmt=null;
		try {
			con=ConnectionProvider.getConnection();
			String sql="update employee set ename=?,edesignation=?,ecompany=?,esalary=? where eid=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, e.getEname());
			pstmt.setString(2, e.getEdesignation());
			pstmt.setString(3,e.getEcompany());
			pstmt.setDouble(4, e.getEsalary());
			pstmt.setInt(5, e.getEid());
			check=pstmt.executeUpdate();
			
		} catch (Exception e2) {
			e2.printStackTrace();
		}
		finally
		{
			new ConnectionProvider().CloseConnection(pstmt, con);
		}
		return check;
	}
	public int DeleteEmployeeByID(int id)
	{
		int check=0;
		Connection con=null;
		PreparedStatement pstmt=null;
		try {
			con=ConnectionProvider.getConnection();
			String sql="delete from employee where eid=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, id);
			check=pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally
		{
			new ConnectionProvider().CloseConnection(pstmt, con);
		}
		return check;
	}
	
	public Employee DisplayEmployeeByID(int id)
	{
		
		Employee e=null;
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			con=ConnectionProvider.getConnection();
			String sql="select eid ,ename,edesignation,ecompany,esalary from employee where eid=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, id);
			rs=pstmt.executeQuery();
			while(rs.next())
			{
				e=new Employee();
				e.setEid((int)rs.getObject("eid"));
				e.setEname((String)rs.getObject("ename"));
				e.setEdesignation((String)rs.getObject("edesignation"));
				e.setEcompany((String)rs.getObject("ecompany"));
				e.setEsalary((double)rs.getObject("esalary"));
			}
			
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		finally
		{
			new ConnectionProvider().CloseConnection(pstmt, con);
		}
		return e;
	}
	

}
