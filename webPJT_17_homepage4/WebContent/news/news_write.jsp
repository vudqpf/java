<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "common.*" %>
<%
	Common common = new Common();
%>
<%@  include file="/common/common_subpage_head.jsp" %>
<script>
	function goSave(){
		if(news.t_title.value==""){
			alert("제목을 입력하시오");
			news.t_title.focus();
			return;
		}
		if(news.t_content.value==""){
			alert("내용을 입력하시오");
			news.t_content.focus();
			return;
		}
		if(news.t_reg_name.value==""){
			alert("작성자를 입력하시오");
			news.t_reg_name.focus();
			return;
		}
		if(news.t_reg_date.value==""){
			alert("일자를 입력하시오");
			news.t_reg_date.focus();
			return;
		}
		news.method="post";
		news.action = "db_save.jsp";
		news.submit();
	}
</script>
		<div id="b_left">
			<P>NOTICE & NEWS</P>
			<ul>
				<li><a href="/notice/notice_list.jsp"> NOTICE</a></li>
				<li><a href="/news/news_list.jsp"><span class="fnt"><i class="fas fa-apple-alt"></i></span> NEWS</a></li>
				<li><a href="/qanda/qanda_list.jsp">Q & A</a></li>
				<li><a href="/freeboard/freeboard_list.jsp">FREE BOARD</a></li>
				<li><a href="">ETC</a></li>
			</ul>
		</div>
		
		<div id="b_right">
			<p class="n_title">
				NEWS
			</p>
			
			<table class="boardForm">
				<colgroup>
					<col width="15%">
					<col width="35%">
					<col width="10%">
					<col width="40%">
				</colgroup>
				<form name="news">
					<input type="hidden" name="t_work_gubun" value="insert">
					<tbody>
						<tr>
							<th>Title</th>
							<td colspan="3"><input type="text" name="t_title" class="input600"></td>
						</tr>	
						<tr>
							<th>Content</th>
							<td colspan="3"><textarea name="t_content" class="textArea_H250"></textarea></td>
						</tr>		
						<tr>
							<th>Writer</th>
							<td>
								<input type="hidden" name="t_reg_name" value="<%=session_name%>" class="input100"></td>
							<th>RegDate</th>
							<td><input type="date" name="t_reg_date" value="<%=common.getToday() %>" class="input130"></td>
						</tr>	
					</tbody>
				</form>
			</table>
			<div class="buttonGroup">
				<a href="javascript:goSave()" class="butt">Save</a>
				<a href="news_list.jsp" class="butt">List</a>
			</div>	
		</div>	

<%@ include file="/common/common_subpage_bottom.jsp" %>
	</div>	
</body>
</html>