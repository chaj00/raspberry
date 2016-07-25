package com.example.intent;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;

public class SubjectListActivity extends ListActivity implements OnItemClickListener{
	String[] data = {"자바","안드로이드","서블릿","JSP","JDBC","오라클"};
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    ArrayAdapter<CharSequence> adapter
	    = new ArrayAdapter<CharSequence>(this,
	    		android.R.layout.simple_list_item_1,data);
	    setListAdapter(adapter);
	    ListView list = getListView();
	    list.setOnItemClickListener(this);
	   
	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
		Intent intent = getIntent();
		intent.putExtra("redata", data[position]);
		setResult(RESULT_OK, intent);
		finish();
	}
}
