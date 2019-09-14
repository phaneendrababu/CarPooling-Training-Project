<%@ page import="bean.ProviderRegisterBean"%>
<%@ page language="java" import="java.sql.*,java.util.*,util.DBConnection" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Booking</title>
<link href="css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<script src='https://kit.fontawesome.com/a076d05399.js'></script>
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/popper.min.js"></script>
<script type="text/javascript" src="js/bootstrap.min.js"></script>
<script type="text/javascript" src="js/validation.js"></script>
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
.msg
{
	color:red;
}
</style>
</head>
<body onload="createOp()">
	<%
	Object obj1=session.getAttribute("id");
	String str = (String) obj1;
	int eid = Integer.parseInt(str);
	try
	{
		Connection con=DBConnection.createConnection();
		PreparedStatement ps=con.prepareStatement("SELECT FULL_NAME FROM V_USER WHERE EMP_ID=?");
		ps.setInt(1,eid);
		ResultSet rs=ps.executeQuery();
		while(rs.next())
		{%>
				<div class="alert alert-primary" role="alert">
  					Hey!!!<%out.println(rs.getString(1)); %>,thanks for choosing us
				</div>
		<% }
	}
	catch(Exception e)
	{ 
		e.printStackTrace();
		
	} 
	%>
	<%
			ArrayList<ProviderRegisterBean> fetchproviderdata=(ArrayList<ProviderRegisterBean>)request.getAttribute("fetchproviderdata");
			for(ProviderRegisterBean p:fetchproviderdata)
			{
				int pid=Integer.parseInt(p.getId());
				int seats=Integer.parseInt(p.getAvailable_seats());
				
	%>
	<div class="card" style="width: 50rem; margin-left: 100px;margin-top:50px">
  		<div class="card-body">
    		<h5 class="card-title">Booking Confirmation</h5>
    		<hr>
    		<form method="post" action="StoreHistory" name="book" onsubmit="return bookvalid()">
  <div class="form-group row">
    <div class="col-sm-10">
      <input type="hidden" class="form-control" value=<%=eid%> id="formGroupExampleInput" name="id" readonly>
    </div>
  </div>
  <div class="form-group row">
    <label for="inputEmail3" class="col-sm-2 col-form-label" >PROVIDER ID</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" value=<%=pid%> id="formGroupExampleInput" name="p_id" readonly>
    </div>
  </div>
  <div class="form-group row">
    <label for="inputEmail3" class="col-sm-2 col-form-label">NAME</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" value="<%=p.getName()%>" id="formGroupExampleInput" name="p_name" readonly>
    </div>
  </div>
  <div class="form-group row">
    <label for="inputEmail3" class="col-sm-2 col-form-label">MOBILE NO</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" value="<%=p.getMobile()%>" id="formGroupExampleInput" name="p_mobile" readonly>
    </div>
  </div>
  <div class="form-group row">
    <label for="inputEmail3" class="col-sm-2 col-form-label">EMAIL</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" value="<%=p.getEmail()%>" id="formGroupExampleInput" name="p_mail" readonly>
    </div>
  </div>
  <div class="form-group row">
    <label for="inputEmail3" class="col-sm-2 col-form-label">SEATS AVAIABLE</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" id="formGroupExampleInput" value="<%=seats%>" name="p_available_seats" readonly>
    </div>
  </div>
  <div class="form-group row">
    <label for="inputEmail3" id="op" class="col-sm-2 col-form-label">SEATS REQUIRED</label>
    <div class="col-sm-10">
      <select class="form-control"  id="exampleFormControlSelect1" name="p_booked_seats">
      
      </select>
      <label class="msg" id="message"></label>
    </div>
  </div>
  <div class="form-group row">
    <div class="col-sm-10">
    <a class="btn btn-primary" href="search.jsp" role="button" style="padding-right: 20px;"><i style="font-size:24px" class="fa">&#xf137;</i><b>CANCEL</b></a>
      <input type="submit" class="btn btn-info" style="background-color:#FFC107 ;border-color:#FFC107" value="CONFIRM">
    </div>
  </div>
  
  </form>
  		</div>
	</div>
<script>
function bookvalid()
{
	var p_booked_seats=document.forms["book"]["p_booked_seats"].value;
	var svalid=true;
	if(p_booked_seats==="SS")
	{
		document.getElementById('message').style.visibility="visible";
		document.getElementById('message').innerHTML="<sup>*</sup>Please select seats required";
		svalid =  false;
	}
	else
	{
		document.getElementById('message').style.visibility="hidden";
	}
	return svalid;
}
</script>
<script>
function createOp()
{
    var i;
    var x="<%=seats%>";
    var options="<option value='SS'>---SELECT---</option>";
    for (i=1;i<=x;i++){
      options+="<option value="+i+">"+i+"</option>";
    }
   document.getElementById("exampleFormControlSelect1").innerHTML=options;
}
</script>
<%}%>
</body>
</html>