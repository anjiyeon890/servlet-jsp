<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="cn.techtutorial.connection.DbCon" %>
<%@ page import="cn.techtutorial.model.*" %>

	<% 
		User auth = (User) request.getSession().getAttribute("auth");
		if(auth!=null){
			request.setAttribute("auth", auth);
		}
	%>	
<!DOCTYPE html>
<html>
<head>

<title>Orders Page</title>
<%@include file="includes/head.jsp"%>
</head>
<body>
<%@include file="includes/navbar.jsp"%>


<%@include file="includes/head.jsp"%>
</body>
</html>