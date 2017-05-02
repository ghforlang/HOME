package cn.edu.nbu.LeetCodeOJ;
/*
* Given s1, s2, s3, find whether s3 is formed by the interleaving of s1 and s2.
*For example,
*Given:
*s1 = "aabcc",
*s2 = "dbbca",
*When s3 = "aadbbcbcac", return true.
*When s3 = "aadbbbaccc", return false.
 */
public class Day1108 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s1 = "aabcc";
		String s2 = "dbbca";
		String s3 = "aadbbcbcac";
		String s4 = "aadbbbaccc";
		System.out.println(s3.substring(0, 1));
	}
	
	public boolean isInterleave(String s1,String s2,String s3){
		//StringBuffer sb = new StringBuffer(s3);
		for(int i=0;i<s3.length();i++){
			int step = 1;
			String subString = null;
			if(i+step <s3.length())
				subString = s3.substring(i, i+step);//
			
			
		}
		return false;
	}
}
