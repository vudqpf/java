<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
	function goForm(){
		var id = mem.t_id.value;
		if(id == ""){
			alert("id 값 입력하시오~");
			mem.t_id.focus();  /*mem.t_id.focus();은 커서가 id에 바로 올라오도록*/
			return;       /*return은 값을 빠져 나가게 함*/
		}
		if(mem.t_name.value == ""){
			alert("성명 입력하시오~");
			mem.t_name.focus();
			return;
		}
		mem.method = "post";
		mem.action = "form_3.jsp";
		mem.submit();
	}
</script>
</head>
<body>
	<form name="member" method="post" action="form_2.jsp"> 
		성명 : <input type = "text" name="t_name" size="5"> <br>
		지역 : <input type = "text" name="t_area" size="5"> <br>
		나이 : <input type = "text" name="t_age" size="5"> <br>
		<input type="submit" value="저장11">
	</form>	
	<form name="mem"> 
		ID : <input type = "text" name="t_id" size="5"> <br>
	 	성명 : <input type = "text" name="t_name" size="5"> <br>
		비번 : <input type = "text" name="t_pw" size="5"> <br>
		지역 : 
		<select name="t_area">		
			<option>서울</option>
			<option>대전</option>
			<option>부산</option>
		</select><br>
		남여 : 
		<input type="radio" name="t_mf" value="남자">남
		<input type="radio" name="t_mf" value="여자">여
		
		<input type="button" onclick="goForm()" value="저장22">
	</form>	
</body>
</html>	