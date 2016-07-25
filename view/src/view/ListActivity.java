package view;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.view.R;


public class ListActivity extends Activity implements OnItemClickListener {
	
	TextView info;
	String[] singer ={"±Ëπ¸∑Ê", "radiohead","skidrow","≈‰¿Ã"};
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.list01);
	    info = (TextView)findViewById(R.id.txtinfo);
	    ListView list =(ListView)findViewById(R.id.listview01);
	    ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, singer);
	    list.setAdapter(adapter);
	    list.setOnItemClickListener(this);
	    
	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
		info.setText("position:"+position+","+singer[position]);
	}



}
