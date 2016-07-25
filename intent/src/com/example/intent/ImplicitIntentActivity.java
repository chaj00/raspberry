package com.example.intent;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class ImplicitIntentActivity extends Activity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.implicit);
		
		Button btnrun =(Button)findViewById(R.id.test);
		btnrun.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				//웹브라우저
				//Intent intent = new Intent(Intent.ACTION_VIEW,Uri.parse("http://www.naver.com"));
				Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:1234567777"));
				startActivity(intent);
			}
		});
	}

	
}
