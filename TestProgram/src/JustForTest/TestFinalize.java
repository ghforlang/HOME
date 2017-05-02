package JustForTest;


public class TestFinalize{
	int index;
	static int count;
	TestFinalize() {
		count ++;
		System.out.println("object " + count + " construct");
		setId(count);
	}
	void setId(int id){
		index = id;
	}
	protected void finalize(){
		System.out.println("object " + index + " is reclaimed");
	}
	public static void main(String args[]){
		new TestFinalize();
		new TestFinalize();
		new TestFinalize();
		System.gc();//请求调用垃圾回收器，顺序与构造顺序相反
	}
}
