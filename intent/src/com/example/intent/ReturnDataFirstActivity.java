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
			//1.�ܼ��ϰ� �ٸ� ��Ƽ��Ƽ�� ȣ�� �ϱ⸸ �Ҷ� ���
			//startActivity(intent);
			
			//2. ȣ��Ǵ� ��Ƽ��Ƽ���� �����͸� ������ �ǵ��� �� �������� ���
			startActivityForResult(intent, 1);
			
		}else{
			finish();
		}
		
	}
	//��û�� ���� ��Ƽ��Ƽ (ReturnDataSecondActivity)�� finish()�ɶ� �ڵ����� ȣ��Ǵ� �޼ҵ�
	/*
	 * requestCode - ������ ��Ƽ��Ƽ�� ���� ���� �ڵ�(��Ƽ��Ƽ�� ���Ҷ� �Ѱ��� �� :1)
	 * resultCode - ������(ó�����)
	 * data(Intent) - �ݵ� ��Ƽ��Ƽ���� �۾��Ŀ� ������ ���� ���� �ִ� Intent��ü
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





























