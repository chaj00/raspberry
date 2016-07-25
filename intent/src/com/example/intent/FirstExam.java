package com.example.intent;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class FirstExam extends Activity {
	Button btn;
	EditText idview;
	EditText passview;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	setContentView(R.layout.firstexam);
	btn = (Button) findViewById(R.id.Button01);
	idview = (EditText) findViewById(R.id.EditText01);
	passview = (EditText) findViewById(R.id.EditText02);
	btn.setOnClickListener(new OnClickListener() {
	
		@Override
		public void onClick(View v) {
			if(v.getId()==R.id.Button01){
				Intent intent = new Intent(FirstExam.this, SecondExam.class);
				intent.putExtra("id", idview.getText());
				intent.putExtra("pass", passview.getText());
				startActivityForResult(intent, 1);
			}
		}
	});
	    
	}
	
	  @Override
		protected void onActivityResult(int requestCode, int resultCode, Intent data) {
			super.onActivityResult(requestCode, resultCode, data);
			TextView showdata = (TextView)findViewById(R.id.loginresult);
			if(requestCode==1){
				if(resultCode==RESULT_OK){
					showdata.setText("로그인 성공");
					Toast.makeText(this, "로그인 성공", Toast.LENGTH_LONG).show();
				}else if (resultCode==RESULT_CANCELED){
					showdata.setText("로그인 실패");
					Toast.makeText(this, "로그인 실패", Toast.LENGTH_LONG).show();
				}
					
			}
		}

}
