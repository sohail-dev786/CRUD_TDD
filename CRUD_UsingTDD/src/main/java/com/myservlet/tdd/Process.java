package com.myservlet.tdd;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.learnning.crudtest.DB_Connection;
import com.learnning.crudtest.models.UserModels;
import com.learnning.service.IDAO;


//@WebServlet("/Process/*")

public class Process extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private IDAO mydao;
    
    public Process() {
        super();
    
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		PrintWriter out=response.getWriter();
		String action = request.getPathInfo().toString();
		System.out.print(action);
	      
	            switch (action) {
	       
	            case "/insert":
	            	//System.out.println("inside insert record");
	            	insertRecord(request, response);
	            	break;
	      
	            case "/edit":
	            	//System.out.println("inside edit Records");
	            	UpdateRecord(request, response);
	                break;
	            	
	            default:
	            	System.out.println("Path Not Found");
	                break;
	                          
	            }
	        
	}

	
	
	
	private void  insertRecord(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException
	{
	response.setContentType("text/html");
	PrintWriter out=response.getWriter();

	UserModels models=new UserModels();
	
	int uid=Integer.parseInt(request.getParameter("id"));
	String uname=request.getParameter("name");
	String uemail=request.getParameter("email");
	String uaddres=request.getParameter("addres");

	models.setId(uid);
	models.setName(uname);
	models.setEmail(uemail);
	models.setAddre(uaddres);
	
	mydao=new DB_Connection();	
	if(mydao.insertingRecords(models))
	{
			
		response.sendRedirect("http://localhost:8091/CRUD_UsingTDD/index.jsp");  

	}
	else
	{
		
		response.sendRedirect("http://localhost:8091/CRUD_UsingTDD/Register.jsp");  
    	
	}
		
	}
	
	
	private void  UpdateRecord(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException
	{
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();

		UserModels models=new UserModels();
		
		int uid=Integer.parseInt(request.getParameter("id"));
		String uname=request.getParameter("name");
		String uemail=request.getParameter("email");
		String uaddres=request.getParameter("addres");

		models.setId(uid);
		models.setName(uname);
		models.setEmail(uemail);
		models.setAddre(uaddres);
		
		
		mydao=new DB_Connection();	
		mydao.editRecords(models);
		
		
		/*
		 * RequestDispatcher rd=request.getRequestDispatcher(
		 * "http://localhost:8091/CRUD_UsingTDD/index.jsp"); rd.include(request,
		 * response);
		 */
		
		out.print("<script type='text/javascript'>");
		
		out.print(" window.location='http://localhost:8091/CRUD_UsingTDD/index.jsp'");
		
		out.print("</script>");
		
		
		
		
		
	}
	
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}

}
