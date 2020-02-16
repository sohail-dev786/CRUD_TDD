package com.learnning.crudtest;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import com.learnning.crudtest.models.UserModels;
import com.learnning.service.IDAO;

public class CRUD_Test {

	IDAO dbConnection=new DB_Connection();
	
	@Ignore
	@Test
	public void testConnection()
	{
		boolean isConnected=dbConnection.getConnected();
		assertEquals(true, isConnected);
	}
	
	
	
	@Test
	public void testInsertValues()
	{
		
		UserModels model=new UserModels();
		model.setId(3);
		model.setName("shahrukh");
		model.setEmail("shahrukh@gmail.com");
		model.setAddre("borivali");
		boolean recordsInserted=dbConnection.insertingRecords(model);
		assertEquals(true, recordsInserted);
		
	}
	
	
	@Ignore
	@Test
	public void editRecordTest()
	{	
		UserModels model=new UserModels();
		model.setId(8);
		model.setName("shahrukh");
		model.setEmail("shahrukh@gmail.com");
		model.setAddre("borivali");
		int rowAffected=dbConnection.editRecords(model);
		assertEquals(1, rowAffected);
		
	}
	
	@Ignore
	@Test
	public void testRecords()
	{
		List<UserModels> userList=new ArrayList();
		userList=dbConnection.getRecords();
		assertEquals(true,userList.size()>0);
		
	}
	
	
	@Ignore
	@Test
	public void testRecordById()
	  {
		
		UserModels model=dbConnection.getRecordsById(2);
		String userName=model.getName();
		assertEquals("VIRAL", userName);
		

	  
	  }
	
	
	@Ignore
	@Test
	public void deleteRecordTest()
	{
		int rowDeleted=dbConnection.deleteRecords(3);
		assertEquals(1,rowDeleted);
	}
	
	@Ignore
	@Test
	public void addColTest()
	{
		int colAdded=dbConnection.columnAdded("city");
		assertEquals(0, colAdded);
	}
	
	@Ignore
	@ Test
	public void dropColTest()
	{	
		int colDeleted=dbConnection.columnDeleted("city");
		assertEquals(0, colDeleted);
		
	}
	@Ignore
	@Test
	public void dropTableTest()
	{
		int tableDel=dbConnection.tableDeleted("demo");
		assertEquals(0, tableDel);
	}
}
