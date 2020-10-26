<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="dao.*, dto.*" %>
<%
	request.setCharacterEncoding("utf-8");  /*write.jsp에서 한글 넘어오기  때문에*/
	Notice_dao dao = new Notice_dao();
	
	String title = request.getParameter("t_title");
	String content = request.getParameter("t_content");
	String attach = request.getParameter("t_attach");
	String reg_name = request.getParameter("t_reg_name");
	String reg_date = request.getParameter("t_reg_date");
	
	Notice_dto dto = new Notice_dto("", title, content, attach, reg_name, reg_date,0);
	int result = dao.saveNotice(dto);
%>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript">
<% if(result == 1) { %>
	alert("등록되었습니다");
<%	} else { %>
	alert("등록 실패. 관리자에게 문의하세요");
<%	} %>
	location.href = "notice_list.jsp"; //자바스크립트에서 페이지 넘겨줄 때 location.href
</script>
</head>
<body>

</body>
</html>