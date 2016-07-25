package com.example.intent;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class IntentActivity extends Activity {
    /** Called when the activity is first created. */
	
	TextView showdata;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first3);
        Button btn = (Button)findViewById(R.id.subjectbtn);
        showdata = (TextView)findViewById(R.id.result);
        btn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				if(v.getId()==R.id.subjectbtn){
					Intent intent = new Intent(IntentActivity.this, SubjectListActivity.class);
					startActivityForResult(intent,1);
					
				}
				
				
			}
		});
    }
    
    
    @Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		if(requestCode==1){
			if(resultCode==RESULT_OK){
				showdata.setText(data.getStringExtra("redata"));
			}
				
		}
	}
 }




