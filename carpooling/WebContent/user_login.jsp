<%@ page language="java" import="java.sql.*,util.DBConnection" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
<head>
<link href="css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<script src='https://kit.fontawesome.com/a076d05399.js'></script>
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/popper.min.js"></script>
<script type="text/javascript" src="js/bootstrap.min.js"></script>

<style>
.windows-loader {
  width: 100vw;
  height: 100vh;
}
.windows-loader .ball {
  border-radius: 50%;
  background: orange;
  position: absolute;
  transform: translate(-50%, -50%);
  transform-origin: 40px 40px;
}
.windows-loader .ball:nth-child(1) {
  width: 17.5px;
  height: 17.5px;
  left: calc(50% -  40px);
  top: calc(50% - 40px);
  animation: spin 2s 0.075s ease-in-out infinite;
}
.windows-loader .ball:nth-child(2) {
  width: 15px;
  height: 15px;
  left: calc(50% -  40px);
  top: calc(50% - 40px);
  animation: spin 2s 0.15s ease-in-out infinite;
}
.windows-loader .ball:nth-child(3) {
  width: 12.5px;
  height: 12.5px;
  left: calc(50% -  40px);
  top: calc(50% - 40px);
  animation: spin 2s 0.225s ease-in-out infinite;
}
.windows-loader .ball:nth-child(4) {
  width: 10px;
  height: 10px;
  left: calc(50% -  40px);
  top: calc(50% - 40px);
  animation: spin 2s 0.3s ease-in-out infinite;
}
.windows-loader .ball:nth-child(5) {
  width: 7.5px;
  height: 7.5px;
  left: calc(50% -  40px);
  top: calc(50% - 40px);
  animation: spin 2s 0.375s ease-in-out infinite;
}
.windows-loader .ball:nth-child(6) {
  width: 5px;
  height: 5px;
  left: calc(50% -  40px);
  top: calc(50% - 40px);
  animation: spin 2s 0.45s ease-in-out infinite;
}
.windows-loader .ball:nth-child(7) {
  width: 2.5px;
  height: 2.5px;
  left: calc(50% -  40px);
  top: calc(50% - 40px);
  animation: spin 2s 0.525s ease-in-out infinite;
}
.windows-loader .ball:nth-child(8) {
  width: 0px;
  height: 0px;
  left: calc(50% -  40px);
  top: calc(50% - 40px);
  animation: spin 2s 0.6s ease-in-out infinite;
}
body {
  margin: 0;
}
.main-div
{
	margin-top: 50px;
}
.rad
{
	border-radius:40px;
}
@keyframes spin {
  0% {
    transform: rotate(0deg) translate(-50%, -50%);
  }
  90% {
    transform: rotate(360deg) translate(-50%, -50%);
  }
}
.sp
{
float: left;
width: 10%;
height: 550px; /* only for demonstration, should be removed */
background: #ccc;
/*padding: 20px;*/
margin-top: -50px;
}
.sp1
{
float: right;
width: 90%;
height: 550px; /* only for demonstration, should be removed */
/*background: #ccc;*/
/*padding: 20px;*/
margin-top: -50px;
}
.hov:hover
{
	text-decoration:none; 
}
.sp1 p
{
	text-align:center;
	font-weight:bold;
	font-size:25px;
}
</style>
</head>
<body onload="myFunction()">
<div class="windows-loader" id="loader">
  <div class="ball" ></div>
  <div class="ball" ></div>
  <div class="ball" ></div>
  <div class="ball" ></div>
  <div class="ball" ></div>
  <div class="ball" ></div>
  <div class="ball" ></div>
  <div class="ball" ></div>
</div>

<%
response.setHeader("Cache-Control","no-cache,no-store,must-revalidate");
    if(session.getAttribute("id")==null)
    {
    response.sendRedirect("login.html");
    }
	Object obj1=session.getAttribute("id");
	String str = (String) obj1;
	int eid = Integer.parseInt(str);
	//out.println(eid);
%>
<div id="maindiv">
	<header>
	<nav class="navbar navbar-expand-lg navbar-dark " style="background-color:#03a9f4 !important">
    <a class="navbar-brand" href="index.jsp"><strong>V-CARPOOLING</strong></a>
	</nav>
	</header>
	<main style="height:600px;">
		<div class="main-div">
  			<div class="sp">
  			<img src="img/user.png" class="img-thumbnail">
  			<ul class="list-group">
  				<li class="list-group-item"><b><%out.println("ID: "+eid); %></b></li>
  				<li class="list-group-item"><b id="time"></p></b></li>
  				<a href="user_login.jsp" class="hov"><li class="list-group-item"><i style='font-size:24px' class='fas'>&#xf015;</i>Home</li></a>
  				<a href="search.jsp" class="hov"><li class="list-group-item"><i style='font-size:24px' class='fas'>&#xf002;</i>Search</li></a>
  				<a href="update_det.jsp " class="hov"><li class="list-group-item"><i style='font-size:24px' class='fas'>&#xf4ff;</i>Update</li></a>
  				<a href="LogoutServlet" class="hov"><li class="list-group-item"><i style='font-size:24px' class='fas'>&#xf011;</i>Logout</li></a>
			</ul>
			</div>
			
			<%
			try
			{
				
				Connection con=DBConnection.createConnection();
	            PreparedStatement ps=con.prepareStatement("SELECT * FROM V_HISTORY WHERE u_id=? order by time DESC");
	            ps.setInt(1,eid);
	            ResultSet rs=ps.executeQuery();
			%>
			
			<div class="sp1">
			<div class="card">
  				<div class="card-body">
  				<span><p><i style="font-size:30px;color:red;" class="fa">&#xf1da;</i>YOUR PREVIOUS BOOKINGS</p></span>
 			</div>
 			<%
 			while(rs.next())
 			{%>
 			<div class="row" style="background-color: #03a9f4;height: 50px; margin-left:0px;">
 			<p style="color:white;margin-left:50px; font-size:20px">
 			<i style='font-size:24px' class='far'>&#xf274;</i>
 			Booked <%=rs.getInt(9) %> seats on <%=rs.getString(10) %>
 			</p>
 			<p style="color:white;margin-left:150px; font-size:20px">
 			Provider Name:<%=rs.getString(2) %>
 			</p>
 			</div>
 			<%}
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
 			%>
 			</div>
		</div>
		
		
	</main>
</div>
<script>
var myVar;
function myFunction() {
    myVar = setTimeout(showPage, 3000);
}
function showPage() {
  document.getElementById("loader").style.display = "none";
  document.getElementById("maindiv").style.display = "block";
}
</script>
<script>
var myVar = setInterval(myTimer, 1000);

function myTimer() {
  var d = new Date();
  document.getElementById("time").innerHTML = d.toLocaleTimeString();
}
</script>
<!-- <footer class="page-footer font-small blue pt-4" style="height: -webkit-fill-available;">
  <div class="footer-copyright text-center py-3">© 2019 Copyright:
    <p> V-CARPOOLING</p>
  </div>
</footer>-->
</body>
 </html>  