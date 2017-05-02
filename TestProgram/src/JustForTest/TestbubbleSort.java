package JustForTest;

public class TestbubbleSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[] = {9,8,7,6,5,4,3,2,1};
		for(int i=0;i<a.length;i++)
			System.out.println(bubbleSort(a)[i]);
	}
	public static int[] bubbleSort(int[] a){
		int temp = 0;
		for(int i=0;i<a.length-1;i++){
			for(int j=i+1;j<a.length;j++){
				if(a[i] > a[j]){
					temp = a[i];
					a[i] = a[j];
					a[j] = temp;
				}
			}
		}
		return a;
	}
}
