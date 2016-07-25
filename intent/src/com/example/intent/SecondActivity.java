package com.example.intent;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class SecondActivity extends Activity {
	Button bt;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.second);
		bt = (Button) findViewById(R.id.bt2);
		//인텐트에서 해당 액티비디를 호출한 액티비티가 넘겨준 데이터를 꺼낸다.
		
		Intent intent = getIntent();
		String data = intent.getCharSequenceExtra("data").toString();
		Toast.makeText(this, data, Toast.LENGTH_LONG).show();
		
		bt.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				//액티비티 종료
				finish();
			}
		});

	}

}