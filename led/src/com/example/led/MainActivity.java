package com.example.led;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

import android.app.Activity;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity  implements OnClickListener{
	private EditText editTextIPAddress;
	private Button buttonConnect;
	private Button ledOff;
	private Button ledOn;
	
	private String server = "192.168.0.52"; //IP �ּ�
	private int port = 8089; //��Ʈ ��ȣ
	private Button buttonStop;
	private Socket socket;
	private OutputStream out;
	private Thread ledThread;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		if (android.os.Build.VERSION.SDK_INT > 9) {
			StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder()
					.permitAll().build();
			StrictMode.setThreadPolicy(policy);
		}

		setContentView(R.layout.activity_main);
		editTextIPAddress = (EditText)this.findViewById(R.id.editTextIPAddress);
		editTextIPAddress.setText(server);
		buttonConnect   = (Button)this.findViewById(R.id.buttonConnect);
		ledOn = (Button)this.findViewById(R.id.ledOn);
		ledOff  = (Button)this.findViewById(R.id.ledOff);
		buttonConnect.setOnClickListener(this);
		
		ledOn.setOnClickListener(this);
		ledOff.setOnClickListener(this);
	}
	@Override
	public void onClick(View v) {
		//������ ��ư�� ������ ó���� ������ ���
		if(v == buttonConnect){
			//������ ������ �� �ִ� �����带 ����
			
		}else if( v==ledOn || v==ledOff){
			
		}
	}
	
}
