package JustForTest;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Random;


public class TestHashMap {

	public static void main(String[] args) {
		HashMap h1 = new HashMap();
		Random r = new Random();
		for(int i=0;i<1000;i++){
			Integer t = new Integer(r.nextInt(20));
			if(h1.containsKey(t)){
				((Ctime)h1.get(t)).count++;
			}
			else {
				h1.put(t,new Ctime());
			}
		}
		
		Iterator<Integer> iterator = h1.keySet().iterator();
		while(iterator.hasNext()){
			Object key = iterator.next();
			System.out.println(h1.get(key));
		}
	}
	
}
class Ctime{
	int count = 1;
	public String toString(){
		return Integer.toString(count);
	}
}