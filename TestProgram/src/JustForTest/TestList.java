package JustForTest;

import java.util.ArrayList;
import java.util.List;

public class TestList {

	public static void main(String[] args) {
		
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		
		for(int i=0;i<6;i++){
			List<Integer> l = new ArrayList<Integer>(); 
			for(int j=0;j<=i;j++){
				l.add(j);
			}
			list.add(l);
		}
		
		for(int i=0;i<6;i++){
			for(int j=0;j<=i;j++){
				System.out.print(list.get(i).get(j) + " ");
			}
			System.out.println();
		}
		
	}
}
