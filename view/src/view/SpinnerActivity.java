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
	 * �ȵ���̵忡���� �����͸� �پ��� ������ ����̳� ���ǳ� ���·� ǥ���� �� �ִ�.
	 * �����Ϳ� �� row�� ���� �����θ� Adapter���� �����ϸ� Adapter�� ó���Ͽ� ����ϸ��� ������ش�.
	 */
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.spinner);
	    Spinner spin = (Spinner) findViewById(R.id.singer);
	    //� �����͸� � row�� ���·� ǥ�������� ó���ϴ� ��ü�� Adapter�� ����
	    ArrayAdapter ad = 
	    		ArrayAdapter.createFromResource(this, R.array.singerlist, android.R.layout.simple_spinner_item);
	    //� ��ü�� ������ ������ ����
	    
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
