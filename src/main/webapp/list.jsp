<%@ page pageEncoding="utf-8" contentType="text/html; charset=utf-8" %>
<%@ page import="dao.*, entity.*, java.util.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>List of work days</title>
		<link rel="stylesheet" type="text/css" href="css/common.css" />
		<link rel="stylesheet" type="text/css" href="css/list.css" />
	</head>
	<body>
		<table width="70%" border="2" cellpadding="5" cellspacing="0">
			<tr>
				<td>ID</td>
				<td>Day Salary</td>
				<td>Work Date</td>
				<td>Work Time</td>
				<td>Over Time</td>
				<td>Comments</td>
				<td> </td>
			</tr>
			
			<c:forEach items="${requestScope.list}" var="s" varStatus="vs">
    			<tr class="row${vs.index % 2 + 1 }">
			        <td>${s.id}</td>
			        <td>${s.daysal}</td>
			        <td>${s.workdate}</td>
			        <td>${s.worktime}</td>
			        <td>${s.overtime}</td>
			        <td>${s.comments}</td>
			        <td> <a href="del.do?id=${s.id}" onclick="return confirm('Are you SURE? deleting ${s.id}')">delete</a> </td>
    			</tr>
			</c:forEach>
			
		</table>
		<div>Done printing all records!</div>
		
		
		<a href="input.jsp">Go to add days</a>
		<a href="count.do">Check paycheck</a>
		<%@ include file="HOMEbtn.jsp" %>
		
	</body>
</html>