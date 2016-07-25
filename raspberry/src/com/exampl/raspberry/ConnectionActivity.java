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
		//안드로이드에서 네트워크를 통해서 데이터를 받아오거나 하는 작업은 메인 쓰레드에서 하지 말아야 한다.
		//안드로이드의 핵심 어플리케이션 전화앱... 메인쓰레드에서 쓰레즈 작업을 하면 화면이 멈추는 현상이 발생하므로
		//전화를 받을 수 없는 상황이 올 수 있다. 따라서 안드로이드는 어플리케이션이 작동할떄 쓰레드나 가상머신에
		//대한 정책을 위반하지 않았는지 점검한다.
		if(android.os.Build.VERSION.SDK_INT>9){ //버전체크
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
