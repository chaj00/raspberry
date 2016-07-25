
package com.example.intent;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
//보여질 첫번째 화면
public class FirstActivity extends Activity {
	Button bt;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first);
        bt = (Button)findViewById(R.id.bt);
        bt.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				//SecondActivity를 호출하기 위한 인텐트를 작성
				Intent intent = new Intent(FirstActivity.this,SecondActivity.class);
				intent.putExtra("data","첫번째 엑티비티에서 두번째 액티비티로 넘기는 데이더");
				startActivity(intent);
			}
		});
       
    }
}


















