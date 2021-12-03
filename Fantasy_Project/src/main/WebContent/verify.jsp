<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	if (session.getAttribute("user") == null) {
		System.out.println("Intento de acceso no autenticado");
		response.sendRedirect("index.html");		
	}
%>