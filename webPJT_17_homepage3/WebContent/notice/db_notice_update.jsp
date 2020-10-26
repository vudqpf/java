<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import= "dao.*, dto.*" %>
<%
	request.setCharacterEncoding("UTF-8");
	Notice_dao dao = new Notice_dao();
	
	String no 	  	= request.getParameter("t_no");
	String title 	= request.getParameter("t_title");
	String content 	= request.getParameter("t_content");
	String attach	= request.getParameter("t_attach");
	String reg_name = request.getParameter("t_reg_name");
	String reg_date = request.getParameter("t_reg_date");
	
	Notice_dto dto = new Notice_dto(no, title, content, attach, reg_name, reg_date, 0); //hit 자리는 0으로 자릿수만 채운다
	int result = dao.updateNotice(dto);
	//디티오에 담아서 다오 메소드에 값을 넘긴다 
%>    
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript">
<% if(result == 1) { %>
	alert("수정 되었습니다");
<%	} else { %>
	alert("수정 실패. 관리자에게 문의하세요");
<%	} %>
	location.href = "notice_list.jsp"; //자바스크립트에서 페이지 넘겨줄 때 location.href
</script>
</head>
<body>

</body>
</html>


<!--  저장공간쓰~  -->