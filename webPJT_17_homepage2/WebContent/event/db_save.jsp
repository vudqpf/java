<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="dao.*, dto.*" %>
<%
	request.setCharacterEncoding("utf-8");
	Event_dao dao = new Event_dao();
	
	String no 			= dao.getEventNo();
	String title 		= request.getParameter("t_title");
	String content 		= request.getParameter("t_content");
	String s_date 		= request.getParameter("t_s_date");
	String e_date 		= request.getParameter("t_e_date");
	String reg_name 	= request.getParameter("t_reg_name");
	String reg_date 	= request.getParameter("t_reg_date");
	
	Event_dto dto = new Event_dto(no, title, content, s_date, e_date, 
								  reg_name, reg_date, 0);	
	int result = dao.eventSave(dto);
	
%>
<!DOCTYPE html>
<html>
</head>
<body>
<script type="text/javascript">
<%if(result == 1) {%>
	alert(" 등록 되었습니다.");
<%}else {%>
	alert("등록 실패! 관리자에게 문의 하세요");
<%}%>
	location.href = "event_list.jsp";
</script>
</body>
</html>