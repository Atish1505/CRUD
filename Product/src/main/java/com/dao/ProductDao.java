package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.MyDatabase.ConnectionProvider;
import com.model.Product;

public class ProductDao {
	public int InsertProduct(Product p)
	{
		int check=0;
		PreparedStatement pstmt=null;
		Connection con=null;
		con=ConnectionProvider.getConnection();
		String sql="insert into product(pname,pcategory,qty,price) values (?,?,?,?)";
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, p.getPname());
			pstmt.setString(2, p.getPcategory());
			pstmt.setInt(3, p.getQty());
			pstmt.setDouble(4, p.getPrice());
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
	public int UpdateProduct(Product p)
	{
		int check=0;
		PreparedStatement pstmt=null;
		Connection con=null;
		con=ConnectionProvider.getConnection();
		String sql="update product set pname=? ,pcategory=?,qty=?,price=? where pid=?";
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1,p.getPname());
			pstmt.setString(2, p.getPcategory());
			pstmt.setInt(3, p.getQty());
			pstmt.setDouble(4, p.getPrice());
			pstmt.setInt(5, p.getPid());
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
	
	public int DeleteProduct(int id)
	{
		int check=0;
		Connection con=null;
		PreparedStatement pstmt=null;
		con=ConnectionProvider.getConnection();
		String sql="delete from product where pid=?";
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
	
	public Product DisplayProductByID(int id)
	{
		Product p=null;
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		con=ConnectionProvider.getConnection();
		String sql="select pid,pname,pcategory,qty,price from product where pid=?";
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, id);
			rs=pstmt.executeQuery();
			while(rs.next())
			{
				p=new Product();
				p.setPid((int)rs.getObject("pid"));
				p.setPname((String)rs.getObject("pname"));
				p.setPcategory((String)rs.getObject("pcategory"));
				p.setQty((int)rs.getObject("qty"));
				p.setPrice((double)rs.getObject("price"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally
		{
			new ConnectionProvider().CloseConnection(rs, pstmt, con);
		}
		
		return p;
	}

}
