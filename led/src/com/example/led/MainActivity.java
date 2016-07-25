package com.example.led;

import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.Socket;

import android.app.Activity;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity implements OnClickListener {
	private EditText editTextIPAddress;
	private Button buttonConnect;
	private Button ledOff;
	private Button ledOn;

	private String server = "192.168.0.52"; // IP 주소
	private int port = 8089; // 포트 번호
	private Button buttonStop;
	private Socket socket;
	private OutputStream out;
	private Thread ledThread;
	private String serverIp;

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
		editTextIPAddress = (EditText) this
				.findViewById(R.id.editTextIPAddress);
		editTextIPAddress.setText(server);
		buttonConnect = (Button) this.findViewById(R.id.buttonConnect);
		ledOn = (Button) this.findViewById(R.id.ledOn);
		ledOff = (Button) this.findViewById(R.id.ledOff);
		buttonConnect.setOnClickListener(this);

		ledOn.setOnClickListener(this);
		ledOff.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		// 각각의 버튼을 누를떄 처리할 내용을 기술
		if (v == buttonConnect) {
			// 서버로 접속할 수 있는 쓰레드를 실행
			try {
				if (socket != null) {
					socket.close();
					socket = null;
				}
				serverIp = editTextIPAddress.getText().toString();
				socket = new Socket(serverIp,port);//라즈베리파이 사버와 접속
				
				//접속하자마자 서버의 데이터를 받을 수 있는 쓰레드 생성후 실행
				out= socket.getOutputStream();
				ledThread = new Thread(new LedClientThread(socket));
				ledThread.start();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} else if (v == ledOn || v == ledOff) {
			//ledon이나 ledoff를 누르면 서버로 특정 문자열을 전송
			String sendMsg = "";
			if(v==ledOn){
				sendMsg ="ledon";
				
			}else if(v==ledOff){
				sendMsg ="ledoff";
			}
			
			try {
				out.write(sendMsg.getBytes("UTF-8"));
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
	}

}
