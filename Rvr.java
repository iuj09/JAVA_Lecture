package practice;

import java.util.Scanner;

public class Rvr {

	public static void main(String[] args) {
		
		System.out.println("문자열\n문자");
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		char c = sc.next().charAt(0);
		
		// String s = "abcabc"; char c = 'b';
		
		String result = revsqueeze(s, c);
		System.out.println(result);
	}

	public static String revsqueeze(String ps, char pc) {
		
		String reverse = "";
		
		for (int i = ps.length() -1; i >= 0; i--) {
			if (ps.charAt(i) != pc) {
				reverse += ps.charAt(i);
			}
		}
		return reverse;
	}
}
