<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@  include file="/common/common_subpage_head.jsp" %>
<script>
	function abc(){
		var keyCodeValue = event.keyCode;
		if(keyCodeValue == 13){ /*id를 입력하고 엔터를 누르면 pw인풋 상자로 커서가 넘어감*/
			frmLogin.t_pw.focus();	
		}
	}
	function memberLogin(){
 		if(!checkEmpty(frmLogin.t_id, " ID 입력 "	)) return;
 		if(!checkEmpty(frmLogin.t_pw, " PW 입력 "	)) return;
		frmLogin.method="post";
		frmLogin.action="db_member_login.jsp";
		frmLogin.submit();
	}
</script>
		<div id="b_left">
			<P>MEMBER</P>
			<ul>
				<li><a href="member_login.jsp"><span class="fnt"><i class="fas fa-apple-alt"></i></span>LOGIN</a></li>
				<li><a href="">ID / PASSWORD</a></li>
				<li><a href="member_join.jsp"> CONTACT</a></li>
			</ul>
		</div>
		
		<div id="b_right">
			<p class="n_title">
				MEMBER LOGIN
			</p>
		
			<div class="login">
				<div class="member_boxL">
					<h2>LOGIN</h2>
					<div class="login_form">
						<form name="frmLogin">
							<input type="hidden" name="t_gubun" value="login">
							<div class="fl_clear"><label for="mbrId">아이디</label><input name="t_id" id="mbrId" type="text" onkeypress="abc()"></div>
								<!-- onkeypress 키보드에 어떤 버튼을 누르면 실행해라 keyCode13은 엔터키 -->
							<div class="fl_clear"><label for="scrtNo">비밀번호</label><input name="t_pw" id="scrtNo" type="password" onkeypress="if(event.keyCode==13){memberLogin()}"></div>
							<a class="btn_login btn_Blue" href="javascript:memberLogin()">로그인</a>
						</form>
					</div>
				   
				</div>		
			</div>

		</div>	

<%@ include file="/common/common_subpage_bottom.jsp" %>
	</div>	
</body>
</html>






