<!DOCTYPE html>
<html>

	<head>
		<meta charset="UTF-8">
		<title>Add days</title>
		<link rel="stylesheet" type="text/css" href="css/common.css" />
		<link rel="stylesheet" type="text/css" href="css/input.css" />
	</head>

	<body>
		<div class="time"></div>
		<form action="add.do" method="post">
			<p>Day Salary:</p>
			<input value="1700" type="number" name="daysal" />
			
			<p>Date:</p>
			<input type="text" name="workdate" id="currentDate" />
			
			<p>Worktime:</p>
			<span>Full: </span> 
			<input class="rbtn" checked="checked" type="radio" value="full" name="worktime" /> 
			<span>Half: </span> 
			<input class="rbtn" type="radio" value="half" name="worktime" /> 
			<span>Off:</span> 
			<input class="rbtn" type="radio" value="off" name="worktime" />
			
			<p>Overtime?</p>
			<input value="0" type="number" name="overtime" />
			
			<p>Comments:</p>
			<input type="text" name="comments" /> <input class="btn"
				type="submit" value="post" />
		</form>
		<a href="list.do">Go to checklist</a>
		<%@ include file="HOMEbtn.jsp"%>
		<script type="text/javascript" src="js/input.js"></script>
	</body>

</html>