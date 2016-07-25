package com.example.intent;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class ReturnDataFirstActivity extends Activity 
			implements OnClickListener{
    /** Called when the activity is first created. */
	Button bt1;
	Button bt2;
	TextView showdata;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first2);
        bt1 = (Button)findViewById(R.id.call);
        bt2 = (Button)findViewById(R.id.btnExit);
        showdata = (TextView) findViewById(R.id.showdata);
        
        bt1.setOnClickListener(this);
        bt2.setOnClickListener(this);
        Log.d("kim","onCreate()");
    }
    
	@Override
	public void onClick(View v) {
		if(v.getId()==R.id.call){
			Intent intent = new Intent(this, ReturnDataSecondActivity.class);
			//1.´Ü¼øÇÏ°Ô ´Ù¸¥ ¾×Æ¼ºñÆ¼¸¦ È£­Œ ÇÏ±â¸¸ ÇÒ¶§ »ç¿ë
			//startActivity(intent);
			
			//2. È£ÃâµÇ´Â ¾×Æ¼ºñÆ¼¿¡¼­ µ¥ÀÌÅÍ¸¦ °¡Áö°í µÇµ¹¾Æ ¿Ã ¸ñÀûÀ¸·Î »ç¿ë
			startActivityForResult(intent, 1);
			
		}else{
			finish();
		}
		
	}
	//¿äÃ»À» ¹ŞÀº ¸ÆÆ¼ºñÆ¼ (ReturnDataSecondActivity)°¡ finish()µÉ¶§ ÀÚµ¿À¸·Î È£ÃâµÇ´Â ¸Ş¼Òµå
	/*
	 * requestCode - ÀÀ´äÇÑ ¾×Æ¼ºñÆ¼¿¡ ´ëÇÑ ±¸ºĞ ÄÚµå(¾×Æ¼ºñÆ¼¸¦ ÄİÇÒ¶§ ³Ñ°ÜÁØ °ª :1)
	 * resultCode - ÀÀ´ä°á°ú(Ã³¸®°á°ú)
	 * data(Intent) - ÄİµÈ ¾×Æ¼ºñÆ¼¿¡¼­ ÀÛ¾÷ÈÄ¿¡ ÀúÀåÇÑ °ªÀ» °®°í ÀÖ´Â Intent°´Ã¼
	 */

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





























