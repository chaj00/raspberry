package com.example.firstpro;

import java.util.Date;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class ListenerTest02 extends Activity implements OnClickListener {
	Button bt;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//xml�� ���ǵǾ� �ִ� ��� ������ ��ü�� �����Ǿ� ȭ�鿡 inflate�ȴ�.
		setContentView(R.layout.main2);
		//xml�� id�� ��ϵ� ��ü�� find�ϴ� �޼ҵ�
		//������ setContentView�� ȣ��� �Ŀ� ȣ���ؾ��Ѵ�.
		bt = (Button)findViewById(R.id.btn1);
		bt.setOnClickListener(this);
		bt.setText(new Date().toString());
		
	}

	@Override
	public void onClick(View v) {
		bt.setText(new Date().toString());
		
	}

}
