<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Dice Game | Login</title>
<link href="<%=request.getContextPath()%>/styles/login.css" rel="stylesheet">
</head>
<body>

<h1>Welcome to Dice Game Authentication</h1>

<section id="container-section">
	<form action="login" method="post">
	  <div class="container">
	    <label for="email"><b>Email</b></label>
	    <input type="email" placeholder="Enter Email..." id="email" name="login" required>
	
	    <label for="psw"><b>Password</b></label>
	    <input type="password" placeholder="Enter Password..." id="psw" name="password" required>
	        
	    <button type="submit">Login</button>
	  </div>
	  <div class="container">
	   	<p class="psw">Don't have an account yet? 
	   		<a href="<%=request.getContextPath()%>/register">Sign up</a>
	   	</p>
	  </div>
	</form>
</section>
</body>
</html>
