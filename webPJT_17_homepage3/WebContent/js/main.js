
/*주메뉴*/
var $devWidth;
var $limitSize=768;
$(document).ready(function() {
/* 디바이스 사이즈 체크 */
$devWidth=$("body").width();
$(window).resize(function(){
	$devWidth=$("body").width();
})

	$(".gnblist > li > a").bind("mouseover focus",function() {
		  if($devWidth <$limitSize) return false;
			$(".gnblist ul").hide();
			$(this).next().show();

			$(".gnblist > li > a").css({
				'height':'29px',
				'background':'none'
			});

			$(this).css('height','32px');
			$(this).css('background','url("images/over_icon.gif") no-repeat center bottom');
	});

	$("#gnb").mouseleave(function(){
			if($devWidth <$limitSize) return false;
			$(".gnblist ul").stop().slideUp(50);
			$(".gnblist > li > a").css({
				'height':'29px',
				'background':'none'
			});
	})

	/*전체메뉴*/
	$(".allmenu_view a").click(function(e){
		e.preventDefault();
		$(".allmenu_view").slideUp(10,function(){
			$("#allMenu_box").slideDown("slow");
		})
	});

	$(".all_close").click(function(e){
		e.preventDefault();
		$("#allMenu_box").slideUp("slow",function(){
			$(".allmenu_view").slideDown(50);
		})
	});

	
	/*탭메뉴*/
	$(".t1 a, .t2 a").bind("focus click",function(e) {
		e.preventDefault();
		$(".item1, .item2").hide();
		$(this).parent().next().show();

		$("#newbooks-news h2 img").each(function(){
			$(this).attr("src",$(this).attr("src").replace("_over.gif",".gif"));
		});
		$btnImg=$(this).children("img");
		$btnImg.attr("src",$btnImg.attr("src").replace(".gif","_over.gif"));
	})

	

/*click&touch 슬라이드 배너*/
	var $bnnNum=0;
	
	$(".prev").click(function(){
		if($bnnNum<=0) return false;
		$bnnNum--;
			$book_w=$("#recomm_book").width();
			$("#book_frame").animate({left:-$book_w*$bnnNum},300,function(){
					$("#book_roll img").attr("src","images/state_out.png");
					$("#book_roll img").eq($bnnNum).attr("src","images/state_over.png");	
			});
	})
	$(".next").click(function(){
		if($bnnNum>=1) return false;
		$bnnNum++;
			$book_w=$("#recomm_book").width();
			$("#book_frame").animate({left:-$book_w},300,function(){
				$("#book_roll img").attr("src","images/state_out.png");
				$("#book_roll img").eq($bnnNum).attr("src","images/state_over.png");	
			});
	})

	$("#recomm_book").bind("swipeleft",function(){$(".next").trigger("click");});
	$("#recomm_book").bind("swiperight",function(){$(".prev").trigger("click");});

	$(window).bind("orientationchange",function(e){
			$book_w =$("#recomm_book").width();
			$("#book_frame").animate({left:-$book_w*$bnnNum},300);
	});
});
