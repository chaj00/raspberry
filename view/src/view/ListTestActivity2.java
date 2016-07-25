package view;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;



public class ListTestActivity2 extends ListActivity implements OnItemClickListener {
	
	TextView info;
	String[] singer ={"�����", "radiohead","skidrow","����"};
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_multiple_choice, singer);
	    setListAdapter(adapter);
	    
	    //ListView�� choiceMode�� ���ð������� �������־�� �Ѵ�.
	    ListView list = getListView();
	    list.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
	}



}
