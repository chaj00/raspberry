package view;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.example.view.R;


public class SpinnerActivity extends Activity {
	
	/*
	 * 안드로이드에서는 데이터를 다양한 유형의 목록이나 스피너 형태로 표현할 수 있다.
	 * 데이터와 한 row에 대한 디자인만 Adapter에게 전달하면 Adapter가 처리하여 목록하면을 만들어준다.
	 */
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.spinner);
	    Spinner spin = (Spinner) findViewById(R.id.singer);
	    //어떤 데이터를 어떤 row의 형태로 표현할지를 처리하는 객체인 Adapter를 생성
	    ArrayAdapter ad = 
	    		ArrayAdapter.createFromResource(this, R.array.singerlist, android.R.layout.simple_spinner_item);
	    //어떤 객체에 연결할 것인지 지정
	    
	    ad.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
	    spin.setAdapter(ad);
	    spin.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int arg2, long arg3) {
				
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub
				
			}
		});
	    
	}

}
