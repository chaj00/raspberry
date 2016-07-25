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
					 * �߻��� �����͸� �����ϰ� ȣ������ ��Ƽ��Ƽ�� �ǵ��ư� ���
					 * 1. ȣ���Ҷ� ������ ����ִ� ��Ƽ��Ƽ ���
					 * 2. putExtra�� �̿��ؼ� ������ ����
					 * 3. setResult�� �̿��ؼ� ����� ����
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
