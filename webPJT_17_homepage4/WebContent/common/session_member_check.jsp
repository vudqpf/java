<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String loginGubun = (String)session.getAttribute("session_id");
	if(loginGubun == null) loginGubun = "";
	/*관리자 등, 권한을 가지고 있는 사람에게 글쓰기 권한을 주기 위해서*/
	if(loginGubun.equals("")){
	/*회원이 아니거나 회원이지만 글쓴이가 아닐 때*/	
%>
<script>
	alert("로그인 후 사용가능 합니다~");
	location.href="/index.jsp";
</script>
<%	}  %>