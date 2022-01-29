package com.Dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.MyDatabase.ConnectionProvider;
import com.model.Student;
public class StudentDao {
	public int InsertStudent(Student s)
	{
		int check =0;
		Connection con=null;
		PreparedStatement pstmt=null;
		con=ConnectionProvider.getConnection();
		String sql="insert into student ( sname,scity,spercentage) values (?,?,?)";
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1,s.getSname());
			pstmt.setString(2, s.getScity());
			pstmt.setDouble(3, s.getSper());
		    check=pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally
		{
			new ConnectionProvider().CloseConnection(pstmt, con);
		}
		
		return check;
	}
	public int UpdateStudent( Student s)
	{
		int check=0;
		Connection con=null;
		PreparedStatement pstmt=null;
		con=ConnectionProvider.getConnection();
		String sql="update student set sname=?,scity=?,spercentage=? where sid=?";
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1,s.getSname());
			pstmt.setString(2,s.getScity());
			pstmt.setDouble(3,s.getSper());
			pstmt.setInt(4, s.getSid());
			check=pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally
		{
			new ConnectionProvider().CloseConnection(pstmt, con);
		}
		
		return check;
		
	}
	public int DeleteStudentByID(int id)
	{
		int check=0;
		Connection con=null;
		PreparedStatement pstmt=null;
		con=ConnectionProvider.getConnection();
		String sql="delete from student where sid=?";
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, id);
			check=pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally
		{
			new ConnectionProvider().CloseConnection(pstmt, con);
		}
		return check;
	}
	public Student DisplayStudentBYID(int id)
	{
		Student s=null;
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		con=ConnectionProvider.getConnection();
		String sql="select sid,sname,scity,spercentage from student where sid=?";
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, id);
			rs=pstmt.executeQuery();
			while(rs.next())
			{
				s=new Student();
				s.setSid((int)rs.getObject("sid"));
				s.setSname((String)rs.getObject("sname"));
				s.setScity((String)rs.getObject("scity"));
				s.setSper((double)rs.getDouble("spercentage"));
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		finally
		{
			new ConnectionProvider().CloseConnection(rs, pstmt, con);
		}
		return s;
	}
		
	

}
