<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String session_name = (String)session.getAttribute("session_name");
	if(session_name == null) session_name = "";
	/*getAttribute는 return을 object로 함! object은 변형이 가능하기 때문에 String으로 캐스팅!*/
	/*object는 요리로 말하면 밀가루 상태! 이걸 수제비, 칼국수로 만들지 내가 결정해야 됨!*/
	
	String session_id = (String)session.getAttribute("session_id");
	if(session_id == null) session_id = "";
	
	String session_level = (String)session.getAttribute("session_level");
	if(session_level == null) session_level = "";
	/*관리자 등, 권한을 가지고 있는 사람에게 글쓰기 권한을 주기 위해서*/
%>