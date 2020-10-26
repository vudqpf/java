package common;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Common {
	/*dao에서 공통으로 사용하는 것들을 모아 놓은 것들*/
	
	/*오늘 날짜 생성*/
	public static String getToday() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();  /*오늘 날짜*/
		String today = sdf.format(date); /*오늘 날짜를 String으로 변환 시켜주는*/
		return today;
	}

}
