
<%@page import="com.learnning.crudtest.DB_Connection.DB_Connection"%>
<%@page import="com.learnning.service.IDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>

<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>

<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="style.css">

<title>Delete  Jsp page</title>
</head>
<body>

<%
	int idDeleted=Integer.parseInt(request.getParameter("userId"));
	String userName=request.getParameter("userNm");
	
	IDAO dbConn=new DB_Connection();
	int deleteCount=dbConn.deleteRecords(idDeleted);
	
	if(deleteCount > 0)
	{
	%>

	
	<script type="text/javascript">
	console.log("inside deleted script");

	alert("Record Delete Successfully !!!");
	
	location="http://localhost:8080/CRUD_UsingTDD/index.jsp";
	
	</script>

<%	
	}
%>
	
</body>
</html>