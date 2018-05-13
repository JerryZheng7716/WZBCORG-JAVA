package com.yhs.helper;

public class StringHelper {
	
	public static boolean isEmpty(String str){
		if(str == null || "".equals(str)){
			return true;
		}
		return false;
	}
}
