<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "dao.*" %>
<%
	request.setCharacterEncoding("utf-8");
	Member_dao dao = new Member_dao();
	String id = request.getParameter("t_id");
	String pw = request.getParameter("t_pw");
	String name = dao.getLoginName(id, pw);
	String msg = "";
	if(name == null){
		msg = "ID 혹은 PW가 맞지 않습니다.";
	}else{
		msg = name + "님~ 반갑습니다! ";
		session.setAttribute("session_name", name); 
		session.setAttribute("session_id", id);
		if(id.equals("manager")){
			session.setAttribute("session_level", "top");
		}
		/*session클래스의 setAttribute는 session_name변수에 name을 할당해주는 것*/
		/*session_name는 내가 만드는 이름! 얘는 index.jsp, common_subpage_head.jsp에서 사용함!*/
		session.setMaxInactiveInterval(60*60*1);
		/*setAttribute의 정보를 몇시간동안 유지할 껀지 어떤 버튼을 누르면 시간이 갱신*/
		/*setMaxInactiveInterval 초 단위이기 때문에 1시간동안 유지하려면 60*60*1*/
	}
	//out.print("======"+msg);
%>
<!DOCTYPE html>
<html>
<head>
<script>
	alert("<%=msg%>");
	<%if(name==null){%>
		location.href="member_login.jsp";
	<%} else {%>
	location.href="/index.jsp";
	<%	}%>
</script>
</head>
<body>

</body>
</html>