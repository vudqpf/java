<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
	String id 	= request.getParameter("t_id");
	String name = request.getParameter("t_name");
	String pw 	= request.getParameter("t_pw");
	String area = request.getParameter("t_area");
	String mf	= request.getParameter("t_mf");
//	out.print("=========="+name);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
아이디 : <%out.print(id);%><br>
이름 : <%= name %><br>
비번 : <%= pw %><br>
지역 : <%= area %><br>
남여 : <%= mf %><br>
<input type="button" onclick="history.back()" value="이전~">
</body>
</html>


