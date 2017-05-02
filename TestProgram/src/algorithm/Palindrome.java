package algorithm;
import java.util.Stack;

import myutil.MyList;
public class Palindrome {
	public static void main(String[] args) {
		MyList list = MyList.createList();
		MyList.traverseList(list);
		System.out.println(isPalindrome1(list));
	}
	public static boolean isPalindrome1(MyList list){
		Stack<MyList> stack = new Stack<MyList>();//ջ
		MyList p = list.next;
		MyList q = list.next;
		String top = "";
		while(q != null && q.next !=null){
			stack.push(p);
			p = p.next;
			q = q.next.next;
		}
		if(q != null)
			p = p.next;
		while(p != null){
			top = stack.pop().data;
			if(!p.data.equals(top)){
				return false;
			}
			else{
				System.out.println(top);
				p = p.next;
			}
		}
		return true;
	}
}
