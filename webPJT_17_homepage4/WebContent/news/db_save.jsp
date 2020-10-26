<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "dao.*, dto.*" %>
<%
	request.setCharacterEncoding("utf-8");
	News_dao dao = new News_dao();
	
	String gubun 	= request.getParameter("t_work_gubun");
	String title 	= request.getParameter("t_title");
	String content 	= request.getParameter("t_content");
	String reg_name = request.getParameter("t_reg_name");
	String reg_date = request.getParameter("t_reg_date");
	
	int result = 0;
	String keka = "";
	if(gubun.equals("insert")){
		String no = dao.getNewsNo();
		News_dto dto = new News_dto(no, title, content, reg_name, reg_date, 0);
		result = dao.getNewsSave(dto);
		if(result == 1) keka = "등록 되었습니다.";
		else keka = "등록 실패했습니다.";
	}else if(gubun.equals("update")){
		String no = request.getParameter("t_no");
		News_dto dto = new News_dto(no, title, content, reg_name, reg_date, 0);
		result = dao.getNewsUpdate(dto);
		if(result == 1) keka = "수정 되었습니다.";
		else keka = "수정 실패했습니다.";
	}else if(gubun.equals("delete")){
		String no = request.getParameter("t_no");
		//News_dto dto = new News_dto(no, title, content, reg_name, reg_date, 0);
		result = dao.getNewsDelete(no);
		if(result == 1) keka = "삭제 되었습니다.";
		else keka = "삭제 실패했습니다.";
	}
	
%>
<!DOCTYPE html>
<html>
<head>
</head>
<body>
<script type="text/javascript">
	alert("<%=keka%>");
	location.href="news_list.jsp";
</script>
</body>
</html>