package com.example.intent;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class ReturnDataFirstActivity extends Activity 
			implements OnClickListener{
    /** Called when the activity is first created. */
	Button bt1;
	Button bt2;
	TextView showdata;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first2);
        bt1 = (Button)findViewById(R.id.call);
        bt2 = (Button)findViewById(R.id.btnExit);
        showdata = (TextView) findViewById(R.id.showdata);
        
        bt1.setOnClickListener(this);
        bt2.setOnClickListener(this);
        Log.d("kim","onCreate()");
    }
    
	@Override
	public void onClick(View v) {
		if(v.getId()==R.id.call){
			Intent intent = new Intent(this, ReturnDataSecondActivity.class);
			//1.단순하게 다른 액티비티를 호춯 하기만 할때 사용
			//startActivity(intent);
			
			//2. 호출되는 액티비티에서 데이터를 가지고 되돌아 올 목적으로 사용
			startActivityForResult(intent, 1);
			
		}else{
			finish();
		}
		
	}
	//요청을 받은 맥티비티 (ReturnDataSecondActivity)가 finish()될때 자동으로 호출되는 메소드
	/*
	 * requestCode - 응답한 액티비티에 대한 구분 코드(액티비티를 콜할때 넘겨준 값 :1)
	 * resultCode - 응답결과(처리결과)
	 * data(Intent) - 콜된 액티비티에서 작업후에 저장한 값을 갖고 있는 Intent객체
	 */

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		if(requestCode==1){
			if(resultCode==RESULT_OK){
				showdata.setText(data.getStringExtra("redata"));
			}
				
		}
	}
	

	
	
}





























