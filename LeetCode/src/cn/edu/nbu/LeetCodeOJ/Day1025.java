package cn.edu.nbu.LeetCodeOJ;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**@author lenovo
 * Given an array S of n integers, are there elements a, b, c in S such 
 * that a + b + c = 0? Find all unique triplets in the array which gives 
 * the sum of zero.
 * 1 Elements in a triplet (a,b,c) must be in non-descending order. (ie, a ≤ b ≤ c)
 * 2 The solution set must not contain duplicate triplets.
 *For example, given array S = {-1 0 1 2 -1 -4},after sorted S = {-1,-1,-4，0,1,2};
 *situation1: a+b = 0;
 *situation2: a+b = -c;
 *situation3: 0 0 0
 *A solution set is:
 * (-1, 0, 1)
 * (-1, -1, 2)
 */

public class Day1025 {

	public static void main(String[] args) {
		int a[] = {-1,0,-2,1,2,-1,-4};
		int c = 2;
		int d = 3;
		int e = 1;
		int max = c>d?(c>e?c:e):(e>d?e:d);
		Day1025 dd = new Day1025();
		System.out.println(max);
		dd.traverse(dd.threeSum(a));
	}
	
	public List<List<Integer>> threeSum(int[] num){
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		int zeronum = 0;
		for(int i=0;i<num.length;i++){//统计当前数组中0的个数
			if(num[i] == 0)
				++ zeronum;
		}
		System.out.println(zeronum);
		int end = num.length - 1;
		int start = 0;
		while(start < end){
			while(num[start]<0){
				start ++;
			}
		}
		//将数组中负数全部放在非负数前
//		for(int i=0;i<num.length;i++){
//			for(int j=0;j<num.length;j++){
//				for(int k=0;k<num.length;k++){
//					if((num[i] + num[j] + num[k] == 0)&&(i!=j &&j !=k && i!=k)){
//						List<Integer> l = new ArrayList<Integer>();
//						l.add(num[i]);
//						l.add(num[j]);
//						l.add(num[k]);
//						Collections.sort(l);
//						if(!list.contains(l))
//							list.add(l);
//					}
//						
//				}
//			}
//		}
		return list;
	}
	
	public void traverse(List<List<Integer>> list){
		for(int i=0;i<list.size();i++){
			for(int j=0;j<list.get(i).size();j++){
				System.out.print(list.get(i).get(j) + " ");
			}
			System.out.println();
		}
	}
}
