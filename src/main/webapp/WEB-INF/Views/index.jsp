<%@page import="java.util.Map.Entry"%>
<%@page import="java.util.HashMap"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Dice Game | Home</title>
	<link href="<%=request.getContextPath()%>/styles/index.css" rel="stylesheet">
	<link href="<%=request.getContextPath()%>/styles/font-awesome.min.css" rel="stylesheet">
	
</head>
<body>

	<div class="topnav">
	    <section>
		    <a class="active" href="<%=request.getContextPath()%>/game">Game</a>
		  	<a href="<%=request.getContextPath()%>/leaderboard">Leaderboard</a>
		  	<a href="#about">About</a>
	    </section>
		
		<section>
			<form action="game" method="post">
				<input type="hidden" name="logout">
			    <input type="submit" value="Logout" class="logout">
	    	</form>
		</section>
	</div>
	
	<section class="container">
	
		<h1>Welcome to Dice Game Dashboard</h1>
		
		<form action="game" method="post">
		    <label for="diceNumber">Dice number</label>
		    <input type="number" id="diceNumber" name="diceNumber" min="1" max="3" placeholder="Write a number..." value="1" autofocus>
		    <input type="hidden" name="game">
		    
		    <input type="submit" value="Roll the Dice">
	  	</form>
	  	
	  	<div class="dices">
	  		<%
	  		for(Entry<Integer,Integer> entry : ((HashMap<Integer, Integer>)request.getSession().getAttribute("rounds")).entrySet()){
	  		%>
	  		  <img alt="" src="<%=request.getContextPath()%>/assets/dice-<%=((HashMap<Integer, String>)request.getSession().getAttribute("dices")).get(entry.getValue())%>-solid.svg" style="height:100px;">
	  		<%
	  		}
	  		%>
	  	</div>
	  	
	  	  	
  	</section>
</body>
</html>