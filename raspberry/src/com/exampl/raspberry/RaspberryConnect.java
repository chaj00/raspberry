package com.exampl.raspberry;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

import android.util.Log;

//라즈베리파이에 접속- EditText에 입력한 내용을 전송
public class RaspberryConnect implements Runnable{
	String msg;
	Socket socket;
	//액티비티로 부터 메시지를 전달받는 메소드 - run안으로 넘겨준다.
	public void sendMsg(String msg){
		this.msg =msg;
	}
	@Override
	public void run() {
		try {
			socket = new Socket("192.168.9.204",5555);
			//소켓을 통해 데이터를 내보내기 위한 스트림
			PrintWriter out = new PrintWriter(
									new BufferedWriter(
										new OutputStreamWriter(
															socket.getOutputStream() )), true);
			//라즈베리파이로 EditText에 입력데이터 전송
			out.println("+++++++++++++++++++"+msg+ "+++++++++++++++++++");
			
			//소켓으로 부터 전달되어 들어오는 데이터를 읽기 위한 스트림
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
