package view;

import java.util.ArrayList;
import java.util.HashMap;

import com.example.view.R;

import android.app.ListActivity;
import android.os.Bundle;
import android.widget.SimpleAdapter;
/*
 * 데이터를 단순 배열로 넘길수 없다.(부연설명이 포함된경우)
 * 항목 하나에 데이터가 하나만 들어가는 구조가 아니라 항목과 부연설명이 같이 포함되는 경우 사용할 수 있는 어댑터
 */

/*
 * 만약에 내가 작성한 view를 ListActivity와 연결해서 사용하는 경우 반드시 ListActivity가 갖고 있는 
 * ListView의 id로 ListView의 id를 정의해야 한다.
 * 정해진 규칙대로 정의해야 ListActivity가 내가 작성한 뷰의 ListView를 기본 ListView로 활용한다.
 */
public class SimpleAdapterActivity extends ListActivity {
	//항목을 담을 구조
	ArrayList<HashMap<String,String>> itemlist =
			new ArrayList<HashMap<String,String>>();
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.listactivity); //내가 작성한 layout
		//데이터
		HashMap<String,String> item1 = new HashMap<String, String>();
		item1.put("name", "김서연");
		item1.put("telNum", "01071118888");
		itemlist.add(item1);
		
		HashMap<String,String> item2 = new HashMap<String, String>();
		item2.put("name", "장동건");
		item2.put("telNum", "0107123456");
		itemlist.add(item2);
		
		SimpleAdapter adapter = new SimpleAdapter(this, //Context객체
												itemlist, //HasMap이 들어있는 List
												android.R.layout.simple_list_item_2, //row에 대한 디자인
												new String[]{"name","telNum"}, //맵객체에대한key값 
												new int[]{android.R.id.text1,  //데이터를 연결할 row리소스에 정의돈 위젯에 대한 id값
															android.R.id.text2});
		setListAdapter(adapter);
		
		}

}
