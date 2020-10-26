<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="dao.*, dto.*" %>
<%
	String no = request.getParameter("t_event_no");
//	out.print("======="+no);
	Event_dao dao = new Event_dao();
	Event_dto dto = dao.getEventView(no);
	
%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	
	<title>홍길동</title>
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.5.0/css/all.css" integrity="sha384-B4dIYHKNBt8Bc12p+WXckhzcICo0wtJAoU8YZTY5qE0Id1GSseTk6S+L3BlXeVIU" crossorigin="anonymous">	
	<link href="/css/common.css" rel="stylesheet">
	<link href="/css/layout.css" rel="stylesheet" >	
	<script>
		function update(){
			board.method="post";
			board.action="db_update.jsp";
			board.submit();
		}
	</script>
</head>
<body>
	<div class="container">
		<div class="leftmargin">
			<h1>성명 : 홍길동</h1>
		</div>		
		<div class="write_wrap">
		
			<div class="board_list">
				<table class="board_table">
					<colgroup>
						<col width="12%">
						<col width="30%">
						<col width="12%">
						<col width="*">
					</colgroup>
					<form name="board">
					<input type="hidden" name="t_event_no" value="<%=no%>">
					<!-- 정보들을 넘겨줄 때 no은 굳이 보여줄 필요가 없으니까 -->
					<tbody>
						<tr>
							<th>Event 제목</th>
							<td class="th_left" colspan="3">
								<input name="t_title" value="<%=dto.getTitle() %>" class="input_100Per" type="text">
							</td>
						</tr>
						<tr>
							<th>Event 기간</th>
							<td class="th_left" colspan="3">
								<input name="t_s_date" value="<%=dto.getS_date() %>" class="input_150px" type="date">
								~
								<input name="t_e_date" value="<%=dto.getE_date() %>" class="input_150px" type="date">
							</td>
						</tr>
						<tr>
							<th>내용</th>
							<td class="th_left" colspan="3">
								<textarea name="t_content"><%=dto.getContent() %></textarea>
							</td>
						</tr>
						<tr>
							<th>작성자</th>
							<td class="th_left">
								<input name="t_reg_name" value="<%=dto.getReg_name() %>" class="input_100px" type="text">
							</td>
							<th>작성일</th>
							<td class="th_left">
								<input name="t_reg_date" value="<%=dto.getReg_date() %>"  class="input_150px" type="date">
							</td>
					</tbody>
					</form>
				</table>
			</div>
			<div class="btn_wrap">
				<input type="button" onClick="history.back()" value="목록" class="btn_list">
				<input type="button" onClick="update()" value="수정저장" class="btn_ok">&nbsp;&nbsp;
			</div>
		</div>
	</div>
</body>
</html>