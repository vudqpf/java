<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import = "dao.*, dto.*" %>
    <%
    News_dao dao = new News_dao();
    String no = request.getParameter("t_no");
//    out.print(" ==== no ==== " + no);

	News_dto dto = dao.getNewsView(no); /*조회하는거 */
	int hit = dao.hitCount(no);
//	out.print(" ==== " + dto.getTitle());
    %>
<!DOCTYPE html>
<html>
<head>
	<title>홍길동</title>
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.5.0/css/all.css" integrity="sha384-B4dIYHKNBt8Bc12p+WXckhzcICo0wtJAoU8YZTY5qE0Id1GSseTk6S+L3BlXeVIU" crossorigin="anonymous">	
	<link href="../css/common.css" rel="stylesheet">
	<link href="../css/layout.css" rel="stylesheet" >	
	<script>
		function goUpdateForm(){
//			alert("Dd");
			news.method="post";
			news.action = "news_updateForm.jsp"
			news.submit();
		}
		 function goDelete(){
			 var chk = confirm("증말 삭제 하시겠습니까? "); /*확인(true), 취소(false) 값이 chk에 들어옴*/
			if(chk){
			news.method="post";
			news.action = "news_delete.jsp"
			news.submit();
			}
		 }
	</script>
</head>
<body>
	<form name="news">
		<input type="hidden" name="t_no" value="<%=no%>">
	</form>
	<!-- form이 있는 이유는 post방식으로 넘겨주기 위하여 -->
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
					<tbody>
						<tr>
							<th>게시판 제목</th>
							<td class="th_left" >
								<%=dto.getTitle() %>
							</td>
							<th>조회수</th>
							<td class="th_left" >
								<%=dto.getHit() %>
							</td>
						</tr>
						<tr>
							<th>내용</th>
							<td class="th_left" colspan="3">
								<textarea name="t_content" class="board_textarea_H270_noBorder" readonly><%=dto.getContent() %></textarea>
							</td>
						</tr>
						<tr>
							<th>작성자</th>
							<td class="th_left">
								<%=dto.getReg_name() %>
							</td>
							<th>작성일</th>
							<td class="th_left">
							<%=dto.getReg_date() %>
							</td>
						</tr>						
					</tbody>
				</table>
			</div>
			<script type="text/javascript">
				function goList(){
					location.href="news_list.jsp" 
					/*자바스크립트에서는 페이지 넘길때 이런식으로 넘김*/
				}
			</script>
			
			<div class="btn_wrap">
				<input type="button" onClick="location.href='news_list.jsp'" value="목록" class="btn_list">
				<!-- history.back()은 목록버튼을 눌렀을 때 이전 화면으로 돌아가게하는 -->
				<!-- location.href=는 button형식에 써줘야 됨.... -->
				<input type="button" onClick="location.href='news_updateForm.jsp?t_no=<%=no %>'" value="수정GET" class="btn_list">
				<input type="button" onClick="goUpdateForm()" value="수정POST" class="btn_list">
				<input type="button" onClick="goDelete()" value="삭제" class="btn_list">
		<!--  	<a href="javascript:goDelete">삭제</a>   -->
			</div>
		</div>
	</div>
</body>
</html>