package JustForTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TestforSystemin {
	public static void main(String args[]){
		String s = "";
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			s = br.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(s);
	}
}
