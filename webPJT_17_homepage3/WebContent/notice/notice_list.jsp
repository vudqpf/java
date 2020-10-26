<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "dao.*, dto.*, java.util.*" %> 
<%
	request.setCharacterEncoding("utf-8");
	Notice_dao dao = new Notice_dao();
	String select = request.getParameter("t_select");  /*title, content 선택되는*/
	String search = request.getParameter("t_search"); /*내용검색하는*/
	if(select == null){
		select = "title";
		search = "";
	}
	ArrayList<Notice_dto> arr = dao.getNoticeList(select, search);
	
	/*select와 search값을 넘겨줘야 하기 때문에 ArrayList가 밑으로*/
	
//	out.print("===select======"+select);
%>   
    
<!doctype html>
<html lang="ko">
<head>
<meta charset="utf-8">
<title>JSL 방문을 환영합니다</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" type="text/css" href="/css/font-awesome.min.css">
<link rel="stylesheet" type="text/css" href="/css/reset.css" />
<link rel="stylesheet" type="text/css" href="/css/base.css" /> 

<!-- <link href="../css/font-awesome.min.css" rel="stylesheet">  -->
<!-- <script type="text/javascript" src="../js/jquery-1.8.1.min.js"></script> -->
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.5.0/css/all.css" integrity="sha384-B4dIYHKNBt8Bc12p+WXckhzcICo0wtJAoU8YZTY5qE0Id1GSseTk6S+L3BlXeVIU" crossorigin="anonymous">	
<script type="text/javascript">
    //<![CDATA[
		$(function(){
		  $(".menu1").mouseover(function(){
			$("#s_div_1").stop().slideDown("slow");
		  });
		  $(".menu1").mouseleave(function(){
			$("#s_div_1").stop().slideUp("slow");
		  });		  
		  $(".menu2").mouseover(function(){
			$("#s_div_2").stop().slideDown("slow");
		  });
		  $(".menu2").mouseleave(function(){
			$("#s_div_2").stop().slideUp("slow");
		  });		  
		  $(".menu3").mouseover(function(){
			$("#s_div_3").stop().slideDown("slow");
		  });
		  $(".menu3").mouseleave(function(){
			$("#s_div_3").stop().slideUp("slow");
		  });		  
		  $(".menu4").mouseover(function(){
			$("#s_div_4").stop().slideDown("slow");
		  });
		  $(".menu4").mouseleave(function(){
			$("#s_div_4").stop().slideUp("slow");
		  });		  
		  $(".menu5").mouseover(function(){
			$("#s_div_5").stop().slideDown("slow");
		  });
		  $(".menu5").mouseleave(function(){
			$("#s_div_5").stop().slideUp("slow");
		  });		  
		  
		});    
    //]]>
</script>    
<script type="text/javascript">
	function goSearch(){
	//	alert("1234");
		noti.method="post";
		noti.action="notice_list.jsp";
		noti.submit();
	}
</script>
<style>
<!-- body { font : 12px "굴림", Gulim ; background : url("images/bg_grid.gif") ; }	 -->
#container {
	width: 940px;
	margin: 0px auto;
//	margin: 0px;
	padding: 20px;
	border: 0px solid #bcbcbc;
//	background : #ccc;
}
#header {
	width: 940px;
	height:140px;
	padding: 0px;
	margin-bottom: 20px;
	border: 0px solid red;
//	background : #F5DA81;
}
#menu {
	width: 130px;
	height : 460px;
	padding: 20px 10px;
	margin-bottom: 20px;
	float: left;
	border: 0px solid #bcbcbc;
//	background :#E0F2F7;
}	  
#content {
	width: 748px; 
	height : 460px;
	padding: 20px;
	margin-bottom: 20px;
	float: right;
	border: 0px solid #bcbcbc;
//	background :#A9E2F3;
}
#footer {
	clear: both;
	padding: 20px;
	border: 1px solid #bcbcbc;
	background :#BCA9F5;
}

.header_menu li{
	float:left;
}

.header_menu li a{
	display : inline-block;
	//padding-top:5px;
	width : 188px;
	height : 20px;
	background : #A9A9A9;
	text-align:center;
	line-height: 20px;
	opacity : 0.8;
	color : white;
}

#header{
	background:url("../images/back_img_4.jpg");
	position : relative;
}
.header_menu{
	position : absolute;
	top : 120px;
}

#s_div_1,#s_div_2,#s_div_3,#s_div_4{
	position : absolute;
	display : none;
}
#s_div_5{
	position : absolute;
	display : none;
	right : 0px;
}


#s_div_1 ul li a{
	width : 100px;
	background : #A9D0F5;
}  
#s_div_2 ul li a{
	width : 100px;
	background : #A9D0F5;
} 
#s_div_3 ul li a{
	width : 100px;
	background : #A9D0F5;
} 
#s_div_4 ul li a{
	width : 100px;
	background : #A9D0F5;
} 
#s_div_5 ul li a{
	width : 100px;
	background : #A9D0F5;
} 
.top_right{
	position : relative;
	top : -15px;
}
.top_right li{
	float : right;
	border-right : 1px solid #6E6E6E;
}
.top_right li a{
	display:inline-block;
	width:50px;
	height : 14px;
	text-align:center;
	color : #848484;
	font-size : 10px;
}
</style>
</head>
<body>
    <div id="container">
		<ul class="top_right">
			<li><a href="">JOIN</a></li>
			<li><a href="">LOGIN</a></li>
			<li><a href="">HOME</a></li>
		</ul>
		<div id="header">
			<ul class="header_menu">
				<li class="menu1"><a href="#">회사소개</a>
					<div id="s_div_1">
						<ul>
							<li><a href="">CEO 인사말</a></li>
							<li><a href="">전년판매현황</a></li>
							<li><a href="">VISION</a></li>
							<li><a href="">찾아오는길</a></li>
						</ul>
					</div>
				</li>
				<li class="menu2"><a href="#">제품안내</a>
					<div id="s_div_2">
						<ul>
							<li><a href="">DESKTOP</a></li>
							<li><a href="">NOTEBOOK</a></li>
							<li><a href="">PRINTER</a></li>
							<li><a href="">BEAM</a></li>
							<li><a href="">주변기기</a></li>
						</ul>
					</div>					
				</li>
				<li class="menu3"><a href="#">판매안내</a>
					<div id="s_div_3">
						<ul>
							<li><a href="">Online</a></li>
							<li><a href="">Offline</a></li>
						</ul>
					</div>					
				</li>
				<li class="menu4"><a href="#">주문안내</a>
					<div id="s_div_4">
						<ul>
							<li><a href="">배송안내</a></li>
							<li><a href="">환불안내</a></li>
						</ul>
					</div>					
				</li>
				<li class="menu5"><a href="notice_r.html">커뮤니티</a>
					<div id="s_div_5">
						<ul>
							<li><a href="notice_r.html">NOTICE</a></li>
							<li><a href="">NEWS</a></li>
							<li><a href="">자유게시판</a></li>
							<li><a href="">Q & A</a></li>
						</ul>
					</div>					
				</li>
			</ul>		
		</div>
 <style> 
 
	#menu ul li a{
		font : bold 12px "돋음", Gulim ; 
		color :#6E6E6E; 
		border-bottom : 1px dotted #848484;
		display : inline-block;
		width : 130px;
		height : 25px;
		//background : yellow;
		line-height : 25px;
	}
	.arrow{
		vertical-align:middle;
		width : 6px;
	}
	.home_icon{
		width : 15px;
	}
	#content{
		font : 10px "돋음", Gulim ; 
		color :#848484; 
	}	
	#content .title a{
		font : 10px "돋음", Gulim ; 
		color :#6E6E6E; 
	}	
.select_Box {
	text-align : right;
}

.select_Box .sel_box{
	width : 50px;
	height : 20.5px;
	font-size : 10px;
	color :#848484; 
}
.select_Box .sel_text{
	vertical-align:top;
	width : 80px;
	height : 16.5px;
	font-size : 11px;
}
.select_Box .sel_button{
	vertical-align:top;
	width : 60px;
	height : 20.5px;
	font-size : 11px;
	color :#848484; 
}	
 </style> 
      <div id="menu">
		<ul>
			<li><a href="/notice/notice_list.jsp"><img class="arrow" src="../images/arrow.gif"> NOTICE</a></li>
			<li><a href="/news/news_list.jsp"><img class="arrow" src="../images/arrow.gif"> NEWS</a></li>
			<li><a href=""><img class="arrow" src="../images/arrow.gif"> 자유게시판</a></li>
			<li><a href=""><img class="arrow" src="../images/arrow.gif"> Q & A</a></li>

		</ul>
      </div>
      <div id="content">
			<ul>
				<!-- <li class="btn_home"> -->
					<!-- <a href="index.html"><i class="fa fa-home btn_plus"></i></a> -->
				<!-- </li> -->
				<li class="btn_home">
					<a href="index.html">
						<img src="../images/home3.png" class="home_icon">
					</a>
					&nbsp;HOME | &nbsp;커뮤니티 | NOTICE
				</li>
			</ul>
			<form name="noti">
			<p class="select_Box">
				<select class="sel_box" name="t_select" >
				<!-- 제목을 선택하면 title 내용을 선택하면 content -->
					<option value="title" <%if(select.equals("title"))out.print("selected");%> >제목</option>
					<!-- selected는 검색버튼을 눌렀을 때 검색내용이 남아있도록 -->
					<option value="content" <%if(select.equals("content"))out.print("selected");%>>내용</option>
				</select>
				<input type="text" name="t_search" value="<%=search %>" maxlength="20" class="sel_text" />
				<!-- value="<%=search %>"는 text상자에 내가 검색한 내용이 남아 있도록 하는 것 -->
				<input type="button" onclick="goSearch()" value="검  색" class="sel_button" >
				<!-- onclick의 경우 javascript를 안써줘도 됨 -->
			</p>		
			</form>	
<style>
.bord_list { padding-top:10px;}
.bord_table {width:100%;}
.bord_list th {
	border-top:1px solid #848484;
	border-bottom:1px solid #848484; 
	padding: 10px;
}
.bord_table td {
	border-bottom:1px solid #e0e0e0; 
	padding:10px; 
	text-align:center;}
.bord_table td.title {text-align:left;}

/* footer css */

#footer {clear:both;background:#42464d; padding-top:10px; padding-bottom:10px; margin-top:60px;}
#footer .address {font-style:normal; color:#ababb1; margin-bottom:20px;}
#footer .address .title {font-size:14px; margin-bottom:8px; color:#fff;}
#footer  .copyright {color:#fff;}

.paging {clear:both; padding-top:30px; text-align:center;}
.paging a  {padding:10px; border:1px solid #e0e0e0;}
.paging a.active {background:#007dc6; color:#fff;}
.paging .btn_write {background:#BDBDBD; padding:10px 16px; color:#fff; float:right;}

</style>			
			
	  <div class="bord_list">
		<table class="bord_table">
			<colgroup>
				<col width="10%">
				<col width="*">
				<col width="7%">
				<col width="10%">
				<col width="13%">
				<col width="10%">
			</colgroup>
			<thead>
				<tr>
					<th>번호</th>
					<th>제목</th>
					<th>첨부</th>
					<th>글쓴이</th>
					<th>작성일</th>
					<th>조회수</th>
				</tr>
			</thead>
			<tbody>
<%
			for(int k=0; k < arr.size(); k++) {
%>			
				<tr>
					<td><a href="notice_view.jsp?t_no=<%=arr.get(k).getNo()%>"><%=arr.get(k).getNo()%></a></td>
					<td class="title"><a href="notice_view.jsp?t_no=<%=arr.get(k).getNo()%>"><%=arr.get(k).getTitle() %></a></td>
					<td>
						<%if(arr.get(k).getAttach() != null) {%>
							<img src="/images/clip.png">
						<%} %>
					</td>
					<td><%=arr.get(k).getReg_name() %></td>
					<td><%=arr.get(k).getReg_date() %></td>
					<td><%=arr.get(k).getHit() %></td>
				</tr>
<% } %>				

			</tbody>
		</table>
		<div class="paging">
			<a href=""><i class="fa fa-angle-double-left"></i></a>
			<a href=""><i class="fa fa-angle-left"></i></a>
			<a href="" class="active">1</a>
			<a href="">2</a>
			<a href="">3</a>
			<a href="">4</a>
			<a href="">5</a>
			<a href=""><i class="fa fa-angle-right"></i></a>
			<a href=""><i class="fa fa-angle-double-right"></i></a>
			<a href="notice_writeForm.jsp" class="btn_write">글쓰기</a>
		</div>
	  </div>			
			
			
      </div>
	  
      <div id="footer">
		<div class="container clearfix">
			<address class="address">
				<p class="title">본사</p>
				(우)12345 대전광역시 중구 계룡로 825 (용두동, 희영빌딩) 5층,6층/고객센터: 042-242-4412 	<br>사업자등록번호: 305-86-06709
			</address>
			<p class="copyright">Copyright &copy JSL 전자개발주식회사. All rights reserved.</p>
		</div>
      </div>
    </div>
  </body>
</html>