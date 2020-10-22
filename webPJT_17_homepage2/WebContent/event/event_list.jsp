<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "dao.*, dto.*, java.util.*" %>
<%
	request.setCharacterEncoding("utf-8");
	Event_dao dao = new Event_dao();
	String select = request.getParameter("t_select"); /*위에서 실행될 때 select란게 그냥 열림*/
	String search = request.getParameter("t_search"); 
	
	if(select == null){
		select ="title";
		search ="";
	}
	
	ArrayList<Event_dto> arr = dao.getEventList(select, search);

%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>홍길동</title>
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.5.0/css/all.css" integrity="sha384-B4dIYHKNBt8Bc12p+WXckhzcICo0wtJAoU8YZTY5qE0Id1GSseTk6S+L3BlXeVIU" crossorigin="anonymous">	
	<link href="/css/common.css" rel="stylesheet">
	<link href="/css/layout.css" rel="stylesheet" >	
<style type="text/css">
	td{text-align:center}
	.title{text-align:left}
</style>
<script type="text/javascript">
	function goSearch() {
	//	alert("1234");
		board.method = "post";
		board.action = "event_list.jsp";
		board.submit();
	}
	function goView(event_no){
	//	alert("1234");
		view.t_event_no.value = event_no;
		<!-- event_no란 변수가 없고...절대값이 아닌 no에 따라 달라지므로  -->
		view.method="post";
		view.action="event_view.jsp";
		view.submit();
	}
</script>
</head>
<body>
	<form name="view">
		<input type="hidden" name="t_event_no" >
		<!-- name은 event_view.jsp 에서 받을 이름으로 같이 맞춰주고, value는 t_event_no에 들어갈 값 -->
	</form>
	<div class="container">

		<div class="leftmargin">
			<h1>성명 : 홍길동</h1>
		</div>		
		<div class="search_wrap">
			<div class="record_group">
				<p>총게시글 : <span><%=arr.size() %></span>건</p>
			</div>
			<form name="board">
				<div class="search_group">
					<select name="t_select" class="select">
						<option value="title" <%if(select.equals("title")) out.print("selected"); %>>제목</option>
						<option value="content" <%if(select.equals("content")) out.print("selected");%>>내용</option>
					</select>
					<input name="t_search" value="<%=search %>" type="text" class="search_word">
					<button onclick="goSearch()" class="btn_search"><i class="fa fa-search"></i><span class="sr-only">검색버튼</span></button>
				</div>
			</form>
		</div>
	</div>
	<div class="board_list">
		<table class="board_table">
			<colgroup>
				<col width="8%">
				<col width="*">
				<col width="20%">
				<col width="8%">
				<col width="10%">
				<col width="8%">
			</colgroup>
			<thead>
				<tr>
					<th>번호</th>
					<th>제목</th>
					<th>기간</th>
					<th>글쓴이</th>
					<th>작성일</th>
					<th>조회수</th>
				</tr>
			</thead>
			<tbody>
				<%
				for(int i = 0; i < arr.size(); i++){
				%>				
				<tr>
						<td><a href="event_view.jsp?t_event_no=<%=arr.get(i).getNo()%>"><%=arr.get(i).getNo()%></a></td>					
					<!--  	<td class="title"><%=arr.get(i).getTitle()%></td>	-->
						<td class="title"><a href="javascript:goView('<%=arr.get(i).getNo()%>')"><%=arr.get(i).getTitle()%> </a></td>							
						<td><%=arr.get(i).getS_date() %>~<%=arr.get(i).getE_date()%></td>							
						<td><%=arr.get(i).getReg_name()%></td>					
						<td><%=arr.get(i).getReg_date()%></td>
						<td><%=arr.get(i).getHit()%></td>				
				</tr>								
			<%} %>
			</tbody>
		</table>
		<div class="paging">
			<a href="event_writeForm.jsp" class="write">글쓰기</a>
		</div>
	</div>
 </body>
</html>