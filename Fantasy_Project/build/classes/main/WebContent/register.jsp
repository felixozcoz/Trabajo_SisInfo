<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@ page import= "model.JugadorVO" %>
<%@ page import= "java.util.Vector" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
    if(session.getAttribute("myteam") == null) {
    	  System.out.println("Fallamos señores");
    	  out.println(session.getAttribute("hola"));
	}
	else {
		Vector<JugadorVO> team = (Vector<JugadorVO>) session.getAttribute("myteam");
		out.println(team.get(1).getNombre());
		out.println("Hoy ha sido un día de éxitos caballeros");
	}
		%>
</body>
</html>