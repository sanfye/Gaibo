package com.gaibo.biz.share.vo;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

import org.junit.Test;

public class DateTest {
	
	@Test
	public void testDate(){
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String date = "Thu, 28 Sep 2017 09:13:58 GMT" ;
		simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT+8")); //GMT+0800
		
//		Date da = new Date(date);
		
		System.out.println("date:"+simpleDateFormat.format(new Date(date)));
		
		Calendar.getInstance(Locale.US);
		
		
		
	}

}
