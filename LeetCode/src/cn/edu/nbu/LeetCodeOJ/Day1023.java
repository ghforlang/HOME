package cn.edu.nbu.LeetCodeOJ;
/**
 * @author lenovo
 * Suppose a sorted array is rotated at some pivot unknown to you beforehand.
 *(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 *Find the minimum element.
 *You may assume no duplicate exists in the array.
 */
public class Day1023 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//int a[] = new int[]{4,5,6,7,0,1,2,3};
		int a[] = {1};
		int b[] = {3,1,2};
		int c[] = {4,5,6,7,0,1,2};
		Day1023 d = new Day1023();
		int minElement = d.findMin1(b);
		System.out.println(minElement);
	} 
	//��������Ϊ���鳤��n
	public int findMin(int[] num){
		int min = num[0];
		for(int i=0;i<num.length;i++){
			if(min >= num[i])
				min = num[i];
		}
		return min;
	}
	//�����۰����˼�룬��߲���Ч��
	public int findMin1(int[] num){
		int low,high,m;
		low = 0;
		high = num.length - 1;
		while(low < high){
			m = (low + high)/2;
			if(num[m] > num[high]){//�м�ֵ�������Ҷ�ֵ���Ͷ�ָ������
				low = m + 1;
			}
			else{//�м�ֵС�����Ҷ�ֵ����ʱ����Сֵ�����Ǹ��м�ֵ���������м�ֵ����࣬��ô�߶�ָ�����ƣ���������m��
				high = m;
			}
		}
		return num[low];
	}
}
