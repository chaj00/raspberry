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
		//����Ʈ���� �ش� ��Ƽ��� ȣ���� ��Ƽ��Ƽ�� �Ѱ��� �����͸� ������.
		
		Intent intent = getIntent();
		String data = intent.getCharSequenceExtra("data").toString();
		Toast.makeText(this, data, Toast.LENGTH_LONG).show();
		
		bt.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				//��Ƽ��Ƽ ����
				finish();
			}
		});

	}

}