package com.example.intent;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class ReturnDataSecondActivity extends Activity {
	
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.second2);
	    Button bt1 = (Button)findViewById(R.id.btnClose1);
	    bt1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				if(v.getId()==R.id.btnClose1){
					/*
					 * 발생한 데이터를 저장하고 호출해준 액티비티로 되돌아갈 경우
					 * 1. 호출할때 정보를 담고있는 액티비티 얻기
					 * 2. putExtra를 이용해서 데이터 저장
					 * 3. setResult를 이용해서 결과를 셋팅
					 */
					Intent intent = getIntent();
					intent.putExtra("redata", "returndata...");
					setResult(RESULT_OK, intent);
					
					finish();
				}
					
				
			}
		});
	}

}
