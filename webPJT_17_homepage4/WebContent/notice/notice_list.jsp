<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "dao.*, dto.*, java.util.*, common.*" %>
<%@ include file="/common/common_subpage_head.jsp" %>
<%
	request.setCharacterEncoding("utf-8"); /*부분검색할때 글자를 다시 불러오는데 그때 깨짐을 방지하기 위해서*/
	Notice_dao dao = new Notice_dao();
	
	String select = request.getParameter("t_select");
	String search = request.getParameter("t_search");
	if(select == null){
		select = "title";
		search ="";
	}
	
	ArrayList<Notice_dto> arr = dao.getNoticeList(select, search);
	//*************page 시작**************/	
	int	list_setup_count = 10;			// 한 페이지에 출력될 List 수
	String r_page = request.getParameter("r_page");
	if(r_page==null) r_page= "";
	int			current_page;					// 현재페이지 번호
	int			total_page;						// 총페이지 수
	int			total_count;					// 총레코드 수
	int			for_count;						
	int			p_no;
	int			v_count;
	int			a_count;
	String		url				= null;	

	// 조회된 건수 구하기  total_count : 설정
	if(arr == null) total_count =0;
	else total_count = arr.size(); 


	// 페이지번호가 없으면 1페이지로 간주
	if(r_page.equals("")) current_page = 1;
	else current_page = Integer.parseInt(r_page);
		
	for_count		= list_setup_count;
	p_no			= list_setup_count;				// 페이지수가 10
	total_page = total_count / list_setup_count;		// 전체페이지수 계산 (if 23개 게시물이면 2)
   
	if(current_page == 1) {
		v_count		= 0;
		a_count		= list_setup_count;
		for_count	= 0;
	} else{
		v_count		= 0;
		a_count		= p_no * current_page;
		for_count	= a_count - list_setup_count;
	}
	if(total_page * list_setup_count != total_count)   total_page = total_page +1;

//*************page 끝**************/	
	
%>
<script type="text/javascript">
	function goSearch(){
		//alert("ddd");
		noti.method="post"
		noti.action="notice_list.jsp";
		noti.submit();
	}
	function goView(num){
		notiView.t_no.value = num;
		notiView.method="post"
		notiView.action="notice_view.jsp";
		notiView.submit();
	}
	function goPage(pageNumber){
		pageForm.r_page.value= pageNumber;
		pageForm.method="post";
		pageForm.action="notice_list.jsp";
		pageForm.submit();
	}
</script>
		<form name="pageForm">
			<input type="hidden" name="r_page" >
		</form>
		<form name="notiView">
			<input type="hidden" name="t_no">
		</form>
		<div id="b_left">
			<P>NOTICE & NEWS</P>
			<ul>
				<li><a href="/notice/notice_list.jsp"><span class="fnt"><i class="fas fa-apple-alt"></i></span> NOTICE</a></li>
				<li><a href="/news/news_list.jsp">NEWS</a></li>
				<li><a href="/qanda/qanda_list.jsp">Q & A</a></li>
				<li><a href="/freeboard/freeboard_list.jsp">FREE BOARD</a></li>
				<li><a href="">ETC</a></li>
			</ul>
		</div>
				
		<div id="b_right">
			<p class="n_title">
				NOTICE
			</p>
			<form name="noti">
			<div class="top_sel">
				<p class="leftBox">총 게시글 : <%=arr.size() %>건</p>
				<p class="select_box">
					<select name="t_select" class="sel_box">
						<option value="title" <%if(select.equals("title")) out.print("selected"); %>>Title</option>
						<option value="content" <%if(select.equals("content")) out.print("selected"); %>>Content</option>
					</select>
					<input name="t_search" type="text" class="sel_text" value="<%=search %>">
					<button type="botton" onclick="goSearch()" class="sel_button"><i class="fa fa-search"></i> SEARCH</button>
				</p>
			</div>
			</form>
			<table class="boardList">
				<colgroup>
					<col width="10%">
					<col width="57%">
					<col width="5%">
					<col width="10%">
					<col width="14%">
					<col width="6%">
				</colgroup>
				<thead>
					<tr>
						<th>No</th>
						<th>Title</th>
						<th>Attach</th>
						<th>Reg Name</th>
						<th>Reg Date</th>
						<th>Hit</th>
					</tr>
				</thead>
				<tbody>
				<%	if ( total_count > 0 ){
						for(int k = 0 ; k < total_count ; k++ )	{
							if(v_count == for_count){ 
				%> 	
					<tr>
				<!-- 	<td><a href="notice_view.jsp?t_no=<%=arr.get(k).getNo() %>"><%=arr.get(k).getNo() %></a></td> -->
						<td><a href="javascript:goView('<%=arr.get(k).getNo() %>')"><%=arr.get(k).getNo() %></a></td>
						<td class="t_center"><a href="notice_view.jsp?t_no=<%=arr.get(k).getNo() %>"><%=arr.get(k).getTitle() %></a></td>
					 		<td><%if(arr.get(k).getAttach()!=null) {%>
					 			<img src="../images/clip.png" >
					 			<% } %></td>
						<td><%= arr.get(k).getReg_name() %></td>
						<td><%= arr.get(k).getReg_date() %></td>
						<td><%= arr.get(k).getHit() %></td>
					</tr>
					<%
					v_count = v_count + 1;
					for_count = for_count + 1;
					}else { 
						v_count = v_count + 1;
					}
					if(v_count == a_count)break; 
				}
		}
%>
				</tbody>
			</table>

			<div class="paging">
<!-- 			
				<a href=""><i class="fa fa-angle-double-left"></i></a>
				<a href=""><i class="fa fa-angle-left"></i></a>
				<a href="" class="active">1</a>
				<a href="">2</a>
				<a href="">3</a>
				<a href="">4</a>
				<a href="">5</a>
				<a href=""><i class="fa fa-angle-right"></i></a>
				<a href=""><i class="fa fa-angle-double-right"></i></a>
 -->			
				<%
					out.println(CommonUtil.pageListPost(current_page, total_page));			
					if(session_level.equals("top")) { %>
						<a href="notice_write.jsp" class="write">글쓰기</a>
					<%} %>
			</div>
		</div>	
	
<%@ include file="/common/common_subpage_bottom.jsp" %>
	</div>	
</body>
</html>