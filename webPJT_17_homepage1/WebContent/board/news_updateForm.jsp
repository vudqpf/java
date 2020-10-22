<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "dao.*, dto.*" %>
    
<% 
    String no = request.getParameter("t_no");
//	out.print("===="+no);
	News_dao dao = new News_dao();
    News_dto dto = dao.getNewsView(no);
//  out.print("=========="+dto.getTitle());

%>
<!DOCTYPE html>
<html>
<head>
	<title>홍길동</title>
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.5.0/css/all.css" integrity="sha384-B4dIYHKNBt8Bc12p+WXckhzcICo0wtJAoU8YZTY5qE0Id1GSseTk6S+L3BlXeVIU" crossorigin="anonymous">	
	<link href="../css/common.css" rel="stylesheet">
	<link href="../css/layout.css" rel="stylesheet" >	
	<script>
		function goUpdate(){
//			alert("dddd");
			if(news.t_title.value == ""){
				alert("제목을 입력하시오");
				news.t_title.focus();
				return; /*goSave라는 것을 stop시키는 것*/
			}
			if(news.t_content.value == ""){
				alert("내용을 입력하시오");
				news.t_content.focus();
				return;
			}
			if(news.t_reg_name.value == ""){
				alert("작성자를 입력하시오");
				news.t_reg_name.focus();
				return;
			}
			if(news.t_reg_date.value == ""){
				alert("날짜를 입력하시오");
				news.t_reg_date.focus();
				return;
			}
			
			news.method= "post";               /*post방식으로 보내겠다*/
			news.action = "news_update.jsp";     /*어디로(경로)를 보낼지*/
			news.submit();					   /*실행시켜라*/
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
				<form name="news">
				<input type="hidden" name="t_no" value="<%=no%>">
				<table class="board_table">
					<colgroup>
						<col width="12%">
						<col width="30%">
						<col width="12%">
						<col width="*">
					</colgroup>
					<tbody>
						<tr>
							<th>게시판 제목</th>
							<td class="th_left" colspan="3">
								<input name="t_title" value="<%=dto.getTitle() %>" class="input_100Per" type="text">
							<!--%=는 out.print와 똑같은것  -->
							</td>
						</tr>
						<tr>
							<th>내 용</th>
							<td class="th_left" colspan="3">
								<textarea name="t_content"><%=dto.getContent() %></textarea>
								<!-- textarea는 value를 사용할 수 없기 때문에 textarea끝 부분에 입력해 줘야 된다 -->
							</td>
						</tr>
						<tr>
							<th>작성자</th>
							<td class="th_left">
								<input name="t_reg_name" value="<%=dto.getReg_name() %>" class="input_100px" type="text">
							</td>
							<th>작성일</th>
							<td class="th_left">
								<input name="t_reg_date" value="<%=dto.getReg_date() %>" class="input_150px" type="date">
							</td>
						</tr>
					</tbody>
				</table>
				</form>
			</div>
			<div class="btn_wrap">
				<input type="button" onClick="history.back()" value="이전" class="btn_list">
				<input type="button" onClick="goUpdate()" value="수정저장" class="btn_ok">&nbsp;&nbsp;
			</div>
		</div>
	</div>
</body>
</html>