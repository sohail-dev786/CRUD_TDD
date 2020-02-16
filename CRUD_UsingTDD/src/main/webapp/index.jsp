<%@page import="com.learnning.crudtest.models.UserModels"%>
<%@page import="java.util.List"%>
<%@page import="com.learnning.crudtest.DB_Connection"%>
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
<title> User Details</title>
<style>

body{
	
background: #11998e;  /* fallback for old browsers */
background: -webkit-linear-gradient(to right, #38ef7d, #11998e);  /* Chrome 10-25, Safari 5.1-6 */
background: linear-gradient(to right, #38ef7d, #11998e); /* W3C, IE 10+/ Edge, Firefox 16+, Chrome 26+, Opera 12+, Safari 7+ */


}

.table
{

background: #00F260;  /* fallback for old browsers */
background: -webkit-linear-gradient(to right, #0575E6, #00F260);  /* Chrome 10-25, Safari 5.1-6 */
background: linear-gradient(to right, #0575E6, #00F260); /* W3C, IE 10+/ Edge, Firefox 16+, Chrome 26+, Opera 12+, Safari 7+ */

-webkit-box-shadow: 3px 3px 37px 14px rgba(12,15,14,0.54);
-moz-box-shadow: 3px 3px 37px 14px rgba(12,15,14,0.54);
box-shadow: 3px 3px 37px 14px rgba(12,15,14,0.54);

text-align:center;
color:black;
font-size:18px;
text-transform:uppercase;
margin-top:20px;
}
.theadcss
{

background: #1c92d2;  /* fallback for old browsers */
background: -webkit-linear-gradient(to right, #f2fcfe, #1c92d2);  /* Chrome 10-25, Safari 5.1-6 */
background: linear-gradient(to right, #f2fcfe, #1c92d2); /* W3C, IE 10+/ Edge, Firefox 16+, Chrome 26+, Opera 12+, Safari 7+ */

color:black;
font-size:22px;
text-align:center;


}

#plus
{

font-size:40px;

}
.add a
{
	font-size: 20px;
	font-weight:bold;
	color:white;
	margin-bottom:10px;
}

</style>
</head>

<body>
	
	<%
	
		IDAO dbConnection = new DB_Connection();
		List<UserModels> userlist = dbConnection.getRecords();

		if (userlist.size() > 0) {
	%>
	<br>
	<br>
	<center>
<button class="btn btn-dark add"><a href='Register.jsp'><span id="plus">+</span>ADD NEW</a></button>
	</center>
	<br />
	<div class="container ">
	<table class="table table-dark ">
		<thead class=" theadcss">
			<tr >
				<th>ID</th>
				<th >NAME</th>
				 <th >EMAIL</th>
				 <th>ADDRESS</th>
				<th colspan="4" >PERFORM OPERATION</th> 
			</tr>
		</thead>
		<tbody>
			<%
				for (UserModels model : userlist) {
			%>
			<tr>

				<td>
					<%
						out.print(model.getId());
					%>
				</td>
				<td >
					<%
						out.print(model.getName());
					%>
				</td>
				<td >
					<%
						out.print(model.getEmail());
					%>
				</td>
				<td >
					<%
						out.print(model.getAddre());
					%>
				</td>
			
			<td><button type="button"  class="btn btn-success rounded-circlev view"><a href="viewById.jsp?userId=<%=model.getId()%> ">View</a></button></td>
			<td><button type="button"  class="btn btn-warning rounded-circlee edit"><a href="editById.jsp?userId=<%=model.getId()%> ">Edit</a></button></td>
			<td><button type="button"  class="btn btn-danger  rounded-circled delete"><a href="#" onclick="askConfirm('<%=model.getId()%>','<%=model.getName()%>')">Delete</a></button><td>
			</tr>
			<%
				}
			%>

		</tbody>
	</table>
</div>
	
	<%
		}
		else {
			
			out.print("<a href='#'>ADD NEW</a>");
		}
	%>
	
	
	<script type="text/javascript" rel="javascript">
	function askConfirm(userId,userNm)
	{
				
				var response=confirm("DO YOU WANT TO DELETE RECORD OF"+userNm+"!!!!");
					if(response)
						{
						
						window.location="http://localhost:8091/CRUD_UsingTDD/deleteById.jsp?userId="+userId;
						}
	
	}
	</script>

	
</body>
</html>