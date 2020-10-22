<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String session_manager = (String)session.getAttribute("session_level");
	if(session_manager == null) session_manager = "";
	/*관리자 등, 권한을 가지고 있는 사람에게 글쓰기 권한을 주기 위해서*/
	if(!session_manager.equals("top")){
%>
<script>
	alert("관리자가 아닙니다");
	location.href="/index.jsp";
</script>
<%	}  %>