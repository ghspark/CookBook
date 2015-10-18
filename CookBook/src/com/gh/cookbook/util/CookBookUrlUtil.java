package com.gh.cookbook.util;

import android.util.Log;

public class CookBookUrlUtil {
	
	/**
	 * 获取完整的路径访问地址
	 */
	
	public static String getAbsolueUrl(String baseUrl,String menu,String key){
		Log.d("gaohang", baseUrl+"?"+"key="+key+"&"+"menu="+menu);
		
		return baseUrl+"?"+"key="+key+"&"+"menu="+menu;
	}

}
