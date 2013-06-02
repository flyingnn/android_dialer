package com.example.dialer;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {
	Button button;
	EditText mobile;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		button = (Button) findViewById(R.id.button);
		//button.setOnClickListener(new ButtonClickListener()); //使用自定义类
		button.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				mobile = (EditText) findViewById(R.id.mobile);
				Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:"
						+ mobile.getText()));
				startActivity(intent);

			}
		});

	}
	
	/**
	 * 使用自定义按钮点击类
	 * @author ling
	 *
	 */
	 private final class ButtonClickListener implements View.OnClickListener{
			public void onClick(View v) {
				String number = mobile.getText().toString();
				//Intent intent=new Intent(Intent.ACTION_CALL,Uri.parse("tel:"+number));
				Intent intent = new Intent();
				intent.setAction("android.intent.action.CALL");
				intent.setData(Uri.parse("tel:"+ number));
				
				startActivity(intent);//方法内部会自动为Intent添加类别：android.intent.category.DEFAULT
			}
	    }

}
