package com.exampl.raspberry;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

import android.util.Log;

//��������̿� ����- EditText�� �Է��� ������ ����
public class RaspberryConnect implements Runnable{
	String msg;
	Socket socket;
	//��Ƽ��Ƽ�� ���� �޽����� ���޹޴� �޼ҵ� - run������ �Ѱ��ش�.
	public void sendMsg(String msg){
		this.msg =msg;
	}
	@Override
	public void run() {
		try {
			socket = new Socket("192.168.9.204",5555);
			//������ ���� �����͸� �������� ���� ��Ʈ��
			PrintWriter out = new PrintWriter(
									new BufferedWriter(
										new OutputStreamWriter(
															socket.getOutputStream() )), true);
			//��������̷� EditText�� �Էµ����� ����
			out.println("+++++++++++++++++++"+msg+ "+++++++++++++++++++");
			
			//�������� ���� ���޵Ǿ� ������ �����͸� �б� ���� ��Ʈ��
			BufferedReader in = new BufferedReader(
									new InputStreamReader(
										socket.getInputStream()));
			
			String data = in.readLine();
			Log.i("kim","+++++++++++++++++++return data:"+data+"+++++++++++++++++++");
			
			
		}  catch (Exception e) {
			e.printStackTrace();
			Log.e("kim", "+++++++++++++++++++++++fail+++++++++++++++++");
		}finally{
			try {
				if(socket!=null)socket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
	}
	

}
