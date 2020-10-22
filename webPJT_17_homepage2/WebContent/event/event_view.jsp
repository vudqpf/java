<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "dto.*, dao.*" %>
<% 
	Event_dao dao = new Event_dao();
	String no =request.getParameter("t_event_no");
	Event_dto dto = dao.getEventView(no);
	
	dao.hitCount(no);

%>
<!DOCTYPE html>
<html>
<head>
	<script>
		function goUpdateForm(){
			view.method="post";
			view.action="event_updateForm.jsp";
			view.submit();
		}
		function goDelete(){
	//		val yn = confirm("");
			if(confirm( "정말 삭제 하시겠습니까?")){
	//			alert("1234");
				view.method="post";
				view.action="db_dalete.jsp";
				view.submit();
			}
		}
	</script>
	
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	
	<title>홍길동</title>
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.5.0/css/all.css" integrity="sha384-B4dIYHKNBt8Bc12p+WXckhzcICo0wtJAoU8YZTY5qE0Id1GSseTk6S+L3BlXeVIU" crossorigin="anonymous">	
	<link href="/css/common.css" rel="stylesheet">
	<link href="/css/layout.css" rel="stylesheet" >	
</head>
<body>
	<form name="view">
		<input type="hidden" name="t_event_no" value="<%=no %>">
		<!-- name은 event_view.jsp 에서 받을 이름으로 같이 맞춰주고, value는 t_event_no에 들어갈 값 -->
	</form>	
	<div class="container">
	
		<div class="leftmargin">
			<h1>성명 : 홍길동</h1>
		</div>		
		<div class="write_wrap">
		
			<div class="board_list">
				<table class="board_table">
					<colgroup>
						<col width="12%">
						<col width="50%">
						<col width="12%">
						<col width="*">
					</colgroup>
					<tbody>
						<tr>
							<th>Event 제목</th>
							<td class="th_left" >
								<%=dto.getTitle() %>
							</td>
							<th>조회수</th>
							<td class="th_left" >
								<%=dto.getHit() %>
							</td>
						</tr>
						<tr>
							<th>Event 기간</th>
							<td class="th_left" colspan="3">
								<%=dto.getS_date() %>~<%=dto.getE_date() %>
							</td>
						</tr>
						<tr>
							<th>내용</th>
							<td class="th_left" colspan="3">
								<textarea name="t_contents" readonly><%=dto.getContent() %></textarea>
							<!-- readonly는 textarea에 글을 못 쓰도록 -->
							</td>
						</tr>
						<tr>
							<th>작성자</th>
							<td class="th_left" >
								<%=dto.getReg_name() %>
							</td>
							<th>작성일</th>
							<td class="th_left" >
								<%=dto.getReg_date() %>
							</td>
						</tr>
					</tbody>
				</table>
			</div>
			<div class="btn_wrap">
				<a href="event_list.jsp">목록</a>
				<input type="button" onClick="location.href='event_list.jsp'" value="목록" class="btn_list">
				<!-- input타입으로 넘기려면 location.href으로 작성해줘야댐 -->
				<input type="button" onClick="location.href='event_updateForm.jsp?t_event_no=<%=no %>'" value="수정get방식" class="btn_list">
				<input type="button" onClick="goUpdateForm()" value="수정post방식" class="btn_list">
				<input type="button" onClick="goDelete()" value="삭제" class="btn_list">
			</div>
		</div>
	</div>
</body>
</html>