package com.yhs.helper;

import java.text.SimpleDateFormat;
import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;

import java.util.Calendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DateHelper {
	/**
	 * 验证时间字符串格式输入是否正确
	 * @param timeStr
	 * @return
	 */
	public static boolean valiDateTimeWithLongFormat(String timeStr) {
		String format = "((19|20)[0-9]{2})-(0?[1-9]|1[012])-(0?[1-9]|[12][0-9]|3[01])";
		Pattern pattern = Pattern.compile(format);
		Matcher matcher = pattern.matcher(timeStr);
		if (matcher.matches()) {
			pattern = Pattern.compile("(\\d{4})-(\\d+)-(\\d+)");
			matcher = pattern.matcher(timeStr);
			if (matcher.matches()) {
				int y = Integer.valueOf(matcher.group(1));
				int m = Integer.valueOf(matcher.group(2));
				int d = Integer.valueOf(matcher.group(3));
				if (d > 28) {
					Calendar c = Calendar.getInstance();
					c.set(y, m-1, 1);
					int lastDay = c.getActualMaximum(Calendar.DAY_OF_MONTH);
					return (lastDay >= d);
				}
			}
			return true;
		}
		return false;
	}
	
    public static java.sql.Date strToDate(String strDate) {  
        String str = strDate;  
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");  
        java.util.Date d = null;  
        try {  
            d = format.parse(str);  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
        java.sql.Date date = new java.sql.Date(d.getTime());  
        return date;  
    }
	
	
//	public static void main(String[] args){
//		System.out.println(DateHelper.valiDateTimeWithLongFormat("2016-5-2"));//		true
//		System.out.println(DateHelper.valiDateTimeWithLongFormat("2016-02-29"));//		true
//		System.out.println(DateHelper.valiDateTimeWithLongFormat("2015-02-29"));//		false
//		System.out.println(DateHelper.valiDateTimeWithLongFormat("2016-02-02"));//		false
//	}
}
