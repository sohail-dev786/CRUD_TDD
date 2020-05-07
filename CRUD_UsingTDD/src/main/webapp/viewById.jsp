
<%@page import="com.learnning.crudtest.DB_Connection.DB_Connection"%>
<%@page import="com.learnning.crudtest.models.UserModels"%>

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

<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
	
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

	

<title>VIEW USERDETAILS</title>
</head>

<style>

body{
	
background: #11998e;  /* fallback for old browsers */
background: -webkit-linear-gradient(to right, #38ef7d, #11998e);  /* Chrome 10-25, Safari 5.1-6 */
background: linear-gradient(to right, #38ef7d, #11998e); /* W3C, IE 10+/ Edge, Firefox 16+, Chrome 26+, Opera 12+, Safari 7+ */


}


.card
{

-webkit-box-shadow: 3px 3px 37px 14px rgba(12,15,14,0.54);
-moz-box-shadow: 3px 3px 37px 14px rgba(12,15,14,0.54);
box-shadow: 3px 3px 37px 14px rgba(12,15,14,0.54);

margin-top:100px;
border-radius:25px;
}
.card-body
{

height:400px;;
padding:10px;

}

.card-title
{

line-height:30px;

}


.card-text
{

margin-top:40px;
margin-bottom:50px;
}

label
{

font-size:15px;
margin-left:10px;
margin-right:5px;
font-weight:bold;

}


.viewedit
{
margin-right:10px;
font-size:20px;
padding:10px;
text-transform:uppercase;
}
.viewdelete
{
font-size:20px;
padding:10px;
text-transform:uppercase;



}
</style>





<body>

<center>
<div class="container mt-5 mycraddiv">
<div class="card" style="width:18rem;">
 	<%
 	int userId=Integer.parseInt(request.getParameter("userId"));
 	IDAO dbConnection=new DB_Connection();
 	UserModels model=dbConnection.getRecordsById(userId);
 	
 	%>
  <div class="card-body" >
    <h5 class="card-title mt-3"><%= model.getName() %></h5><hr>
    <p class="card-text ">
    
    <LABEL>ID :<span><%= model.getId()%></span></LABEL><br/>
    <LABEL>NAME :<span><%= model.getName()%></span></LABEL><br/>
    <LABEL>EMAIL :<span><%= model.getEmail() %></span></LABEL><br/>
    <LABEL>ADDRESS :<span><%= model.getAddre() %></span></LABEL><br/>
    
    
    </p>
    
	<a href="editById.jsp?userId=<%=userId%>" class="btn btn-warning btn-lg btn-hover viewedit">Edit</a>
	<a href="deleteByID.jsp?userId=<%=userId %>" class="btn btn-danger btn-lg viewdelete">Delete</a>
  	
  </div>
</div>
</div>
</center>
</body>
</html>