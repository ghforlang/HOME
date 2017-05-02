package JustForTest;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;


public class TestMap {

	public static void main(String[] args) {
		//HashMap实现Map接口
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
		
		//Hashtable实现Map接口
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
		
		//TreeMap实现SortMap接口，SortMap实现Map接口
		TreeMap<String,String> tmp = new TreeMap<String,String>();//默认升序排列；
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
