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
		//xml에 정의되어 있는 모든 위젯이 객체로 생성되어 화면에 inflate된다.
		setContentView(R.layout.main2);
		//xml에 id로 등록된 객체를 find하는 메소드
		//무조건 setContentView가 호출된 후에 호출해야한다.
		bt = (Button)findViewById(R.id.btn1);
		bt.setOnClickListener(this);
		bt.setText(new Date().toString());
		
	}

	@Override
	public void onClick(View v) {
		bt.setText(new Date().toString());
		
	}

}
