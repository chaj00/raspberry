package com.example.led;

import java.io.IOException;
import java.net.Socket;
//�ȵ���̵� �鿡�� connect��ư�� �������� ������ �����ϰ� ������ ������ �̿��ؼ� Thread��ü�� ����
//������ ip�� �����ϰ� �����尡 ����
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
		while(true){//flag������ �����ϰ� flag������ ���� �����ϴ� ���� ����ǵ��� ����
			try {
				ledBufSize = socket.getInputStream().read(ledbuf);
				String leddata = new String(ledbuf, 0, ledBufSize, "UTF-8");
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			
		}
	}

}
