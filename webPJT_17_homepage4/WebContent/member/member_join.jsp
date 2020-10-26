<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@  include file="/common/common_subpage_head.jsp" %>	
<script type="text/javascript">
 	function goJoin(){
 		//var ttt = checkEmpty(mem.t_id," ID 입력 ");
 		if(!checkEmpty(mem.t_id,         " ID 입력 하시오 "		)) return;
 		if(!checkEmpty(mem.id_check_Gubun,         " ID 중복검사 하시오 "		)) return;
 		if(mem.id_check_Gubun.value != mem.t_id.value){
 			alert("ID 중복검사 하시오");
 			return;
 		}
 		if(!checkEmpty(mem.t_name,       " 성명 입력 "	)) return;
 		if(!checkEmpty(mem.t_pw,         " 비밀번호 입력 ")) return;
 		if(!checkEmpty(mem.t_pw_confirm, " 비밀번호 입력 ")) return;
 		if(!checkEmpty(mem.t_address,    " 주소 입력 "    )) return;
 		if(!checkEmpty(mem.t_tel_1,		 " 전화번호 입력 ")) return;
 		if(!checkEmpty(mem.t_tel_2,		 " 전화번호 입력 ")) return;
 		if(!checkEmpty(mem.t_tel_3,		 " 전화번호 입력 ")) return;
 		/*common_subpage_head.jsp 에서 src="/js/common.js"를 쓰겠다!! **/
 		/*return은 밑으로 내려가지 못하도록 함!*/
 		if(mem.t_pw_confirm.value != mem.t_pw.value){
 			alert("비밀번호 오류");
 			mem.t_pw_confirm.focus();
 			return;
 		}
 	/*	if(mem.t_id.value==""){
 			alert("ID를 입력하시오");
 			mem.t_id.focus();
 			return;
 		} 		*/
		mem.method="post";
		mem.action="db_member_join.jsp";
		mem.submit();
 	}
 	function checkId(){
 		if(!checkEmpty(mem.t_id,         " ID 입력 후 중복검사 하세요! ")) return;
 		var id = mem.t_id.value; /*스크립에서는 변수는 무조건 var*/
		window.open("member_check_id.jsp?t_id="+id,"ID중복검사","width=400,height=250")/*새개의 값을 설정해 줘야하고  팝업창을 띄우기 위한 메소드*/
 											/*1번째 팝업창으로 띄울 파일명, 
 											  2번째 팝업창의 제목, 
 											  3번째 팝업창 크기*/
 	}
</script>
<script type="text/javascript">
//<![CDATA[
	$(document).ready(function(){ /*jquery를 쓰겠다!!! 란!*/
		$("#idCheck").click(function(){
			var id = mem.t_id.value;
			if(id == ""){
				alert("ID 입력 후 검사!");
				return;
			}
			$.ajax({/*ajax를 시작하겠다!*/
				type:"post",  						/*post방식으로 보내겠다*/
				url:"member_check_id_ajax.jsp", 	/*form.action과 동일*/
				data:"t_id="+id,					/*위에 창을 열 때, t_id란 변수에 id란 값을 붙여서 페이지를 열겠다*/
				dataType:"text",					/*ajacx.jsp에서 보내준 값을 text형식으로 받겠다 =return타입*/
				error:function(){					/*위에 형식이 문제가 생기면!*/
					alert("통신 실패");
				},
				success:function(data){				/*위의 형식이 문제가 없을 때*/
					//alert("넘어온 값:==="+data+"==");		/*화면에 보이는 내용이 data값으로 넘어옴!*/
					$(".id_check_span").html(data);   /*$()소스안에 html안에 data를 넣겠다*/
					if($.trim(data) == "사용가능!"){   /*$.trim() 안에 있는 데이터 값의 앞뒤 공백을 없애준다!*/
						$(".id_check_span").css("color","blue");
						mem.id_check_Gubun.value = id;  /*중복이 아닐경우 id_check_Gubun상자에 값을 넣어준다*/
						mem.t_name.focus();
					}else{
						$(".id_check_span").css("color","red");
						mem.id_check_Gubun.value = "";   /*중복일 경우 id_check_Gubun에 공백을 넣어준다!*/
						mem.t_id.focus();
					}
				}
			});
			
			
			
		});
	});
//]]>
</script>
		<div id="b_left">
			<P>MEMBER</P>
			<ul>
				<li><a href="member_login.jsp">LOGIN</a></li>
				<li><a href="">ID / PASSWORD</a></li>
				<li><a href="member_join.jsp"><span class="fnt"><i class="fas fa-apple-alt"></i></span> CONTACK</a></li>
			</ul>
		</div>
		
		<div id="b_right">
			<p class="n_title">
				MEMBER JOIN
			</p>
			<form name="mem">
				<table class="boardForm">
				  <colgroup>
					<col width="200" />
					<col width="500" />
				  </colgroup>
				  <tbody>
					<tr>
					  <th><label for="id">I D</label></th>
					  <td>
						<input name="t_id" type="text" size="10" id="id" title="id입력하세요">
<!-- 중복체크 팝업창		<input type="button" onclick="checkId()" value="ID중복검사" class="checkB">   -->
					  	<input type="hidden" name="id_check_Gubun">					<!-- id_check_Gubun이 있는 이유는 id중복 검사를 하고  -->
						<input type="button" id="idCheck" value="ID중복검사ajax" class="checkB">
						<span class="id_check_span"></span>
					  </td>
					</tr>
					<tr>
					  <th><label for="nana">성 명</label></th>
					  <td><input name="t_name" type="text" size="8" id="nana"></td>
					</tr>
					<tr>
					  <th>비밀번호</th>
					  <td><input name="t_pw" type="password" size="13"></td>
					</tr>
					<tr>
					  <th>비밀번호확인</th>
					  <td><input name="t_pw_confirm" type="password" size="13"></td>
					</tr>
					<tr>
					  <th>지역</th>
					  <td>
						<select name="t_area">
							<option value="01">서울</option>
							<option value="02">대전</option>
							<option value="03">부산</option>
							<option value="04">대구</option>        
						</select>	  
					  </td>
					</tr>	
					
					<tr>
					  <th>주소</th>
					  <td><input name="t_address" type="text" size="40"></td>
					</tr>
					<tr>
					  <th>연락처</th>
					  <td>
						<input name="t_tel_1" type="text" size="2"> -
						<input name="t_tel_2" type="text" size="3"> -
						<input name="t_tel_3" type="text" size="3">
					  </td>
					</tr>
					<tr>
					  <th>남여구분</th>
					  <td>
						  <input type="radio" value="f" checked name="t_mf" class="middleCheck" /> 여&nbsp;&nbsp;        
						  <input type="radio" value="m" name="t_mf" class="middleCheck" /> 남        
					  </td>
					</tr>
					<tr>
					  <th>취미</th>
					  <td>
						  <input type="checkbox" value="y" name="t_hobby_t" class="middleCheck" /> 여행&nbsp;&nbsp; 
						  <input type="checkbox" value="y" name="t_hobby_r" class="middleCheck" /> 독서&nbsp;&nbsp; 
						  <input type="checkbox" value="y" name="t_hobby_s" class="middleCheck" /> 운동
					  </td>
					</tr>
				  </tbody>
				</table>
			</form>
			<div class="buttonGroup_center">
				<a href="javascript:goJoin()" class="butt">JOIN</a>
			</div>	
		</div>	

<%@ include file="/common/common_subpage_bottom.jsp" %>
	</div>	
</body>
</html>