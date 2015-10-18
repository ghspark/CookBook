package com.gh.cookbook.adapter;

import com.gh.cookbook.R;
import com.gh.cookbook.bean.CookBook;
import com.gh.cookbook.bean.CookBookSteps;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class ImageAdapter extends BaseAdapter {
	private Context context;
	private CookBook cookBook;

	public ImageAdapter(Context context, CookBook cookBook) {
		super();
		this.context = context;
		this.cookBook = cookBook;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return cookBook.getSteps().size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return cookBook.getSteps().get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder viewHolder=null;
		if(convertView==null){
			viewHolder=new ViewHolder();
			convertView=LayoutInflater.from(context).inflate(R.layout.item_gl_view, parent,false);
			viewHolder.iv_gl=(ImageView) convertView.findViewById(R.id.iv_gl);
			viewHolder.tv_gl=(TextView) convertView.findViewById(R.id.tv_gl);
			convertView.setTag(viewHolder);
			
		}else{
			viewHolder=(ViewHolder) convertView.getTag();
		}
		
		ImageLoader imageLoader = ImageLoader.getInstance();
		imageLoader.init(ImageLoaderConfiguration.createDefault(context));
		for(CookBookSteps steps:cookBook.getSteps()){
			imageLoader.displayImage(steps.getImg(), viewHolder.iv_gl);
			viewHolder.tv_gl.setText(steps.getStep());
		}
		
		return convertView;
	}

	static class ViewHolder {
		ImageView iv_gl;
		TextView tv_gl;
	}

}
