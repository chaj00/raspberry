package com.example.led;

import java.io.IOException;
import java.net.Socket;
//안드로이드 븅에서 connect버튼이 눌려지면 서버로 접속하고 접속한 정보를 이용해서 Thread객체를 생성
//서버의 ip로 접속하고 쓰레드가 동작
public class LedClientThread implements Runnable{
	private Socket socket;
	byte[] ledbuf = new byte[50];
	int ledBufSize=0;
	
	public LedClientThread(Socket socket) {
		super();
		this.socket = socket;
	}

	@Override
	public void run() {
		while(true){//flag변수를 정의하고 flag변수의 값이 만족하는 동안 실행되도록 제어
			try {
				ledBufSize = socket.getInputStream().read(ledbuf);
				String leddata = new String(ledbuf, 0, ledBufSize, "UTF-8");
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			
		}
	}

}
