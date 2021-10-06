package poly.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
	
	//날짜, 시간 출력하기
	public static String getDateTime(String fm) {
		Date today = new Date();
		System.out.println(today);
		SimpleDateFormat date = new SimpleDateFormat();
		
		return date.format(today);
	}
	//파라미터 없이 호출됐을때는 yyyy.MM.dd 형식
	public static String getDateTime() {
		return getDateTime("yyyy.MM.dd");
	}
}
