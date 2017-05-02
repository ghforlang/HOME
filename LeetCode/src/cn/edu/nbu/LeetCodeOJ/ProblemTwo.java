package cn.edu.nbu.LeetCodeOJ;

public class ProblemTwo {
	
	public static void main(String[] args){
		int[] arr1 = {2};
		int[] arr2 = {8};
		ListNode listNode1 = getListNode(arr1);
		ListNode listNode2 = getListNode(arr2);
		ListNode listNode = addTwoNumbers(listNode1, listNode2);
//		ListNode listNode = addTwoNumbers2(listNode1, listNode2);
//		ListNode listNode = addTwoNumbersEx(listNode1, listNode2);
		if(listNode != null){
			while(listNode != null){
				System.out.print(listNode.val);
				listNode = listNode.next;
			}
		}
	}
	
	/**
	 * 参考答案,单链表尾插法，
	 */
	public static ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
	    ListNode dummyHead = new ListNode(0);
	    ListNode p = l1, q = l2, curr = dummyHead;
	    int carry = 0;
	    while (p != null || q != null) {
	        int x = (p != null) ? p.val : 0;
	        int y = (q != null) ? q.val : 0;
	        int sum = carry + x + y;
	        carry = sum / 10;
	        curr.next = new ListNode(sum % 10);
	        curr = curr.next;
	        if (p != null) p = p.next;
	        if (q != null) q = q.next;
	    }
	    if (carry > 0) {
	        curr.next = new ListNode(carry);
	    }
	    return dummyHead.next;
	}
	
	 public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		 ListNode listNode = null;
	    if(l1 != null && l2 != null){
	    	listNode = new ListNode(0);
	    	ListNode ll = listNode;
	    	ListNode nextNode = listNode;
	    	while(l1 != null && l2 != null){
	    		ll.val = l1.val + l2.val + ll.val;
	    		if(ll.val >= 10){
	    			nextNode = new ListNode(1);
	    			ll.next = nextNode;
	    			ll.val -= 10;
	    		}else{
	    			if(l1.next != null || l2.next != null){
	    				nextNode = new ListNode(0);
	    				ll.next = nextNode;
	    			}
	    		}
	    		l1 = l1.next;
	    		l2 = l2.next;
	    		ll = ll.next;
	    	}
	    	while(l1 != null){
	    		ll.val += l1.val;
	    		if(ll.val >= 10){
	    			ll.val -= 10;
	    			ll.next = new ListNode(1);
	    		}else{
	    			if(l1.next != null){
	    				ll.next = new ListNode(0);
	    			}
	    		}
	    		l1 = l1.next;
	    		ll = ll.next;
	    	}
	    	while(l2 != null){
	    		ll.val += l2.val;
	    		if(ll.val >= 10){
	    			ll.val -= 10;
	    			ll.next = new ListNode(1);
	    		}else{
	    			if(l2.next != null){
	    				ll.next = new ListNode(0);
	    			}
	    		}
	    		l2 = l2.next;
	    		ll = ll.next;
	    	}
	    }
	    return listNode;
	 }
	 
	 /**
	  * 单链表，头插法，注意不要断链
	  * @param l1
	  * @param l2
	  * @return
	  */
	 public static ListNode addTwoNumbersEx(ListNode l1, ListNode l2) {
		 ListNode head = new ListNode(0);
		 ListNode p = l1,q = l2,cur = head.next;
		 int carry = 0,x = 0,y = 0,sum = 0;
		 while(p != null || q != null){
			 x = (p != null) ? p.val : 0;
			 y = (q != null) ? q.val : 0;
			 sum = x + y + carry;
			 carry = sum / 10;
			 cur = head.next;
			 head.next = new ListNode(sum % 10);
			 head.next.next = cur;
			 if(p != null){
				 p = p.next;
			 }
			 if(q != null){
				 q = q.next;
			 }
		 }
		 if(carry > 0){
			 cur = head.next;
			 head.next = new ListNode(carry);
			 head.next.next = cur;
		 }
		 return head.next;
	 }
	 
	 public static ListNode getListNode(int[] arr){
		 ListNode list = null;
		 if(arr != null && arr.length > 0){
			 list = new ListNode(arr[0]);
			 ListNode curNode = list;
			 ListNode subNode = null;
			 for(int i= 1;i<arr.length;i++){
				 subNode = new ListNode(arr[i]);
				 curNode.next = subNode;
				 curNode = curNode.next;
			 }
		 }
		 return list;
	 }
}

class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
	}
}
