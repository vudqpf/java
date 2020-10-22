<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import = "dao.*" %>
    <%
    	Event_dao dao = new Event_dao();
    	String no = request.getParameter("t_event_no");
    	int result = dao.eventDelete(no);
    	
    %>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript">
<%if(result == 1) {%>
	alert(" 삭제 되었습니다 ");
<%}else {%>
	alert(" 삭제 실패! 관리자에게 문의 하세요 ");
<%}%>
	location.href = "event_list.jsp";
</script>
</head>
<body>

</body>
</html>