<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="dao.*, dto.*" %>
<%@  include file="/common/session_manager_check.jsp" %>
<%@  include file="/common/common_subpage_head.jsp" %>
<%
	Notice_dao dao = new Notice_dao();
	String no = request.getParameter("t_no");
	Notice_dto dto = dao.NotiveView(no);
%>
<script>
	function goUpdate(){
 		if(!checkEmpty(noti.t_title, " 제목 입력 ")) return;
 		if(!checkEmpty(noti.t_content, " 내용 입력 ")) return;
 		if(!checkEmpty(noti.t_reg_date, " 수정일 입력 ")) return;
		noti.method="post";
		noti.action="db_notice.jsp";
		noti.submit();
	}
</script>
	
		<div id="b_left">
			<P>NOTICE & NEWS</P>
			<ul>
				<li><a href="/notice/notice_list.jsp"><span class="fnt"><i class="fas fa-apple-alt"></i></span> NOTICE</a></li>
				<li><a href="/news/news_list.jsp">NEWS</a></li>
				<li><a href="/qanda/qanda_list.jsp">Q AND A</a></li>
				<li><a href="/freeboard/freeboard_list.jsp">FREE BOARD</a></li>
				<li><a href="">ETC</a></li>
			</ul>
		</div>
		
		<div id="b_right">
			<p class="n_title">
				NOTICE
			</p>
			
			<table class="boardForm">
				<colgroup>
					<col width="15%">
					<col width="35%">
					<col width="10%">
					<col width="40%">
				</colgroup>
				<form name="noti">
					<input type="hidden" name="t_work_gubun" value="update">
					<input type="hidden" name="t_no" value="<%=no%>">
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
							<th>Attach</th>
							<td colspan="3">
							<%if (dto.getAttach() !=null){ %>
								<%=dto.getAttach()%> 삭제<input type="checkbox"><br>
							<% } %>
								<input type="file" name="t_attach" class="input600">
							</td>
						</tr>	
						<tr>
							<th>Writer</th>
							<td><%=session_name %>
								<input type="hidden" name="t_reg_name" value="<%=session_name %>" class="input100"></td>
							<th>RegDate</th>
							<td><input type="date" name="t_reg_date" value="<%=dto.getReg_date() %>" class="input130"></td>
						</tr>	
	
					</tbody>
				</form>
			</table>
			<div class="buttonGroup">
				
				<a href="javascript:goUpdate()" class="butt">Update</a>
				<a href="notice_list.jsp" class="butt">List</a>
			</div>	
		</div>	

<%@ include file="/common/common_subpage_bottom.jsp" %>
	</div>	
</body>
</html>