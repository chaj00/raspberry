package view;


import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.TextView;

import com.example.view.R;

public class RadioButtonActivity extends Activity {
	private RadioGroup mRadioGroup = null;
	private TextView mMessage = null;
	private LinearLayout mLayout = null;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.radio);
		mRadioGroup = (RadioGroup) findViewById(R.id.radio_group);
		mLayout = (LinearLayout) findViewById(R.id.layout);
		mMessage = (TextView) findViewById(R.id.message);
		mRadioGroup.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			public void onCheckedChanged(RadioGroup group, int checkedId) {
				RadioButton bt = (RadioButton)findViewById(checkedId);
				if (checkedId == View.NO_ID) {
					mMessage.setText("선택된 아이템이 없습니다.");
				} else {
					mMessage.setText("선택된 라디오버튼의 아이디는 " + checkedId + "입니다."+bt.getText());
				}
			}
		});
		mLayout.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				mRadioGroup.clearCheck();
			}
		});
	}
}