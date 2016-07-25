package com.exampl.raspberry;


import android.app.Activity;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

import com.example.raspberry.R;

public class ConnectionActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//�ȵ���̵忡�� ��Ʈ��ũ�� ���ؼ� �����͸� �޾ƿ��ų� �ϴ� �۾��� ���� �����忡�� ���� ���ƾ� �Ѵ�.
		//�ȵ���̵��� �ٽ� ���ø����̼� ��ȭ��... ���ξ����忡�� ������ �۾��� �ϸ� ȭ���� ���ߴ� ������ �߻��ϹǷ�
		//��ȭ�� ���� �� ���� ��Ȳ�� �� �� �ִ�. ���� �ȵ���̵�� ���ø����̼��� �۵��ҋ� �����峪 ����ӽſ�
		//���� ��å�� �������� �ʾҴ��� �����Ѵ�.
		if(android.os.Build.VERSION.SDK_INT>9){ //����üũ
			StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
			StrictMode.setThreadPolicy(policy);
		}
		setContentView(R.layout.connect);
		final EditText msg = (EditText)findViewById(R.id.msg);
		Button btn = (Button)findViewById(R.id.btnok);
		
		btn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				String data = msg.getText().toString();
				RaspberryConnect connect = new RaspberryConnect();
				connect.sendMsg(data);
				new Thread(connect).start();
			}
		});
		
	}

}
