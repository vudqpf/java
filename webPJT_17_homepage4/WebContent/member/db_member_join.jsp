<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "dao.*, dto.*,common.*" %>
<%
	request.setCharacterEncoding("utf-8");
	Member_dao dao = new Member_dao();
	
	String id 		= request.getParameter("t_id");
	String name 	= request.getParameter("t_name");
	String pw 		= request.getParameter("t_pw");
	String area 	= request.getParameter("t_area");
	String address 	= request.getParameter("t_address");
	String tel_1 	= request.getParameter("t_tel_1");
	String tel_2 	= request.getParameter("t_tel_2");
	String tel_3 	= request.getParameter("t_tel_3");
	String mf 		= request.getParameter("t_mf");
	String hobby_t 	= request.getParameter("t_hobby_t");
	String hobby_r  = request.getParameter("t_hobby_r");
	String hobby_s  = request.getParameter("t_hobby_s");
	if(hobby_t == null) hobby_t = "n";
	if(hobby_r == null) hobby_r = "n";
	if(hobby_s == null) hobby_s = "n";
	String reg_date = Common.getToday(); /*static으로 인해 Common클래스 바로 사용가능 즉! new common() 생성안해도 됨*/
	int checkId = dao.idCheckCount(id);/*아이디 중복검사하는 dao*/
	String msg = "";
	String url = "/index.jsp";
	if(checkId == 1){
		msg = "ID 중복 되었습니다! 다른 ID 사용하세요~";
		url ="member_join.jsp";
	}else {	
		Member_dto dto = new Member_dto(id, name, pw, area, address, tel_1, tel_2, tel_3, mf, hobby_t, hobby_r, hobby_s, reg_date);
		int result = dao.saveMember(dto);
		if(result == 1) msg = name + "님! 회원 가입 되셨습니다!";
		else msg = "회원 가입 실패";
	}	
%>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript">
	alert("<%=msg%>");
	location.href="<%=url%>";
</script>
</head>
<body>

</body>
</html>