package practice;

import java.util.Scanner;

public class Circular_shift2 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int n = sc.nextInt();
		int check = 0x80000000;
		int check2 = 0x7FFFFFFF;
		
		System.out.println(Integer.toBinaryString(num));
		
		for (int i = 0; i < n; i++) {
			if (num >= 0)
				if ((num & 1) == 0)
					num = num >> 1;
				else {
					num = num >> 1;
					num = (num | check);
				}
			else {
				if ((num & 1) == 0) {
					num = num >> 1;
					num = num & check2;
				} else {
					num = num >> 1;
				}
			}
		}
		System.out.println(Integer.toBinaryString(num));
	}

}
