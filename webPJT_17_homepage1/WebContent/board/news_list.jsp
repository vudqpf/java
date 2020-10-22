<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="dao.*,  dto.*,  java.util.*"%>

<%
	request.setCharacterEncoding("utf-8");
	News_dao dao = new News_dao();
	String select = request.getParameter("t_select");
	String search = request.getParameter("t_search");
	
	if(select == null){
		select = "title";
		search = "";
	}
//	out.print(" ==== select ==== " +select+"<br>");
//	out.print(" ==== search ==== " +search);
	ArrayList<News_dto> arr = dao.getNewsList(select, search);
//	out.print("=========="+arr.size());

	
%>

<!DOCTYPE html>
<html>
<head>
	<title>UIUX_홍길동_두번째</title>
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.5.0/css/all.css" integrity="sha384-B4dIYHKNBt8Bc12p+WXckhzcICo0wtJAoU8YZTY5qE0Id1GSseTk6S+L3BlXeVIU" crossorigin="anonymous">	
	<link href="../css/common.css" rel="stylesheet">
	<link href="../css/layout.css" rel="stylesheet" >	
	<Script>
		function goSearch(){
//	alert("dddd");
			news.method = "post";
			news.action = "news_list.jsp";
			news.submit();
		}
		function goView(no){
//			alert(no);
			newsView.t_no.value = no;
			/*newsView의 상자 안에 보내줄 no값을 넣어 주기 위하여*/
			/*오른쪽에 있는 no를 왼쪽에 있는 newsView.t_no.value에 넣어준다*/
			/*writeForm.jsp참고*/
			newsView.method="post";
			/*news를 정하는건 form의 name에 의해서 정해지는 것*/
			newsView.action="news_view.jsp";
			newsView.submit();
		}
	
	</Script>
<style>	
	td{text-align:center;}
	.title{text-align:left;}
</style>	
</head>
<body>
	<form name="newsView">
		<input type="hidden" name="t_no" value="">
	</form>
	<div class="container">
		<div class="leftmargin">
			<h1>성명 : 홍길동</h1>
		</div>	
		<form name="news">	
			<div class="search_wrap">
				<div class="record_group">
					<p>총게시글 : <span><%=arr.size() %></span>건</p>
				</div>
				<div class="search_group">
					<select name="t_select" class="select">
						<option value="title"   <% if(select.equals("title")) out.print("selected");%>   >제목</option>
						<option value="content" <% if(select.equals("content")) out.print("selected");%>> 내용</option>
					</select>
					<input name="t_search" type="text" value="<%=search %>" class="search_word">
					<!-- value는 내용선택하면 그 내용이 그대로 유지되도록  -->
					<button type="submit" onclick="goSearch()" class="btn_search"><i class="fa fa-search"></i><span class="sr-only">검색버튼</span></button>
				</div>
			</div>
		</form>
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
					<th>글쓴이</th>
					<th>작성일</th>
					<th>조회수</th>
				</tr>
			</thead>
			<tbody>
			<%
				for(int k = 0; k < arr.size(); k++){
			%>
				<tr>
					<td><a href="javascript:goView('<%=arr.get(k).getNo()%>')"><%=arr.get(k).getNo()%></a></td>
					<!-- a 테그에서는 onclick을 사용하지 못하기 때문에 a테그에서 클릭해서 넘겨줄때
						javascipt의 goView()를 가라고 명령하는거 -->
						<!-- N001을 클릭하면 post방식으로 보내는거 -->
					<td class="title"><a href="news_view.jsp?t_no=<%=arr.get(k).getNo()%>"><%=arr.get(k).getTitle() %></a></td>
					<!-- 제목 클릭하면 get방식으로 보내는거  -->
					<td><%=arr.get(k).getReg_name() %></td>
					<td><%=arr.get(k).getReg_date() %></td>
					<td><%=arr.get(k).getHit() %></td>
				</tr>					
			
			<% }		
				if(arr.size() == 0){
			%>	
				<tr>
					<td colspan="5">내용 없음</td>
				</tr>
			<!-- <tr>을 사용하는 이유는 테이블 안이기 때문에 tr로 감싸줘야만 함 -->
				<%} %>
			</tbody>
		</table>
		<div class="paging">
			<a href="news_writeForm.jsp" class="write">글쓰기</a>
		</div>
	</div>
 </body>
</html>