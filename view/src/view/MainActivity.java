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
				//�͸��̳�Ŭ���� �ȿ��� �ܺ�Ŭ������ ������ ���� -final������ ���ٰ���
				if(isChecked){
					cb.setText("üũ�ڽ� ���õ�");
				}else{
					cb.setText("üũ�ڽ� ������");
				}
			}
		});
	}

}
