<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="dao.*, dto.*" %>
<%
	request.setCharacterEncoding("utf-8");  /*write.jsp에서 한글 넘어오기  때문에*/
	Notice_dao dao	 = new Notice_dao();
	
	String gubun  	 = request.getParameter("t_work_gubun");
	String title 	 = request.getParameter("t_title");
	String content 	 = request.getParameter("t_content");
	String attach 	 = request.getParameter("t_attach");
	String reg_name  = request.getParameter("t_reg_name");
	String reg_date  = request.getParameter("t_reg_date");
	
	int result = 0;
	String msg = "";
	if(gubun.equals("insert")){
		String no = dao.getNotiveNo();
		Notice_dto dto = new Notice_dto(no, title, content, attach, reg_name, reg_date,0);
		result = dao.saveNotice(dto);
		if(result == 1) msg=" 등록 되었습니다. ";
		else msg = " 등록 실패하였습니다. ";
	}else if(gubun.equals("update")){
		String no = request.getParameter("t_no");
		Notice_dto dto = new Notice_dto(no, title, content, attach, reg_name, reg_date,0);
		result = dao.updateNotice(dto);
		if(result == 1) msg=" 수정 되었습니다. ";
		else msg = " 수정 실패하였습니다. ";
	}
	else if(gubun.equals("delete")){
		String no = request.getParameter("t_no");
		result = dao.deleteNotice(no);
		if(result == 1) msg=" 삭제 되었습니다. ";
		else msg = " 삭제 실패하였습니다. ";
	}

%>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript">
	alert("<%=msg%>");
	location.href="notice_list.jsp";
</script>
</head>
<body>

</body>
</html>