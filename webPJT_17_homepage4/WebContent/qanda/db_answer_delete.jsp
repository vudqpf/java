<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="dao.*" %>
<%

	Qanda_dao dao = new Qanda_dao();
	
	String no 		= request.getParameter("t_no");
	
	int result = dao.deleteAnswer(no);
	String msg = "";
	if(result == 1) msg = "답변 삭제 되었습니다.";
	else msg = "답변 삭제 실패";
%>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript">
		alert("<%=msg%>");
	location.href = "qanda_list.jsp";
</script>
</head>
<body>
</body>
</html>