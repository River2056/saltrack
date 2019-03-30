<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>SMS Login</title>
		<link rel="stylesheet" type="text/css" href="css/common.css" />
		<link rel="stylesheet" type="text/css" href="css/input.css" />
	</head>
	<body>
		<h1>SMS Login</h1>
		<form action="login.do" method="post">
			<%
				String msg = (String)request.getAttribute("login_failed");
			%>
			Account: <input name="uname" type="text" placeholder="username"/>
			<span style="color: red;"><%= msg == null ? "" : msg %></span>
			<br/>
			Password: <input name="pwd" type="password" placeholder="pwd"/>
			<input type="submit" value="Login"/>
		</form>
	</body>
</html>