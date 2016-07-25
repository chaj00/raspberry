package view;

import java.util.ArrayList;
import java.util.HashMap;

import com.example.view.R;

import android.app.ListActivity;
import android.os.Bundle;
import android.widget.SimpleAdapter;
/*
 * �����͸� �ܼ� �迭�� �ѱ�� ����.(�ο������� ���ԵȰ��)
 * �׸� �ϳ��� �����Ͱ� �ϳ��� ���� ������ �ƴ϶� �׸�� �ο������� ���� ���ԵǴ� ��� ����� �� �ִ� �����
 */

/*
 * ���࿡ ���� �ۼ��� view�� ListActivity�� �����ؼ� ����ϴ� ��� �ݵ�� ListActivity�� ���� �ִ� 
 * ListView�� id�� ListView�� id�� �����ؾ� �Ѵ�.
 * ������ ��Ģ��� �����ؾ� ListActivity�� ���� �ۼ��� ���� ListView�� �⺻ ListView�� Ȱ���Ѵ�.
 */
public class SimpleAdapterActivity extends ListActivity {
	//�׸��� ���� ����
	ArrayList<HashMap<String,String>> itemlist =
			new ArrayList<HashMap<String,String>>();
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.listactivity); //���� �ۼ��� layout
		//������
		HashMap<String,String> item1 = new HashMap<String, String>();
		item1.put("name", "�輭��");
		item1.put("telNum", "01071118888");
		itemlist.add(item1);
		
		HashMap<String,String> item2 = new HashMap<String, String>();
		item2.put("name", "�嵿��");
		item2.put("telNum", "0107123456");
		itemlist.add(item2);
		
		SimpleAdapter adapter = new SimpleAdapter(this, //Context��ü
												itemlist, //HasMap�� ����ִ� List
												android.R.layout.simple_list_item_2, //row�� ���� ������
												new String[]{"name","telNum"}, //�ʰ�ü������key�� 
												new int[]{android.R.id.text1,  //�����͸� ������ row���ҽ��� ���ǵ� ������ ���� id��
															android.R.id.text2});
		setListAdapter(adapter);
		
		}

}
