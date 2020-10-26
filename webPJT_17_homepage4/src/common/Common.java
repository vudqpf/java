package common;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Common {
	/*dao에서 공통으로 사용하는 것들을 모아 놓은 것들*/
	
	/*첨부파일 들어갈 경로*/
	//public static String file_dir_notice = "C:/Users/JSLHRD/Desktop/jsl_43기_한주연/eclipse_source/webPJT_17_homepage4/WebContent/file_room/notice/";
	  public static String file_dir_notice = "C:/Users/JSLHRD/Desktop/jsl_43기_한주연/eclipse_source/webPJT_17_homepage4/WebContent/file_room/notice/";
	
	  /*오늘 날짜 생성*/
	public static String getToday() { /*static은 new에서 생성하지 않고 클래스 이름을 바로 사용가능하도록*/
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();  /*오늘 날짜*/
		String today = sdf.format(date); /*오늘 날짜를 String으로 변환 시켜주는*/
		return today;
	}

}
