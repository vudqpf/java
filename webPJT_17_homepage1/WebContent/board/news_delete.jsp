<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "dao.*" %>
<%
	News_dao dao = new News_dao();
	String no = request.getParameter("t_no");
	
	int result = dao.deleteNews(no);
	
%>
<!DOCTYPE html>
<html>
<head>
	<script type="text/javascript">
	<%	if(result == 1){  %>
		alert("삭제 성공");
	<%	}else{            %>
		alert(" 삭제 실패");
	<%	}                 %>
		location.href = "news_list.jsp";
	</script>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>