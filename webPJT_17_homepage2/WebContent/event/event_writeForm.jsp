<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	
	<title>홍길동</title>
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.5.0/css/all.css" integrity="sha384-B4dIYHKNBt8Bc12p+WXckhzcICo0wtJAoU8YZTY5qE0Id1GSseTk6S+L3BlXeVIU" crossorigin="anonymous">	
	<link href="../css/common.css" rel="stylesheet">
	<!-- ../상대 경로로서 위로 올라가서 css폴더 경로를 찾는 -->
	<link href="/css/layout.css" rel="stylesheet" >	
	<!-- /은 절대 경로소서 webContent의 폴더 안에 있는 css폴더를 찾는 -->
	<!-- /가 없으면 이 파일이 소속되어 있는 event폴더 안에 있는 css폴더를 탐색하는 -->
	<script type="text/javascript">
		function goSave(){
		//	alert("1234");
			if(board.t_title.value==""){
				alert("제목 입력!");
				board.t_title.focus();
				return;
			}if(board.t_s_date.value==""){
				alert("이벤트 시작 날짜 입력!");
				board.t_s_date.focus();
				return;
			}if(board.t_e_date.value==""){
				alert("이벤트 종료 날짜 입력!");
				board.t_e_date.focus();
				return;
			}if(board.t_content.value==""){
				alert("내용 입력!");
				board.t_content.focus();
				return;
			}if(board.t_reg_name.value==""){
				alert("등록 이름 입력!");
				board.t_reg_name.focus();
				return;
			}if(board.t_reg_date.value==""){
				alert("등록 일짜 입력!");
				board.t_reg_date.focus();
				return;
			}
			board.method="post";
			board.action="db_save.jsp";
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
			<form name="board">
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
							<th>Event 제목</th>
							<td class="th_left" colspan="3">
								<input name="t_title"  class="input_100Per" type="text">
							</td>
						</tr>
						<tr>
							<th>Event 기간</th>
							<td class="th_left" colspan="3">
								<input name="t_s_date"  class="input_150px" type="date">
								~
								<input name="t_e_date"  class="input_150px" type="date">
							</td>
						</tr>
						<tr>
							<th>내용</th>
							<td class="th_left" colspan="3">
								<textarea name="t_content"></textarea>
							</td>
						</tr>
						<tr>
							<th>작성자</th>
							<td class="th_left">
								<input name="t_reg_name"  class="input_100px" type="text">
							</td>
							<th>작성일</th>
							<td class="th_left">
								<input name="t_reg_date"  class="input_150px" type="date">
							</td>
						</tr>
						
					</tbody>
				</table>
			</div>
			</form>
			<div class="btn_wrap">
				<!-- <a href="javascript:goSave()">등록</a> -->
				<input type="button" onclick="goSave()" value="저장" class="btn_ok">&nbsp;&nbsp;
				<input type="button" onclick="history.back()" value="목록" class="btn_list">
			</div>
		</div>
	</div>
</body>
</html>