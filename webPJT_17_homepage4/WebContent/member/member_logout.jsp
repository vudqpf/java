<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	session.invalidate();
	/*db_member_login.jsp의 session정보를 전부 삭제*/
%>
<!DOCTYPE html>
<html>
<head>
<script>
	location.href="/index.jsp";
</script>
</head>
<body>

</body>
</html>