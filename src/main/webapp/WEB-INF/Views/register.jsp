<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Dice Game | Register</title>
<link href="<%=request.getContextPath()%>/styles/login.css" rel="stylesheet">
</head>
<body>

<h1>Welcome to Dice Game Registration</h1>

<section id="container-section">
	<form action="register" method="post">
	  <div class="container">
	  
	  	<label for="fname"><b>First Name</b></label>
	    <input type="text" placeholder="Enter First name..." id="fname" name="firstName" required>
	  
	  	<label for="lname"><b>Last Name</b></label>
	    <input type="text" placeholder="Enter Last name..." id="lname" name="lastName" required>
	  
	    <label for="email"><b>Email</b></label>
	    <input type="email" placeholder="Enter Email..." id="email" name="login" required>
	
	    <label for="psw"><b>Password</b></label>
	    <input type="password" placeholder="Enter Password...." id="psw" name="password" required>
	        
	    <button type="submit">Register</button>
	  </div>
	  <div class="container" >
	    <p class="psw">You have already an account? 
	    	<a href="<%=request.getContextPath()%>/login">Sign in</a>
	    </p>
	  </div>
	</form>
</section>
</body>
</html>
