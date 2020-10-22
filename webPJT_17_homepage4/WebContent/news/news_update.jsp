<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "dao.*, dto.*" %>
<%@  include file="/common/session_manager_check.jsp" %>
<%@  include file="/common/common_subpage_head.jsp" %>
<%
	request.setCharacterEncoding("utf-8");
	String no = request.getParameter("t_no");
	
	News_dao dao = new News_dao();
	News_dto dto = dao.newsView(no);
%>
<script>
	function goUpdate(){
		//alert("1234");
		updateForm.method = "post";
		updateForm.action = "db_save.jsp";
		updateForm.submit();
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
				<form name="updateForm">
					<input type="hidden" name="t_no" value="<%=no%>">
					<input type="hidden" name="t_work_gubun" value="update">
					<tbody>
						<tr>
							<th>Title</th>
							<td colspan="3"><input type="text" name="t_title" class="input600" value="<%=dto.getTitle()%>"></td>
						</tr>	
						<tr>
							<th>Content</th>
							<td colspan="3"><textarea name="t_content" class="textArea_H250"><%=dto.getContent()%></textarea></td>
						</tr>		
						<tr>
							<th>Writer</th>
							<td><%=session_name %>
								<input type="hidden" name="t_reg_name" value="<%=session_name %>" class="input100"></td>
							<th>RegDate</th>
							<td><input type="date" name="t_reg_date" value="<%=dto.getReg_date()%>" class="input130"></td>
						</tr>	
					</tbody>
				</form>
			</table>
			<div class="buttonGroup">
				<a href="javascript:goDelete()" class="butt">Delete</a>
				<a href="javascript:goUpdate()" class="butt">Update</a>
				<a href="notice_list.jsp" class="butt">List</a>
			</div>	
		</div>	
<%@ include file="/common/common_subpage_bottom.jsp" %>

	</div>	
</body>
</html>