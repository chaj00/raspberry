package view;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.view.R;


public class CustRowTestActivity extends Activity implements OnItemClickListener {
	
	String[] singer ={"±Ëπ¸∑Ê", "radiohead","skidrow","≈‰¿Ã"};
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.listview);
	    ListView list =(ListView)findViewById(R.id.listview);
	    ArrayAdapter adapter = new ArrayAdapter(this, R.layout.custrow, R.id.rowtext,singer);
	    list.setAdapter(adapter);
	    
	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
	}



}
