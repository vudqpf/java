<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="dao.*, dto.*, common.*" %>
<%
	request.setCharacterEncoding("utf-8");  /*write.jsp에서 한글 넘어오기  때문에*/
	Qanda_dao dao = new Qanda_dao();
	
	String no 			= request.getParameter("t_no");
	String title 		= request.getParameter("t_title");
	String content		= request.getParameter("t_content");
	String q_reg_id 	= request.getParameter("t_reg_id");
	String q_reg_date 	= Common.getToday();
	
	Qanda_dto dto = new Qanda_dto(no, title, content, q_reg_id, q_reg_date);
	int result = dao.updateQuestion(dto);
%>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript">
<% if(result == 1) { %>
	alert("수정되었습니다");
<%	} else { %>
	alert("수정 실패. 관리자에게 문의하세요");
<%	} %>
	location.href = "qanda_list.jsp"; //자바스크립트에서 페이지 넘겨줄 때 location.href
</script>
</head>
<body>

</body>
</html>