package myutil;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MyList{
	public String data;
	public MyList next;
	public MyList(String data,MyList next){
		this.data = data;
		this.next = next;
	}
	
	public static MyList createList(){
		MyList L = new MyList(null, null);//Í·½áµã
		MyList nextNode = L;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s;
		try {
			s = br.readLine();
			String dataarry[] = s.split(",");
			int i = 0;
			while(i < dataarry.length){
				MyList node = new MyList(null, null);
				node.data = dataarry[i];
				node.next = nextNode.next;
				nextNode.next = node;
				nextNode = node;
				i++;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return L;
	}
	public static void traverseList(MyList L){
		MyList node = L.next;
		while(node.next != null){
			System.out.print(node.data + "->");
			node = node.next;
		}
		System.out.print(node.data);
		System.out.println();
	}
	
	public static void main(String args[]){
		MyList L = createList();
		traverseList(L);
	}
	public static int length(MyList L){
		MyList p = L.next;
		int len = 0;
		while(p != null){
			p = p.next;
			len ++;
		}
		return len;
	}
}