<%@ page import="bean.ProviderRegisterBean"%>
<%@ page language="java" import="java.sql.*,java.util.*" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Available Providers</title>
<link href="css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<script src='https://kit.fontawesome.com/a076d05399.js'></script>
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/popper.min.js"></script>
<script type="text/javascript" src="js/bootstrap.min.js"></script>
<style>
.bb
{
	color:white;
}
.bs
{
	color:white;
}
.pid
{
	background: #99d6ff;
    border: none;
    color: white;
    font-weight:bold;
    outline:none;
    width:100px;
}
</style>
</head>
<body>
			<div class="card">
  				<div class="card-body">
  					<a class="btn btn-primary" href="search1.jsp" role="button" style="padding-right: 20px;"><i style="font-size:24px" class="fa">&#xf137;</i><b>BACK</b></a>
  					<span style="margin-left: 150px;"><b>If you want book please<a class="btn btn-primary" href="login.html" role="button" style="padding-right: 20px;"><b>LOGIN</b><i style="font-size:24px" class="fa">&#xf138;</i></a></b></span>
 				</div>
				</div>
				<div class="row" style="background-color: #007bff;height: 50px;">
  				<div class="col"><b class="bb"><i style='font-size:24px' class='fas'>&#xf2c1;</i>EMPLOYEE ID</b></div>
  				<div class="col"><b class="bb"><i style="font-size:24px" class="fa">&#xf2bd;</i>NAME</b></div>
  				<div class="col"><b class="bb"><i style="font-size:24px" class="fa">&#xf017;</i>START TIME</b></div>
  				<div class="col"><b class="bb"><i style="font-size:24px" class="fa">&#xf2f2;</i>RETURN TIME</b></div>
  				<div class="col"><b class="bb"><i style='font-size:24px' class='fab'>&#xf368;</i>AVAILABLE SEATS</b></div>
  				<div class="col"><b class="bb"><i style="font-size:24px" class="fa">&#xf095;</i>CONTACT</b></div>
  				<div class="col"><b class="bb"><i style="font-size:24px" class="fa">&#xf0e0;</i>EMAIL</b></div>
				</div>	
			<%
			ArrayList<ProviderRegisterBean> fetchdata=(ArrayList<ProviderRegisterBean>)request.getAttribute("fetchdata");
			for(ProviderRegisterBean p:fetchdata)
			{
				int pid=Integer.parseInt(p.getId());
			%>
			
				<div class="row" style="background-color: #99d6ff;height: 50px;">
				<div class="col"><b class="bb"><%=pid%></b></div>
  				<div class="col"><b class="bb"><%=p.getName()%></b></div>
  				<div class="col"><b class="bb"><%=p.getStart_time() %></b></div>
  				<div class="col"><b class="bb"><%=p.getReturn_time() %></b></div>
  				<div class="col"><b class="bb"><%=p.getAvailable_seats() %></b></div>
  				<div class="col"><b class="bb"><%=p.getMobile()%></b></div>
  				<div class="col"><b class="bb"><%=p.getEmail() %></b></div>
				</div>
				
			<% }%>
</body>
</html>