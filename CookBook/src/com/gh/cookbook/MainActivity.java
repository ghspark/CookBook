package com.gh.cookbook;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.android.volley.AuthFailureError;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.gh.cookbook.adapter.CookBookAdapter;
import com.gh.cookbook.bean.CookBook;
import com.gh.cookbook.util.AppController;
import com.gh.cookbook.util.CookBookUrlUtil;
import com.gh.cookbook.util.JsonUtil;


import android.R.anim;
import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends Activity implements OnItemClickListener {
	//private PullToRefreshListView ptrf_show;
	private static final String URL_COOKBOOK="http://apis.juhe.cn/cook/query";
	private static final String KEY="a99a1c3307c1d1d3848e239abadeece9";
	private CookBookAdapter mAdapter;
	private List<CookBook> list_cook;
	private ListView ptrf_show;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		initView();
		initData();
	}
	
	public void initView(){
		//ptrf_show=(PullToRefreshListView) findViewById(R.id.ptrf_show);
		//ptrf_show.setMode(Mode.BOTH);
		ptrf_show=(ListView) findViewById(R.id.ptrf_show);
		mAdapter=new CookBookAdapter(MainActivity.this);
		ptrf_show.setAdapter(mAdapter);
		
//		ptrf_show.setOnRefreshListener(new OnRefreshListener<ListView>() {
//
//			@Override
//			public void onRefresh(PullToRefreshBase<ListView> refreshView) {
//                  initData();				
//			}
//		});
	}
	
	public void initData(){
		
		StringRequest stringRequest=new StringRequest(CookBookUrlUtil.getAbsolueUrl(URL_COOKBOOK,"%E8%A5%BF%E7%BA%A2%E6%9F%BF",KEY), new Listener<String>() {

			@Override
			public void onResponse(String jsonData) {
				//Log.d("gaohang", jsonData);
				List<CookBook> list_cook = JsonUtil.parseJsonCookBook(jsonData);
				mAdapter.addDatas(list_cook);
				mAdapter.notifyDataSetChanged();
			}
		}, new ErrorListener() {

			@Override
			public void onErrorResponse(VolleyError arg0) {
				Toast.makeText(MainActivity.this, "下载数据出错", Toast.LENGTH_SHORT).show();
				
			}
		});
		
		AppController.getInstance().addToRequestQueue(stringRequest);
		//mAdapter=new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,new String []{"gaohang","android","spark"});
		//ptrf_show.setAdapter(mAdapter);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position,
			long id) {
		// TODO Auto-generated method stub
		
	}
}
