package cn.edu.nbu.LeetCodeOJ;


/**
 * 寻找最长的无重复字符子串长度
 * @author lenovo
 *
 */
public class ProblemThree {
	public static void main(String[] args){
		String[] test = {"abcabcbb","bbbbb","pwwkew","tmmzuxt"};
		for(String string : test){
			System.out.println(lengthOfLongestSubstring(string));
		}
	}
	
	public static int lengthOfLongestSubstring(String s) {
		int maxLen = 0;
		int[] isExist = new int[256];
		if(s == null || s.length() == 0){
			return maxLen;
		}else{
			int length = s.length();
			int i=0,j=0,temp = 0,tt = 0;
			while(j<length){
				temp = (int)s.charAt(j);
				if(isExist[temp] == 1){
					maxLen = maxLen > (j-i) ? maxLen : (j-i);
					tt = (int)s.charAt(i);
					while(tt!= temp){
						isExist[tt] =  0;
						i ++;
						tt = (int)s.charAt(i);
					}
					i ++;
					j ++;
				}else{
					isExist[temp] = 1;
					j ++;
				}
			}
			maxLen = maxLen > (length-i) ? maxLen : (length-i);
			return maxLen;
		}
	}
}


