<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Search</title>

<link href="css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<script src='https://kit.fontawesome.com/a076d05399.js'></script>
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/popper.min.js"></script>
<script type="text/javascript" src="js/bootstrap.min.js"></script>
<script type="text/javascript" src="js/validation.js"></script>

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
.hov:hover
{
	text-decoration:none; 
}
#ss
{
	padding-left: 50px;
    padding-right: 50px;
}
.msg
{
	color:red;
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

<div id="maindiv">
	<header>
	<nav class="navbar navbar-expand-lg navbar-dark " style="background-color:#03a9f4 !important">
    <a class="navbar-brand" href="index.html"><strong>V-CARPOOLING</strong></a>
	</nav>
	</header>
	<main style="height:600px;">
		<div class="main-div">
  			<div class="row">
  			<div class="col-sm-6" style="margin-top:50px;margin-left:50px;">
  			<form method="post" action="FetchProvider1" name="sform" onsubmit="return validSearch()">
  				<div class="form-group col-md-4">
      			<label for="inputState"><i style='font-size:24px' class='fas'>&#xf276;</i>&nbsp;<b>Source City</b></label>
      			<select id="inputState" class="form-control" name="origin">
        		<option value="SS">---SELECT---</option>
      			<option value="Perungudi">Perungudi</option>
      			<option value="D.B.Jain College">D.B.Jain College</option>
      			<option value="Mettukuppam">Mettukuppam</option>
      			<option value="P.T.C Quaters">P.T.C Quaters</option>
      			<option value="Thoraipakam">Thoraipakam</option>
      			<option value="Karapakkam">Karapakkam</option>
     			<option value="Sholinganallur">Sholinganallur</option>
      			<option value="Satyabhama">Satyabhama</option>
      			<option value="AGS Navalur">AGS Navalur</option>
      			<option value="Virtusa Navalur">Virtusa Navalur</option>
      			</select>
    			</div>
    			<div class="form-group col-md-4">
      			<label for="inputState"><i style='font-size:24px' class='fas'>&#xf3c5;</i>&nbsp;<b>Destination City<b></label>
      			<select id="inputState" class="form-control" name="destination">
        		<option value="SS">---SELECT---</option>
      			<option value="Perungudi">Perungudi</option>
      			<option value="D.B.Jain College">D.B.Jain College</option>
      			<option value="Mettukuppam">Mettukuppam</option>
      			<option value="P.T.C Quaters">P.T.C Quaters</option>
      			<option value="Thoraipakam">Thoraipakam</option>
      			<option value="Karapakkam">Karapakkam</option>
     			<option value="Sholinganallur">Sholinganallur</option>
      			<option value="Satyabhama">Satyabhama</option>
      			<option value="AGS Navalur">AGS Navalur</option>
      			<option value="Virtusa Navalur">Virtusa Navalur</option>
      			</select>
    			</div>
    			<label class="msg" id="message"></label>
    			<div class="form-group col-md-4">
  					<input class="btn btn-primary" id="ss" type="submit" value="Search">
  				</div>
			</form>
			</div>
			<div class="col-sm-" >
			<iframe src="https://www.google.com/maps/d/embed?mid=1iU_GKWjmpGFE-QPkwpqV-hg2Yxj4domX" width="400px" height="400px"></iframe>
			</div>
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
<!-- <footer class="page-footer font-small blue pt-4" style="height: -webkit-fill-available;">

  <div class="footer-copyright text-center py-3">© 2019 Copyright:
    <p> V-CARPOOLING</p>
  </div>

</footer> -->
</body>
      			
 </html>  	 	