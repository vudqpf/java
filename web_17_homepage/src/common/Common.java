package common;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Common {
	public static String getToday() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();  /*오늘 날짜*/
		String today = sdf.format(date); /*오늘 날짜를 String으로 변환 시켜주는*/
		return today;
	}

}
