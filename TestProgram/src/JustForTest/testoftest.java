package JustForTest;

import java.util.Date;

public class testoftest extends Date{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//for(int i=0;true;i++)
		//	System.out.println("o");
		//new testoftest().test();
		long starttime = 0;
		long endtime = 0;
		long starttime1 = 0;
		long endtime1 = 0;
	
		try {
			Class c = Class.forName("String");
			try {
				Object obj = c.newInstance();
				System.out.println(obj.getClass());
			} catch (InstantiationException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		String s = "";
		StringBuffer ss = new StringBuffer();
		starttime = System.currentTimeMillis();
		for(int i =1;i<10001;i++)
			s += i;
		endtime = System.currentTimeMillis();
		System.out.println(endtime - starttime);
		
		starttime1 = System.currentTimeMillis();
		for(int i=1;i<10001;i++)
			ss.append(i);
		endtime1 = System.currentTimeMillis();
		System.out.println(endtime1 - starttime1);
		//System.out.println(new String("abc").equals(new String("abc")));//true
		//System.out.println(new StringBuffer("abd").equals(new StringBuffer("abd")));//false,没有重写equals方法
	}
	public void test(){
		System.out.println(super.getClass().getName());
		System.out.println(this.getClass().getName());
		System.out.println(new testoftest().getClass().getName());
		System.out.println(new testoftest().getClass().getSuperclass().getName());
	}
}
