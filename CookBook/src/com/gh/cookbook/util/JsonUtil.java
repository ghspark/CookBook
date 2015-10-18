package com.gh.cookbook.util;

import java.util.List;

import android.util.Log;

import com.gh.cookbook.bean.CookBook;
import com.gh.cookbook.bean.Result;
import com.google.gson.Gson;

public class JsonUtil {
	
	/**
	 * gaohang
	 * 
	 * 解析json格式的数据
	 */
	
	
	public static List<CookBook> parseJsonCookBook(String data){
		Gson gson=new Gson();
		Result result = gson.fromJson(data, Result.class);
		
		//Log.d("gaohang", "gh:"+result.getResult().getData().size());
		return result.getResult().getData();

	}

}
