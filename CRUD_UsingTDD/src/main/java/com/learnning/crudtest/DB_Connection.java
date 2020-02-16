package com.learnning.crudtest;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import javax.sql.StatementEvent;

import com.learnning.crudtest.models.UserModels;
import com.learnning.service.IDAO;

public class DB_Connection implements IDAO {

	String user = "sa";
	String pass = "";
	String url = "jdbc:h2:tcp://localhost/~/test";
	Connection conn;	
	UserModels model;
	PreparedStatement stmt;
	Statement cstmt;
	public boolean getConnected() {
		try {
			Class.forName("org.h2.Driver");
			conn = DriverManager.getConnection(url, user, pass);

		} catch (ClassNotFoundException e) {

			System.out.println(e.getMessage());
		} catch (SQLException e) {

			System.out.println(e.getMessage());
		}

		if (conn != null) {
			return true;
		} else {
			return false;
		}
	}

	public List<UserModels> getRecords() {
		List<UserModels> users = new ArrayList();

		if (getConnected()) {
			try {
				Statement statement = conn.createStatement();
				String query = "select * from userdetails";
				ResultSet resultset = statement.executeQuery(query);
				while (resultset.next()) {
					model = new UserModels();
					model.setId(resultset.getInt("id"));
					model.setName(resultset.getString("name"));
					model.setEmail(resultset.getString("email"));
					model.setAddre(resultset.getString("Addres"));

					users.add(model);
				}
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}

		}
		return users;
	}

	public UserModels getRecordsById(int i) {
		if (getConnected()) {
			String query = "select * from userdetails where id=?";
			try {
				PreparedStatement preparestmt = conn.prepareStatement(query);
				preparestmt.setInt(1, i);
				ResultSet resultset = preparestmt.executeQuery();
				if (resultset.next()) {
					model = new UserModels();
					model.setId(resultset.getInt("id"));
					model.setName(resultset.getString("name"));
					model.setEmail(resultset.getString("email"));
					model.setAddre(resultset.getString("Addres"));

				}

			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}

		return model;
	}

	/*
	 * public int editRecords(int i,UserModels model) {
	 * 
	 * int rowCount = 0; if (getConnected()) {
	 * System.out.println("Connection Successfully");
	 * 
	 * String query= "update USERDETAILS " + "set Addres=? " + "where id=?" ;
	 * 
	 * try { stmt = conn.prepareStatement(query); stmt.setInt(1, i);
	 * stmt.setString(2, model.getName()); stmt.setString(3,model.getEmail());
	 * stmt.setString(4, model.getAddre()); rowCount = stmt.executeUpdate();
	 * 
	 * } catch (SQLException e) { System.out.println("EditRecords Exception" +
	 * e.getMessage());
	 * 
	 * } }
	 * 
	 * return rowCount; }
	 */

	public int deleteRecords(int i) {
		int rowCount=0;
		
		if(getConnected())
		{
			System.out.println("connection Successfully");
			
			String query= "delete USERDETAILS "
					+ "WHERE ID=?" ;
			
			try
			{
				stmt=conn.prepareStatement(query);
				stmt.setInt(1,i);
				rowCount=stmt.executeUpdate();
			} 
			catch (SQLException e)
			{	
			System.out.println("Deleted Value Exception "+e.getMessage());
			}		
			
		}
		
		return rowCount;
	}

	public int columnAdded(String city) {
		int colCount=0;
		if(getConnected())
		{
			System.out.println("Connection Successfully");
			
			String query="ALTER TABLE USERDETAILS "
					+ " ADD " +city+ " varchar(50)";
			
			try {
				stmt=conn.prepareStatement(query);
				colCount=stmt.executeUpdate();					
			} 
			catch (SQLException e)
			{				
			System.out.println(e.getMessage());	
			}			
		}			
		return colCount;
	}

	public int columnDeleted(String citydel)
	{
		
		int colDeleted=0;
		if(getConnected())
		{
			System.out.println("connection Successfully");
		
			String query="ALTER TABLE USERDETAILS"
					+" DROP COLUMN "+citydel;
			
			try {
				stmt=conn.prepareStatement(query);
				colDeleted=stmt.executeUpdate();
				
			} catch (SQLException e) {
				System.out.println(e.getMessage());	
			}				
		}
		return colDeleted;
	}

	
	public int tableDeleted(String tabdel)
	{
		int tableDel=0;
		if(getConnected())
		{
			String query="DROP TABLE "
						+ tabdel;
			System.out.println("Connection Successfully");
			
			try {
				stmt=conn.prepareStatement(query);
				tableDel=stmt.executeUpdate();
			} 
			catch (SQLException e) {
				
				System.out.println(e.getMessage());
			}	
		}
		return tableDel;
	}

	
	public boolean insertingRecords(UserModels model) {
	
		int rowInserted=0;
		
		if(getConnected())
		{
			
			System.out.println("connection successfully !!!");
			
			String query="insert into userdetails values "
					+ "(?,?,?,?)";
			
			try {
				//model=new UserModels();
				PreparedStatement preparestmt = conn.prepareStatement(query);
			
				preparestmt.setInt(1, model.getId());
				preparestmt.setString(2, model.getName());
				preparestmt.setString(3, model.getEmail());
				preparestmt.setString(4, model.getAddre());
				
			
			/*	or we can assing in a variable
			 * 	
			 *  int id=model.getId();
				String name=model.getName();
				String email=model.getEmail();
				String addres=model.getAddre();
				*/
				
				rowInserted=preparestmt.executeUpdate();
				
				
			} catch (SQLException e) {	
				System.out.println(e.getMessage());
			}	
		}
		if (rowInserted>0) {
			return true;
		}
		else
		{
			return false;
		}
	}

	

	@Override
	public int editRecords(UserModels model) {
		
		int rowCount = 0;
		if (getConnected()) {
			System.out.println("Connection Successfully");
			
			  String query= "update USERDETAILS "
					  		+ "set Name=? ,Email=?,Addres=? "
					  		+ "where id=?" ;
			  
			  try {
				stmt = conn.prepareStatement(query);
				stmt.setString(1, model.getName());
				stmt.setString(2,model.getEmail());
				stmt.setString(3, model.getAddre());
				stmt.setInt(4, model.getId());
				rowCount = stmt.executeUpdate();
			    
			  } 
			  catch (SQLException e) 
			  {
				System.out.println("EditRecords Exception" + e.getMessage());

			   }
		}

		return rowCount;

		
		
	
	}




}
