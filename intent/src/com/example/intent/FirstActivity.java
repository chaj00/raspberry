
package com.example.intent;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
//������ ù��° ȭ��
public class FirstActivity extends Activity {
	Button bt;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first);
        bt = (Button)findViewById(R.id.bt);
        bt.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				//SecondActivity�� ȣ���ϱ� ���� ����Ʈ�� �ۼ�
				Intent intent = new Intent(FirstActivity.this,SecondActivity.class);
				intent.putExtra("data","ù��° ��Ƽ��Ƽ���� �ι�° ��Ƽ��Ƽ�� �ѱ�� ���̴�");
				startActivity(intent);
			}
		});
       
    }
}


















