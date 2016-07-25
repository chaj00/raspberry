package com.example.intent;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class SecondExam extends Activity {

	Button btn;
	TextView info;
	@Override
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.second);
	    btn = (Button)findViewById(R.id.bt2);
	    info = (TextView)findViewById(R.id.info);
	 
	    Intent intent = getIntent();
		String id = intent.getCharSequenceExtra("id").toString();
		String pass = intent.getCharSequenceExtra("pass").toString();
		info.setText("아이디:"+id+", "+"패스워드:"+pass);

		btn.setOnClickListener(new OnClickListener() {
	 		@Override
	 		public void onClick(View v) {
	 			Intent intent = getIntent();
	 			intent.putExtra("redata","로그인 결과");
	 			if(intent.getCharSequenceExtra("id").toString().equals("java")){
	 				setResult(RESULT_OK, intent);
	 			}else{
	 				setResult(RESULT_CANCELED, intent);
	 			}
	 			
	 			finish();
	 			
	 		}
	 	});
	}

}
