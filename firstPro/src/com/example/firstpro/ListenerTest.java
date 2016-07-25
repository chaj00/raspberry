package com.example.firstpro;

import java.util.Date;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class ListenerTest extends Activity implements OnClickListener {
	Button bt;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		bt = new Button(this);
		bt.setOnClickListener(this);
		bt.setText(new Date().toString());
		setContentView(bt);
	}

	@Override
	public void onClick(View v) {
		bt.setText(new Date().toString());
		
	}

}
