package com.homer.gallery;

import android.app.Activity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.Gallery;
import android.widget.Toast;

public class GalleryActivity extends Activity {
	
	private ImageAdapter imgAdapter = null;			// 声明图片资源对象
	private Gallery gallery = null;

	private EditText edtv;

	private String branch_function = "dev_1";
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		gallery = (Gallery) findViewById(R.id.gallery);
		imgAdapter = new ImageAdapter(this);
		gallery.setAdapter(imgAdapter); 					// 设置图片资源
		gallery.setGravity(Gravity.CENTER_HORIZONTAL);		// 设置水平居中显示
		gallery.setSelection(imgAdapter.imgs.length * 100);		// 设置起始图片显示位置（可以用来制作gallery循环显示效果）
		
		gallery.setOnItemClickListener(clickListener); 			// 设置点击图片的监听事件（需要用手点击才触发，滑动时不触发）
		gallery.setOnItemSelectedListener(selectedListener);		// 设置选中图片的监听事件（当图片滑到屏幕正中，则视为自动选中）
		gallery.setUnselectedAlpha(0.3f);					// 设置未选中图片的透明度
		gallery.setSpacing(40);							// 设置图片之间的间距

		/////////////////////////////////////
		edtv = (EditText) findViewById(R.id.edtv);
		edtv.setError("error",getResources().getDrawable(R.drawable.icon));
	}
	
	// 点击图片的监听事件
	AdapterView.OnItemClickListener clickListener = new AdapterView.OnItemClickListener() {
		@Override
		public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
			Toast.makeText(GalleryActivity.this, "点击图片 " + (position + 1), Toast.LENGTH_SHORT).show();
		}
	};
	
	// 选中图片的监听事件
	AdapterView.OnItemSelectedListener selectedListener = new AdapterView.OnItemSelectedListener() {
		@Override
		public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
			Toast.makeText(GalleryActivity.this, "选中图片 " + (position + 1), Toast.LENGTH_SHORT).show();
		}

		@Override
		public void onNothingSelected(AdapterView<?> arg0) {
			
		}
	};
}
