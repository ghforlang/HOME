package JustForTest;

import java.util.Vector;


public class TestClone {

	public static void main(String[] args) {
		Aclone a = new Aclone();
		TestClone tc = new TestClone();
		
		/*
			a.name = "aaaa";
			String s = "bbbb";
			int i = 2;
			tc.changeA(a);
			tc.changeInt(i);
			tc.changeString(s);
			System.out.println(a.name);
			System.out.println(i);
			System.out.println(s);
		*/
		
		//shadow clone或者叫影子克隆，
		/*
		  	Aclone aa = new Aclone();
			Aclone bb = new Aclone();
			aa.name = "aa";
			bb = (Aclone)aa.clone();
			bb.name = "bb";
			System.out.println(aa.name);
			System.out.println(bb.name);
		 */
		
		//当数据为数组或复杂数据类型时，就需要进行深度clone,将数组进行clone
		/*
			Aclone aa = new Aclone();
			Aclone bb = new Aclone();
			aa.ss[0] = "s";
			aa.ss[1] = "ss";
			bb = (Aclone)aa.clone();
			bb.ss[0] = "bb";
			bb.ss[1] = "bb";
			System.out.println(aa.ss[0] + " " + aa.ss[1]);
			System.out.println(bb.ss[0] + " " + bb.ss[1]);
		 */
		
		//彻底clone 暂时有问题
		/*
		Aclone aa = new Aclone();
		Aclone bb = new Aclone();
		aa.clB = new Vector<Bclone>();
		bb = aa;
		bb.clB = new Vector<Bclone>();
		System.out.println(aa.clB.hashCode());
		System.out.println(bb.clB.hashCode());
		*/
		Aclone aa = new Aclone();
		System.out.println(aa.clone() == aa);
		System.out.println(aa.clone().getClass() == aa.getClass());
		System.out.println(aa.clone().equals(aa));
		System.out.println(aa.clone().hashCode());
		System.out.println(aa.hashCode());
	}
	
	public void changeA(Aclone a){
		a.name = "a";
	}
	public void changeInt(int i){
		i *= 200 +1;
	}
	public void changeString(String a){
		a = "aaaaaaaa";
	}

}
class Aclone implements Cloneable{
	public String name;
	public String[] ss = new String[2];
	public Vector<Bclone> clB = new Vector<Bclone>();
	
	/*影子clone
	public Object clone(){
		Aclone o = null;
		try {
			o = (Aclone)super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return o;	
	}
	*/
	
	 //深度clone
	 /*
	 	public Object clone(){
		Aclone o = null;
		try {
			o = (Aclone)super.clone();
			o.ss = (String[])ss.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return o;
	}
	*/
	
	//彻底clone
	@SuppressWarnings("unchecked")
	public Object clone(){
		Aclone o = null;
		try {
			o = (Aclone)super.clone();
			o.ss = (String[])ss.clone();
			o.clB = (Vector<Bclone>)clB.clone();
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return o;
	}
}

class Bclone{
	
}