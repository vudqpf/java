<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@  include file="/common/session_manager_check.jsp" %>
<%@ page import = "dao.*, dto.*, common.*" %>
<%
	Common common = new Common();
	Qanda_dao dao = new Qanda_dao();
	
	String no = request.getParameter("t_no");
	Qanda_dto dto = dao.getQuestionInfo(no);
	
%>
<%@  include file="/common/common_subpage_head.jsp" %>
<script>
	function goUpdate(){
 		if(!checkEmpty(qanda.t_title, " 제목 입력 ")) return;
 		if(!checkEmpty(qanda.t_content, " 내용 입력 ")) return;
/*		if(qanda.t_title.value==""){
			alert("제목을 입력하시오");
			qanda.t_title.focus();
			return;
		}
		if(qanda.t_content.value==""){
			alert("내용을 입력하시오");
			qanda.t_content.focus();
			return;
		}
*/		
		qanda.method="post";
		qanda.action = "db_question_update.jsp";
		qanda.submit();
	}
</script>
		<div id="b_left">
			<P>NOTICE & NEWS</P>
			<ul>
				<li><a href="/notice/notice_list.jsp"> NOTICE</a></li>
				<li><a href="/news/news_list.jsp"><span class="fnt">NEWS</a></li>
				<li><a href="/qanda/qanda_list.jsp"><i class="fas fa-apple-alt"></i></span> Q & A</a></li>
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
				<form name="qanda">
					<input type="hidden" name="t_no" value="<%=no%>">
					<tbody>
						<tr>
							<th>Title</th>
							<td colspan="3"><input type="text" name="t_title" value="<%=dto.getTitle() %>" class="input600"></td>
						</tr>	
						<tr>
							<th>Content</th>
							<td colspan="3"><textarea name="t_content"  class="textArea_H250"><%=dto.getContent() %></textarea></td>
						</tr>		
						<tr>
							<th>Writer</th>
							<td><%=dto.getQ_reg_name()%><!-- 매니저가 수정할 수 있기  때문에 -->
								<input type="hidden" name="t_reg_id" value="<%=dto.getQ_reg_id()%>" class="input100"></td>
							<th>RegDate</th>
							<td><%=Common.getToday() %>
								<!-- <input type="date" name="t_reg_date" value="<%=dto.getQ_reg_date() %>" class="input130"> -->
							</td>
						</tr>	
					</tbody>
				</form>
			</table>
			<div class="buttonGroup">
				<a href="javascript:goUpdate()" class="butt">Save</a>
				<a href="qanda_list.jsp" class="butt">List</a>
			</div>	
		</div>	

<%@ include file="/common/common_subpage_bottom.jsp" %>
	</div>	
</body>
</html>