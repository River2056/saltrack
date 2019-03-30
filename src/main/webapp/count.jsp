<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Paycheck reference</title>
		<link rel="stylesheet" type="text/css" href="css/common.css" />
	</head>
	<body>
		<div class="msg">
			<% double[] salCheck = (double[])request.getAttribute("salCheck"); %>
			<p>Total work days this month: <%= salCheck[1]%></p>
			<p>Over time: 0</p>
			<p>Your paycheck this month: <%= salCheck[0]%></p>
		</div>
		<a href="list.do">Go to list</a>
		<%@ include file="HOMEbtn.jsp" %>
		
	</body>
</html>