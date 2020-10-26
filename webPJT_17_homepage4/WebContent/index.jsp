<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String session_name = (String)session.getAttribute("session_name");
	//out.print("session_name = "+session_name);
	/*getAttribute는 return을 object로 함! object는 변형이 가능하기 때문에 String으로 캐스팅!*/
	/*object는 요리로 말하면 밀가루 상*/
%>
<html>
<head>
<link href="css/index_c.css" rel="stylesheet">
<link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.13.0/css/all.min.css" rel="stylesheet">
<script type="text/javascript" src="js/jquery-1.8.1.min.js"></script>	
<title>한주연</title>
<script type="text/javascript">
	$(function(){
		$(".main_menu > li > a").hover(function(){
			$(this).css("font-weight","bold");
		},function(){
			$(this).css("font-weight","");
		});		
		
		$(".bu_1").mouseover(function(){
			var imgName = $(this).attr('src');
			if(imgName =="images/bu_01.jpg"){
				$(this).attr("src","images/bu_01_over.jpg");
			} else if(imgName =="images/bu_02.jpg"){
				$(this).attr("src","images/bu_02_over.jpg");
			} else if(imgName =="images/bu_03.jpg"){
				$(this).attr("src","images/bu_03_over.jpg");
			} else if(imgName =="images/bu_04.jpg"){
				$(this).attr("src","images/bu_04_over.jpg");
			} else if(imgName =="images/bu_05.jpg"){
				$(this).attr("src","images/bu_05_over.jpg");
			} else if(imgName =="images/bu_06.jpg"){
				$(this).attr("src","images/bu_06_over.jpg");
			}
		});	
		$(".bu_1").mouseout(function(){
			var imgName = $(this).attr('src');
			if(imgName =="images/bu_01_over.jpg"){
				$(this).attr("src","images/bu_01.jpg");
			} else if(imgName =="images/bu_02_over.jpg"){
				$(this).attr("src","images/bu_02.jpg");
			} else if(imgName =="images/bu_03_over.jpg"){
				$(this).attr("src","images/bu_03.jpg");
			} else if(imgName =="images/bu_04_over.jpg"){
				$(this).attr("src","images/bu_04.jpg");
			} else if(imgName =="images/bu_05_over.jpg"){
				$(this).attr("src","images/bu_05.jpg");
			} else if(imgName =="images/bu_06_over.jpg"){
				$(this).attr("src","images/bu_06.jpg");
			}			
		});				

		$(".allclick").click(function(e){
			e.preventDefault();
			$("#disableDiv").css("display","block");
			$("#b_menu_all").slideDown(500);
			$("#b_menu_all").css("z-index","999");
		});
		
		$(".closeclick").click(function(e){
			e.preventDefault();
			$("#b_menu_all").slideUp(500);
			$("#disableDiv").css("display","none");
		});

	});	
</script>
</head>
<body>
<style>
#disableDiv { position:absolute; left:0; top:0;width:100%; height:1700px; z-index:995 ; background-color:#EEEEEE; filter:Alpha(opacity=80);opacity:0.8; -moz-opaciry:0.8}
</style>
<div id="disableDiv" class="disableDiv" style="display:none"></div>
<div id="container">

	<div id="container_top">	
			<div id="b_top_menu">
				<ul class="top_menu">
					<li><a href="" class="allclick"><i class="fas fa-bars"></i></a></li>
<%                  if(session_name == null) { %>
						<li><a href="/member/member_join.jsp">Contact</a></li>
						<li><a href="/member/member_login.jsp">Login</a></li>
<%                   } else { %>
						<li><a href="/member/member_logout.jsp">LogOut</a></li>				
<%                   } %>

					<li><a href=""><i class="fa fa-home" aria-hidden="true"></i> Home</a></li>
<%                  if(session_name != null) { %>					
					<li><a href=""><%=session_name %>님</a></li>
<%					} %>
				</ul>
			</div>	
	</div>
	<div id="container_bottom">			
		<div id="b_menu_all">		
			<div id="b_menu_all_top">
				<div class="menu1"><a href=""><span class="maintitle">Accessories</span></a>
					<ul>
						<li>menu1 sub1</li>
						<li>menu1 sub2</li>
						<li>menu1 sub3</li>
						<li>menu1 sub4</li>
						<li>menu1 sub5</li>
					</ul>
				</div>
				<div class="menu1"><a href=""><span class="maintitle">Bikes & Frames</span></a>
					<ul>
						<li>menu2 sub1</li>
						<li>menu2 sub2</li>
						<li>menu2 sub3</li>
						<li>menu2 sub4</li>
						<li>menu2 sub5</li>
						<li>menu2 sub6</li>
						<li>menu2 sub7</li>
					</ul>
				</div>
				<div class="menu1"><a href=""><span class="maintitle">Clothing</span></a>
					<ul>
						<li>menu3 sub1</li>
						<li>menu3 sub2</li>
						<li>menu3 sub3</li>
						<li>menu3 sub4</li>
						<li>menu3 sub5</li>
						<li>menu3 sub6</li>
						<li>menu3 sub7</li>
						<li>menu3 sub8</li>
					</ul>
				</div>
				<div class="menu1"><a href=""><span class="maintitle">Maintenance</span></a>
					<ul>
						<li>menu4 sub1</li>
						<li>menu4 sub2</li>
						<li>menu4 sub3</li>
						<li>menu4 sub4</li>
						<li>menu4 sub5</li>
					</ul>
				</div>
				<div class="menu1"><a href=""><span class="maintitle">Parts</span></a>
					<ul>
						<li>menu5 sub1</li>
						<li>menu5 sub2</li>
						<li>menu5 sub3</li>
						<li>menu5 sub4</li>
						<li>menu5 sub5</li>
					</ul>
				</div>
				<div class="menu1"><a href=""><span class="maintitle">Tires & Tubes</span></a>
					<ul>
						<li>menu6 sub1</li>
						<li>menu6 sub2</li>
						<li>menu6 sub3</li>
						<li>menu6 sub4</li>
						<li>menu6 sub5</li>
					</ul>
				</div>
				<div class="menu1"><a href="/notice/notice_list.jsp"><span class="maintitle">Notice & News</span></a>
					<ul>
						<li><a href="/notice/notice_list.jsp">Notice</a></li>
						<li><a href="/news/news_list.jsp">News</a></li>
						<li><a href="/qanda/qanda_list.jsp">Q & A</a></li>
						<li><a href="/freeboard/freeboard_list.jsp">Free Board</a></li>
						<li><a href="">Etc</a></li>
					</ul>
				</div>
				
			</div>
			<div class="menu_close"><a href="#" class="closeclick">[CLOSE]</a></div>
		</div>	
		
		<div id="b_top">
			<div id="b_top_back">
<!--			
				<p class="b_top_text">aaaa</p>
				<p class="b_top_line"></p>
-->				
			</div>
			<ul class="main_menu">
				<li><a href="">Accessories</a></li>
				<li><a href="">Bikes & Frames</a></li>
				<li><a href="">Clothing</a></li>
				<li><a href="">Maintenance</a></li>
				<li><a href="">Parts</a></li>
				<li><a href="">Tires & Tubes</a></li>
				<li><a href="/notice/notice_list.jsp">Notice & News</a></li>
			</ul>
		</div>
		
		
		<div id="b_top_2">
			<ul class="b_top_menu">
				<li><a href=""><img src="images/bu_01.jpg" class="bu_1"></a></li>
				<li><a href=""><img src="images/bu_02.jpg" class="bu_1"></li>
				<li><a href=""><img src="images/bu_03.jpg" class="bu_1"></a></li>
				<li><a href=""><img src="images/bu_04.jpg" class="bu_1"></a></li>
				<li><a href=""><img src="images/bu_05.jpg" class="bu_1"></a></li>
				<li><a href=""><img src="images/bu_06.jpg" class="bu_1"></a></li>
			</ul>
		</div>		
		<hr><br>
		<div id="b_left">
			<p class="left_top">
				<img src="images/left_top.jpg"><a href="/notice/notice_list.jsp"><img src="images/left_right.jpg"></a>
			</p>
			<div class="left_middle">
				<ul>
					<li class="noti_title"><a href="">7.Convert between color formats</a></li>
					<li class="noti_date">20-07-14</li>
				</ul>
				<ul>
					<li class="noti_title"><a href="">6.회원운영정책 변경안내</a></li>
					<li class="noti_date">20-07-14</li>
				</ul>
				<ul>
					<li class="noti_title"><a href="">5.회원운영정책 변경안내</a></li>
					<li class="noti_date">20-07-14</li>
				</ul>
				<ul>
					<li class="noti_title"><a href="">4.회원운영정책 변경안내</a></li>
					<li class="noti_date">20-07-14</li>
				</ul>
				<ul>
					<li class="noti_title"><a href="">3.회원운영정책 변경안내</a></li>
					<li class="noti_date">20-07-14</li>
				</ul>
				<ul>
					<li class="noti_title"><a href="">2.회원운영정책 변경안내</a></li>
					<li class="noti_date">20-07-14</li>
				</ul>
				<ul>
					<li class="noti_title"><a href="">1.회원운영정책 변경안내</a></li>
					<li class="noti_date">20-07-14</li>
				</ul>
			</div>
		
		</div>
		<div id="b_center">
			<p class="b_center_top"><img src="images/center_top.jpg"></p>
			<p class="b_center_middle">
				<a href=""><img src="images/center_middle_1.jpg"><a href=""><img src="images/center_middle_2.jpg"><a href=""><img src="images/center_middle_3.jpg"></a>
			</p>
			<p class="b_center_bottom">
				<a href=""><img src="images/center_middle_4.jpg"><a href=""><img src="images/center_middle_5.jpg"><a href=""><img src="images/center_middle_6.jpg"></a>
			</p>
		</div>
		<div id="b_right">
			<img src="images/center_right.jpg">
		</div>
		<div id="b_bottom_2">
			<a href=""><img src="images/cello.png"></a>
		</div>		
		<div id="b_bottom">
			<div class="b_bottom_left">
				<img src="images/footer_logo_4.jpg">
			</div>
			<div class="b_bottom_center">
				<p>개인정보처리방침  | 개인정보보호정책 | 이용약관 | 협회소개</p>
				우편번호 (26349) 강원 원주시 호저면 우무개로 365 2층, 2호 | 사업자번호 : 209-82-64664<br>
				TEL: 033-747-4012 | FAX: 033-747-4014 | E-mail: korbamtb@daum.net<br>
				COPYRIGHT 2012 KOREA OFF ROAD BIKE ASSOCIATION. ALL RIGHT RESERVED		
			</div>
			<div class="b_bottom_right">
				서울사무소: (02) 4545- 8545<br>
				대전사무소: (042) 5417- 8842<br>
				광주사무소: (052) 4545- 2214<br>
				부산사무소: (048) 4545- 7546
			</div>
		</div>
	</div>
	


</div>	
</body>
</html>