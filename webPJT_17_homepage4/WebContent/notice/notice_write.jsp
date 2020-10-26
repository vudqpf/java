<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "common.*" %>
<%@  include file="/common/session_manager_check.jsp" %>
<%@  include file="/common/common_subpage_head.jsp" %>
<%
	Common com = new Common();
%>
<script type="text/javascript">
	function goSave(){
		if(noti.t_title.value==""){
			alert(" 제목을 입력하시오! ");
			noti.t_title.focus();
			return;
		}
		if(noti.t_content.value==""){
			alert(" 내용을 입력하시오! ");
			noti.t_content.focus();
			return;
		}
		if(noti.t_reg_date.value==""){
			alert(" 날짜를 입력하시오! ");
			noti.t_reg_date.focus();
			return;
		}
		noti.method="post";
//		noti.action="db_notice_save.jsp";
//	 	noti.action="db_notice.jsp";   /*등록, 수정, 삭제를 한 jps에서 */
	 	noti.action="db_notice_save_file.jsp";   
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
			<form name="noti" enctype="multipart/form-data"> <!--첨부파일을 가지고 있는 form에 enctype를 지정해 줘야 한다. -->
			<input type="hidden" name="t_work_gubun" value="insert">
			<table class="boardForm">
				<colgroup>
					<col width="15%">
					<col width="35%">
					<col width="10%">
					<col width="40%">
				</colgroup>
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
						<th>Attach</th>
						<td colspan="3"><input type="file" name="t_attach" class="input600"></td>
					</tr>	
					<tr>
						<th>Writer</th>
						<td>
							<input type="hidden" name="t_reg_name" value="<%=session_name%>" class="input100"><%=session_name%></td>
						<th>RegDate</th>
						<td><input type="date" name="t_reg_date" value="<%=com.getToday() %>" class="input130"></td>
					</tr>	

				</tbody>
			</table>
			</form>
			<div class="buttonGroup">
				<a href="javascript:goSave()" class="butt">Save</a>
				<a href="notice_list.jsp" class="butt">List</a>
			</div>	
		</div>	

<%@ include file="/common/common_subpage_bottom.jsp" %>
	</div>	
</body>
</html>