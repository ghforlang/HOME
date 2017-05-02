package JustForTest;

import java.util.Enumeration;
import java.util.Hashtable;


public class TestCloneable {

	public static void main(String[] args) {
		((NULL)null).haha();//方法为static是可以运行的，否则抛出空指针异常
		//Hashtable<String,StringBuffer> ht = new Hashtable<String,StringBuffer>();
		Hashtable<String,String> ht = new Hashtable<String,String>();
		//StringBuffer sb = new StringBuffer();
		String sb = "";
		//sb.append("abc ");
		sb += "abc ";
		ht.put("1", sb);
		//sb.append("def ");
		sb += "def ";
		ht.put("2", sb);
		//sb.append("ghi ");
		sb += "ghi ";
		ht.put("3", sb);
		//sb.append("xyz");
		sb += "xyz";
		ht.put("4", sb);
		
		int numObj = 0;
		Enumeration<String> it = ht.elements();
		while(it.hasMoreElements()){
			System.out.println((++numObj) + " " +  it.nextElement().toString());
		}
	}
	/*String
	 1 abc def ghi xyz
	 2 abc def ghi 
	 3 abc def 
	 4 abc
	 */
	
	/*StringBuffer
	 1 abc def ghi xyz
	 2 abc def ghi xyz
	 3 abc def ghi xyz
	 4 abc def ghi xyz
	 */
}

class NULL{
	public static void haha(){
		System.out.println("haha");
	}
}
