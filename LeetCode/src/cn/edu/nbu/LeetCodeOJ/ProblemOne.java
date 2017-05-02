package cn.edu.nbu.LeetCodeOJ;

public class ProblemOne {

	public static void main(String[] args) {
		int[] array = {2,7,11,15};
		int sum = 9;
		int[] result = twoSum(array,sum);
		for(int i: result){
			System.out.println(i);
		}
	}
	
    public static int[] twoSum(int[] nums, int target) {
    	int[] result = new int[2];
		for(int i=0;i<nums.length;i++){
			for(int j=i+1;j<nums.length;j++){
				if( nums[i] + nums[j] == target){
					result[0] = i;
					result[1] = j;
				}
			}
		}
		return result;
	}
	
	public static int[] getIndices(int[] array,int sum){
		int[] result = new int[2];
		for(int i=0;i<array.length;i++){
			for(int j=i+1;j<array.length;j++){
				if( array[i] + array[j] == sum){
					result[0] = i;
					result[1] = j;
				}
			}
		}
		return result;
	}
}
