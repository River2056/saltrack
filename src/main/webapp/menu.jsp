<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Salary Account Management System</title>
		<link rel="stylesheet" type="text/css" href="css/common.css" />
	</head>
	<body>
		<h1>Salary Management System</h1>
		<a href="input.jsp">Add days</a>
		<a href="list.do">List all work days</a>
		<a href="count.do">Check work days and paycheck</a>
		
		<div class="time"></div>
		<script type="text/javascript">
			const time = document.querySelector(".time");
			function now() {
				let date = new Date();
				time.innerHTML = date;
				
			}
			setInterval(now, 100);
		</script>
	</body>
</html>