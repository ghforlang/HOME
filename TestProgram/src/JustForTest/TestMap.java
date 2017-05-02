package JustForTest;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;


public class TestMap {

	public static void main(String[] args) {
		//HashMapʵ��Map�ӿ�
		Map<String, String> map = new HashMap<String,String>();
		map.put("a", "aaa");
		map.put("b", "bbb");
		map.put("c", "ccc");
		map.put("d", "ddd");
		
		Iterator<String> iterator = map.keySet().iterator();
		while(iterator.hasNext()){
			Object key = iterator.next();
			System.out.println("map.get(key)is:" + map.get(key));
		}
		
		//Hashtableʵ��Map�ӿ�
		Hashtable<String,String> tb = new Hashtable<String,String>();
		tb.put("a", "aaa");
		tb.put("b", "bbb");
		tb.put("c", "ccc");
		tb.put("d", "ddd");
		Iterator<String> iterator2 = tb.keySet().iterator();
		while(iterator2.hasNext()){
			Object key = iterator2.next();
			System.out.println("tb.get(key)is:" + tb.get(key));
		}
		
		//TreeMapʵ��SortMap�ӿڣ�SortMapʵ��Map�ӿ�
		TreeMap<String,String> tmp = new TreeMap<String,String>();//Ĭ���������У�
		tmp.put("a", "aaa");
		tmp.put("b", "bbb");
		tmp.put("c", "ccc");
		tmp.put("d", "ddd");
		Iterator<String> iterator3 = tmp.keySet().iterator();
		while(iterator3.hasNext()){
			Object key = iterator3.next();
			System.out.println("tmp.get(key)is:" + tmp.get(key));
		}
	}

}
