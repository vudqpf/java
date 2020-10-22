<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="dao.*" %>
<%
	Member_dao dao = new Member_dao();
	String id = request.getParameter("t_id");
	int checkId = dao.idCheckCount(id); /*아이디 중복검사하는 dao*/
	
	if(checkId == 0){ 
		out.print("사용가능!");
	} else { 
		out.print("사용불가! 중복ID");
	}%>
