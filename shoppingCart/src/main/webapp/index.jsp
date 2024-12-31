<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="cn.techtutorial.connection.DbCon" %>
<!DOCTYPE html>
<html>
<head>

<title>Welcome to Shopping Cart</title>
<%@include file="includes/head.jsp"%>
</head>
<body>
<%@include file="includes/navbar.jsp"%>

<% out.print(DbCon.getConnection()); %>

<%@include file="includes/head.jsp"%>
</body>
</html>