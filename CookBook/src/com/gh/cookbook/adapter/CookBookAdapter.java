package com.gh.cookbook.adapter;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.gh.cookbook.MainActivity;
import com.gh.cookbook.R;
import com.gh.cookbook.bean.CookBook;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

public class CookBookAdapter extends BaseAdapter {
	private Context context;
	private List<CookBook> list_cookBooks;
	private CookBook cookBook;
	private ImageAdapter imageAdapter;
	
	

	public CookBookAdapter(Context context) {
		super();
		this.context = context;
		list_cookBooks = new ArrayList<CookBook>();
		
	}
	
	public void addDatas(List<CookBook> list_cookbook){
		this.list_cookBooks=list_cookbook;
		
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return list_cookBooks.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return list_cookBooks.get(position);
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
			convertView=LayoutInflater.from(context).inflate(R.layout.item_cookbook, parent,false);
			viewHolder.iv_show=(ImageView) convertView.findViewById(R.id.iv_show);
			viewHolder.tv_title=(TextView) convertView.findViewById(R.id.tv_title);
			viewHolder.tv_imtro=(TextView) convertView.findViewById(R.id.tv_imtro);
			viewHolder.tv_tags=(TextView) convertView.findViewById(R.id.tv_tags);
			viewHolder.gl_show=(GridView) convertView.findViewById(R.id.gl_show);
			convertView.setTag(viewHolder);
			
		}else{
			viewHolder=(ViewHolder) convertView.getTag();
		}
		
		/**
		 * 开始显示数据以及加载图片
		 */
		cookBook=list_cookBooks.get(position);
		ImageLoader imageLoader = ImageLoader.getInstance();
		imageLoader.init(ImageLoaderConfiguration.createDefault(context));
		if(cookBook.getAlbums().get(0)!=null){
			imageLoader.displayImage(cookBook.getAlbums().get(0), viewHolder.iv_show);
		}
		
		viewHolder.tv_title.setText(cookBook.getTitle());
		viewHolder.tv_imtro.setText(cookBook.getImtro());
		viewHolder.tv_tags.setText(cookBook.getTags());
		
		imageAdapter=new ImageAdapter(context, cookBook);
		viewHolder.gl_show.setAdapter(imageAdapter);
		
		return convertView;
	}
	
	static class ViewHolder{
		ImageView iv_show;
		TextView tv_title;
		TextView tv_imtro;
		TextView tv_tags;
		GridView gl_show;
	}

}
