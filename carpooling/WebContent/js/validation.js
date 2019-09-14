function userValidate()
{
	
	var emp_id=document.forms["usignin"]["emp_id"].value;
	var password=document.forms["usignin"]["password"].value;
	
	var isvalid=true;
	
	if(emp_id==null||emp_id=="")
	{
		document.getElementById('message').style.visibility="visible";
		document.getElementById('message').innerHTML="Employee id Field must not be blank";
		isvalid =  false;
	}
	else
	{
		document.getElementById('message').style.visibility="hidden";
	} 
	if(password==null||password=="")
	{
		document.getElementById('message1').style.visibility="visible";
		document.getElementById('message1').innerHTML="Password Field must not be blank";
		isvalid =  false;
	}
	else
	{
		document.getElementById('message1').style.visibility="hidden";
	}
	return isvalid;
}
function providerValidate() 
{
	var provider_id=document.forms["psignin"]["provider_id"].value;
	var password=document.forms["psignin"]["password"].value;
	
	var pvalid=true;
	
	if(provider_id==null||provider_id=="")
	{
		document.getElementById('message').style.visibility="visible";
		document.getElementById('message').innerHTML="Employee id Field must not be blank";
		pvalid =  false;
	}
	else
	{
		document.getElementById('message').style.visibility="hidden";
	}
	if(password==null||password=="")
	{
		document.getElementById('message1').style.visibility="visible";
		document.getElementById('message1').innerHTML="Password Field must not be blank";
		pvalid =  false;
	}
	else
	{
		document.getElementById('message1').style.visibility="hidden";
	}
	return pvalid;
	
}
function registerValidate()
{

	var emp_id=document.forms["signup"]["emp_id"].value;
	var full_name=document.forms["signup"]["full_name"].value;
	var gender=document.forms["signup"]["gender"].value;
	var mobile_no=document.forms["signup"]["mobile_no"].value;
	var email=document.forms["signup"]["email"].value;
	var password=document.forms["signup"]["password"].value;

	var isValid = true;

	if(emp_id==null || emp_id=="")
	{
		document.getElementById('message').style.visibility="visible";
		document.getElementById('message').innerHTML="Employee id Field must not be blank";
		isValid =  false;

	}
	else
	{
		if(isNaN(emp_id))
		{
			document.getElementById('message').style.visibility="visible";
			document.getElementById('message').innerHTML="Employee id must not contain letters";
			isValid =  false;
		}
		else
		{
			document.getElementById('message').style.visibility="hidden";
		}
	}
	if(full_name==null || full_name=="")
	{
		document.getElementById('message1').style.visibility="visible";
		document.getElementById('message1').innerHTML="Name Field must not be blank";
		isValid =  false;
	}
	else
	{
		var pat = /^[a-zA-Z ]+$/;
		if(full_name.match(pat))
		{
			document.getElementById('message1').style.visibility="hidden";
		}
		else
		{
			document.getElementById('message1').style.visibility="visible";
		    document.getElementById('message1').innerHTML="Name should not contain special characters or digits";
		    isValid =  false;
		}
    }
	if(gender[0]==null || gender[0]==""||gender[1]==null || gender[1]=="")
	{
		document.getElementById('message2').style.visibility="visible";
		document.getElementById('message2').innerHTML="Gender Field must not be blank";
		isValid =  false;
	}
	else
	{
		document.getElementById('message3').style.visibility="hidden";
    }
	if(mobile_no==null || mobile_no=="")
	{
		document.getElementById('message3').style.visibility="visible";
		document.getElementById('message3').innerHTML="Mobile No Field must not be blank";
		isValid =  false;
	}
	else
	{
		if(mobile_no.length!=10)
		{
			document.getElementById('message3').style.visibility="visible";
			document.getElementById('message3').innerHTML="Mobile No should contain exactly 10 digits";
			isValid =  false;
		}
		else if(isNaN(mobile_no))
		{
			document.getElementById('message3').style.visibility="visible";
			document.getElementById('message3').innerHTML="Mobile No should not contain letters or special characters";
			isValid =  false;
		}
		else	
		{
			document.getElementById('message3').style.visibility="hidden";
		}
    }
	if(email==null || email=="")
	{
		document.getElementById('message4').style.visibility="visible";
		document.getElementById('message4').innerHTML="Email Field must not be blank";
		isValid =  false;
	}
	else
	{
		if(email.lastIndexOf('@')<1||(email.charAt(email.length-4)!='.'))
		{
			document.getElementById('message4').style.visibility="visible";
		    document.getElementById('message4').innerHTML="Incorrect email format";
		    isValid =  false;
		}
		else	
		{
			document.getElementById('message4').style.visibility="hidden";
		}
		
    }
	if(password==null || password=="")
	{
		document.getElementById('message5').style.visibility="visible";
		document.getElementById('message5').innerHTML="Password Field must not be blank";
		isValid =  false;
	}
	else
	{
		var lower =/[a-z]/g;
		var upper =/[A-Z]/g;
		var numbers =/[0-9]/g;
		var special=/[@#$%^&*]/g;
		if(password.match(lower)==null)
		{
			document.getElementById('message5').style.visibility="visible";
			document.getElementById('message5').innerHTML="Password should cotain atleast one lower case character";
			isValid =  false;
		}
		else if(password.match(upper)==null)
		{
			document.getElementById('message5').style.visibility="visible";
			document.getElementById('message5').innerHTML="Password should cotain atleast one upper case character";
			isValid =  false;
		}
		else if(password.match(numbers)==null)
		{
			document.getElementById('message5').style.visibility="visible";
			document.getElementById('message5').innerHTML="Password should cotain atleast one numeric value";
			isValid =  false;
		}
		else if(password.match(special)==null)
		{
			document.getElementById('message5').style.visibility="visible";
			document.getElementById('message5').innerHTML="Password must contain anyone of these @,#,$,%,^,&,*";
			isValid =  false;
		}
		else if(password.length<8||password.length>15)
		{
			document.getElementById('message5').style.visibility="visible";
			document.getElementById('message5').innerHTML="Password length must be in between 8-15 characters";
			isValid =  false;
		}
		else
		{
			document.getElementById('message5').style.visibility="hidden";
		}
    }
  return isValid;
}
function updateValidate()
{

	var emp_id=document.forms["update"]["emp_id"].value;
	var full_name=document.forms["update"]["full_name"].value;
	var gender=document.forms["update"]["gender"].value;
	var mobile_no=document.forms["update"]["mobile_no"].value;
	var email=document.forms["update"]["email"].value;
	var password=document.forms["update"]["password"].value;

	var isValid = true;

	if(emp_id==null || emp_id=="")
	{
		document.getElementById('message').style.visibility="visible";
		document.getElementById('message').innerHTML="Employee id Field must not be blank";
		isValid =  false;

	}
	else
	{
		if(isNaN(emp_id))
		{
			document.getElementById('message').style.visibility="visible";
			document.getElementById('message').innerHTML="Employee id must not contain alphanumeric characters";
			isValid =  false;
		}
		else
		{
			document.getElementById('message').style.visibility="hidden";
		}
	}
	if(full_name==null || full_name=="")
	{
		document.getElementById('message1').style.visibility="visible";
		document.getElementById('message1').innerHTML="Name Field must not be blank";
		isValid =  false;
	}
	else
	{
		var pat = /^[a-zA-Z ]+$/;
		if(full_name.match(pat))
		{
			document.getElementById('message1').style.visibility="hidden";
		}
		else
		{
			document.getElementById('message1').style.visibility="visible";
		    document.getElementById('message1').innerHTML="Name should not contain special charcters or digits";
		    isValid =  false;
		}
    }
	if(gender[0]==null || gender[0]==""||gender[1]==null || gender[1]=="")
	{
		document.getElementById('message2').style.visibility="visible";
		document.getElementById('message2').innerHTML="Gender Field must not be blank";
		isValid =  false;
	}
	else
	{
		document.getElementById('message2').style.visibility="hidden";
    }
	if(mobile_no==null || mobile_no=="")
	{
		document.getElementById('message3').style.visibility="visible";
		document.getElementById('message3').innerHTML="Mobile No Field must not be blank";
		isValid =  false;
	}
	else
	{
		if(mobile_no.length!=10)
		{
			document.getElementById('message3').style.visibility="visible";
			document.getElementById('message3').innerHTML="Mobile No should contain exactly 10 digits";
			isValid =  false;
		}
		else if(isNaN(mobile_no))
		{
			document.getElementById('message3').style.visibility="visible";
			document.getElementById('message3').innerHTML="Mobile No should not contain letters or special characters";
			isValid =  false;
		}
		else	
		{
			document.getElementById('message3').style.visibility="hidden";
		}
    }
	if(email==null || email=="")
	{
		document.getElementById('message4').style.visibility="visible";
		document.getElementById('message4').innerHTML="Email Field must not be blank";
		isValid =  false;
	}
	else
	{
		if(email.lastIndexOf('@')<1||(email.charAt(email.length-4)!='.'))
		{
			document.getElementById('message4').style.visibility="visible";
		    document.getElementById('message4').innerHTML="Incorrect email format";
		    isValid =  false;
		}
		else	
		{
			document.getElementById('message4').style.visibility="hidden";
		}
		
    }
	if(password==null || password=="")
	{
		document.getElementById('message5').style.visibility="visible";
		document.getElementById('message5').innerHTML="Password Field must not be blank";
		isValid =  false;
	}
	else
	{
		var lower =/[a-z]/g;
		var upper =/[A-Z]/g;
		var numbers =/[0-9]/g;
		var special=/[@#$%^&*]/g;
		if(password.match(lower)==null)
		{
			document.getElementById('message5').style.visibility="visible";
			document.getElementById('message5').innerHTML="Password should cotain atleast one lower case character";
			isValid =  false;
		}
		else if(password.match(upper)==null)
		{
			document.getElementById('message5').style.visibility="visible";
			document.getElementById('message5').innerHTML="Password should cotain atleast one upper case character";
			isValid =  false;
		}
		else if(password.match(numbers)==null)
		{
			document.getElementById('message5').style.visibility="visible";
			document.getElementById('message5').innerHTML="Password should cotain atleast one numeric value";
			isValid =  false;
		}
		else if(password.match(special)==null)
		{
			document.getElementById('message5').style.visibility="visible";
			document.getElementById('message5').innerHTML="Password must contain anyone of these @,#,$,%,^,&,*";
			isValid =  false;
		}
		else if(password.length<8||password.length>15)
		{
			document.getElementById('message5').style.visibility="visible";
			document.getElementById('message5').innerHTML="Password length must be in between 8-15 characters";
			isValid =  false;
		}
		else
		{
			document.getElementById('message5').style.visibility="hidden";
		}
    }
  return isValid;
}
function validSearch()
{
	var origin=document.forms["sform"]["origin"].value;
	var destination=document.forms["sform"]["destination"].value;
	
	var isValid=true;
	if(origin==="SS"||destination==="SS")
	{
		document.getElementById('message').style.visibility="visible";
		document.getElementById('message').innerHTML="<sup>*</sup>Please select a city";
		isValid =  false;
	}
	else if(origin===destination)
	{
		document.getElementById('message').style.visibility="visible";
		document.getElementById('message').innerHTML="<sup>*</sup>Source and Destination should not be same";
		isValid =  false;
	}
	else
	{
		document.getElementById('message').style.visibility="hidden";
	}
	return isValid;
}
function removeMsg()
{
	document.getElementById('message').style.visibility="hidden";
	document.getElementById('message1').style.visibility="hidden";
	document.getElementById('message2').style.visibility="hidden";
	document.getElementById('message3').style.visibility="hidden";
	document.getElementById('message4').style.visibility="hidden";
	document.getElementById('message5').style.visibility="hidden";
}
function providerRegisterValidate()
{
	var emp_id=document.forms["psignup"]["emp_id"].value;
	var full_name=document.forms["psignup"]["full_name"].value;
	var gender=document.forms["psignup"]["gender"].value;
	var mobile_no=document.forms["psignup"]["mobile_no"].value;
	var origin=document.forms["psignup"]["origin"].value;
	var destination=document.forms["psignup"]["destination"].value;
	var start_time=document.forms["psignup"]["start_time"].value;
	var return_time=document.forms["psignup"]["return_time"].value;
	var seats=document.forms["psignup"]["seats"].value;
	var email=document.forms["psignup"]["email"].value;
	var password=document.forms["psignup"]["password"].value;
	
	var pvalid=true;
	if(emp_id==null||emp_id=="")
	{
		document.getElementById('message').style.visibility="visible";
		document.getElementById('message').innerHTML="Employee Id Field should not be blank";
		pvalid =  false;
	}
	else
	{
		if(isNaN(emp_id))
		{
			document.getElementById('message').style.visibility="visible";
			document.getElementById('message').innerHTML="Employee id must not contain letters and special characters";
			pvalid =  false;
		}
		else
		{
			document.getElementById('message').style.visibility="hidden";
		}
	}
	if(full_name==null || full_name=="")
	{
		document.getElementById('message1').style.visibility="visible";
		document.getElementById('message1').innerHTML="Name Field must not be blank";
		pvalid =  false;
	}
	else
	{
		var pat = /^[a-zA-Z ]+$/;
		if(full_name.match(pat))
		{
			document.getElementById('message1').style.visibility="hidden";
		}
		else
		{
			document.getElementById('message1').style.visibility="visible";
		    document.getElementById('message1').innerHTML="Name should not contain special charcters or digits";
		    pvalid =  false;
		}
    }
	if(gender[0]==null || gender[0]==""||gender[1]==null || gender[1]=="")
	{
		document.getElementById('message2').style.visibility="visible";
		document.getElementById('message2').innerHTML="Gender Field must not be blank";
		pvalid =  false;
	}
	else
	{
		document.getElementById('message2').style.visibility="hidden";
    }
	if(mobile_no==null || mobile_no=="")
	{
		document.getElementById('message3').style.visibility="visible";
		document.getElementById('message3').innerHTML="Mobile No Field must not be blank";
		pvalid =  false;
	}
	else
	{
		if(mobile_no.length!=10)
		{
			document.getElementById('message3').style.visibility="visible";
			document.getElementById('message3').innerHTML="Mobile No should contain exactly 10 digits";
			pvalid =  false;
		}
		else if(isNaN(mobile_no))
		{
			document.getElementById('message3').style.visibility="visible";
			document.getElementById('message3').innerHTML="Mobile No should not contain letters or special characters";
			pvalid =  false;
		}
		else	
		{
			document.getElementById('message3').style.visibility="hidden";
		}
    }
	if(origin==="SS"||destination==="SS")
	{
		document.getElementById('message4').style.visibility="visible";
		document.getElementById('message4').innerHTML="<sup>*</sup>Please select a city";
		pvalid =  false;
	}
	else if(origin===destination)
	{
		document.getElementById('message4').style.visibility="visible";
		document.getElementById('message4').innerHTML="<sup>*</sup>Source and Destination should not be same";
		pvalid =  false;
	}
	else
	{
		document.getElementById('message4').style.visibility="hidden";
	}
	if(start_time==="SS"||return_time==="SS")
	{
		document.getElementById('message5').style.visibility="visible";
		document.getElementById('message5').innerHTML="<sup>*</sup>Please select time";
		pvalid =  false;
	}
	else
	{
		document.getElementById('message5').style.visibility="hidden";
	}
	if(seats==="SS")
	{
		document.getElementById('message6').style.visibility="visible";
		document.getElementById('message6').innerHTML="<sup>*</sup>Please select seats";
		pvalid =  false;
	}
	else
	{
		document.getElementById('message6').style.visibility="hidden";
	}
	if(email==null || email=="")
	{
		document.getElementById('message7').style.visibility="visible";
		document.getElementById('message7').innerHTML="Email Field must not be blank";
		pvalid =  false;
	}
	else
	{
		if(email.lastIndexOf('@')<1||(email.charAt(email.length-4)!='.'))
		{
			document.getElementById('message7').style.visibility="visible";
		    document.getElementById('message7').innerHTML="Incorrect email format";
		    pvalid =  false;
		}
		else	
		{
			document.getElementById('message7').style.visibility="hidden";
		}
		
    }
	if(password==null || password=="")
	{
		document.getElementById('message8').style.visibility="visible";
		document.getElementById('message8').innerHTML="Password Field must not be blank";
		pvalid =  false;
	}
	else
	{
		var lower =/[a-z]/g;
		var upper =/[A-Z]/g;
		var numbers =/[0-9]/g;
		var special=/[@#$%^&*]/g;
		if(password.match(lower)==null)
		{
			document.getElementById('message8').style.visibility="visible";
			document.getElementById('message8').innerHTML="Password should cotain atleast one lower case character";
			pvalid =  false;
		}
		else if(password.match(upper)==null)
		{
			document.getElementById('message8').style.visibility="visible";
			document.getElementById('message8').innerHTML="Password should cotain atleast one upper case character";
			pvalid =  false;
		}
		else if(password.match(numbers)==null)
		{
			document.getElementById('message8').style.visibility="visible";
			document.getElementById('message8').innerHTML="Password should cotain atleast one numeric value";
			pvalid =  false;
		}
		else if(password.match(special)==null)
		{
			document.getElementById('message8').style.visibility="visible";
			document.getElementById('message8').innerHTML="Password must contain anyone of these @,#,$,%,^,&,*";
			pvalid =  false;
		}
		else if(password.length<8||password.length>15)
		{
			document.getElementById('message8').style.visibility="visible";
			document.getElementById('message8').innerHTML="Password length must be in between 8-15 characters";
			pvalid =  false;
		}
		else
		{
			document.getElementById('message8').style.visibility="hidden";
		}
    }
	return pvalid;
}