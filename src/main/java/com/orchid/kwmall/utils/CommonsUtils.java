package com.orchid.kwmall.utils;

import java.util.UUID;

public class CommonsUtils {

	//生成uuid方法 32位长度
	public static String getUUID(){
		
		return UUID.randomUUID().toString().replace("-", "");
	}
	
}
