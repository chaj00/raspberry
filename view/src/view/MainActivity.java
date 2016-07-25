package view;

import android.app.Activity;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;

import com.example.view.R;

public class MainActivity extends Activity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		final CheckBox cb = (CheckBox)findViewById(R.id.check);
		cb.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			
			@Override
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
				//익명이너클래스 안에서 외부클래스의 변수에 접근 -final변수만 접근가능
				if(isChecked){
					cb.setText("체크박스 선택됨");
				}else{
					cb.setText("체크박스 해제됨");
				}
			}
		});
	}

}
