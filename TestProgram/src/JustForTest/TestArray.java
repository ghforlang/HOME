package JustForTest;
//数组的三种初始化方式
public class TestArray
{
	public static void main(String[] args)
	{
		int[] arr1;
		arr1 = new int[3];
		arr1[0] = 0;
		arr1[1] = 1;
		arr1[2] = 2;
		showArr(arr1);
		System.out.println("***************************************");
		
		int[] arr2 = new int[]{0,1,2};
		showArr(arr2);
		System.out.println("***************************************");
		
		int[] arr3 = {0,1,2};
		showArr(arr3);
		System.out.println("***************************************");
	}
	public static void showArr(int[] arr)
	{
		for( int i = 0; i < arr.length; ++i)
		{
			System.out.println(arr[i]);
		}
	}
}