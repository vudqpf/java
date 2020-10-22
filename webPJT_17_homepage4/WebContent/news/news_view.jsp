<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "dao.*, dto.*" %>
<%
	News_dao dao = new News_dao();
	String no = request.getParameter("t_no");
	dao.getNewshit(no);
	News_dto dto = dao.newsView(no);
%>
<%@  include file="/common/common_subpage_head.jsp" %>
<script>
	function goUpdate(){
	//	alert("1234");
		update.method="post";
		update.action="news_update.jsp"
		update.submit();
	}
	function goDelete(){
		//alert("1234");
		if(confirm(" 정말 삭제하시겠습니까? ")){
		update.method="post";
		update.action="db_save.jsp";
		update.submit();
		}
	}
</script>
			<form name="update">
			<input type="hidden" name="t_no" value="<%=dto.getNo()%>">
			<input type="hidden" name="t_work_gubun" value="delete">
			</form>
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
					<col width="55%">
					<col width="10%">
					<col width="20%">
				</colgroup>
				<tbody>
					<tr>
						<th>Title</th>
						<td colspan="2"><%=dto.getTitle() %></td>
						<td> <i class="far fa-eye"></i><%=dto.getHit() %></td>
					</tr>	
					<tr>
						<th>Content</th>
						<td colspan="3">
							<textarea class="textArea_H250_noBorder" readonly><%=dto.getContent() %></textarea>
						</td>
					</tr>	
					<tr>
						<th>Writer</th>
						<td><%=dto.getReg_name() %></td>
						<th>RegDate</th>
						<td><%=dto.getReg_date() %></td>
					</tr>	
				</tbody>
			</table>
			<div class="buttonGroup">
			<% if(session_level.equals("top")) {%>
				<a href="javascript:goDelete()" class="butt">Delete</a>
				<a href="javascript:goUpdateForm()" class="butt">Update</a>
			<% } %>	
				<a href="news_list.jsp" class="butt">List</a>
			</div>	
		</div>	

<%@ include file="/common/common_subpage_bottom.jsp" %>
	</div>	
</body>
</html>