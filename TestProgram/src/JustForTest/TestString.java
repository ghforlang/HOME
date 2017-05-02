package JustForTest;

public class TestString {

	public static void main(String[] args) {
		String a = "yourself of your";
		String b = "your";
		int index = a.trim().indexOf(b);//只输出首个b出现的位置即0
		System.out.println(index);
	}
}
