<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="dao.News_dao"   %>
<%
	News_dao dao = new News_dao();
	request.setCharacterEncoding("utf-8");
	String no = dao.getNewsNo();
//	out.print("no : "+no);
	String title = request.getParameter("t_title");
	String content = request.getParameter("t_content");
	String reg_name = request.getParameter("t_reg_name");
	String reg_date = request.getParameter("t_reg_date");
	
	
	int result = dao.saveNews(no, title, content, reg_name, reg_date);
	
//	out.print("result : "+result);

%>    
    
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript">
<%	if(result == 1){  %>
	alert("등록 성공");
<%	}else{            %>
	alert(" 등록 실패");
<%	}                 %>
	location.href = "news_list.jsp";
</script>
</head>
</html>