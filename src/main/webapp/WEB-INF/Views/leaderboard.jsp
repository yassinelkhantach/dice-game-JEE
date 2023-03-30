<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Dice Game | Leaderboard</title>
<link href="<%=request.getContextPath()%>/styles/index.css" rel="stylesheet">

</head>
<body>

	<div class="topnav">
	    <section>
		    <a href="<%=request.getContextPath()%>/game">Game</a>
		  	<a class="active" href="<%=request.getContextPath()%>/leaderboard">Leaderboard</a>
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
		
		<p>
		  Lorem ipsum dolor sit amet consectetur adipisicing elit. Veniam, culpa mollitia quia et dolor iure voluptas, vero odio modi at aliquid sequi laborum error obcaecati placeat amet unde facere consectetur saepe. Magni, atque autem. Molestias eum, veniam dolorum fuga rerum vitae corporis doloremque distinctio accusantium blanditiis, possimus illum numquam quod nostrum hic accusamus fugiat molestiae odio quibusdam, neque minima quaerat error ducimus. Accusamus mollitia accusantium magnam, cumque inventore quasi obcaecati maxime enim, rem in quas necessitatibus doloribus perferendis vitae odit?
		</p>
	  	
	  	  	
  	</section>
</body>
</html>