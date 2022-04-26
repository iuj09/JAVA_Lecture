package practice;

import java.util.Scanner;

public class Circular_shift1 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int n = sc.nextInt();
		int check = 0x80000000;
		
		System.out.println(Integer.toBinaryString(num)); // shifr left 실행 전 num을 2진수 표기
		
		for (int i = 0; i < n; i++) { // i의 범위 설정
			if ((num & check) == 0) //num과 check의 자리 비교(비트 연산자 &) / num의 첫 비트가 0인 경우
				num = num << 1; // shift left 실행
			else { // num의 첫 비트가 1인 경우
				num = num << 1; // shift left 실행
				num += 1; // num의 마지막 비트를 1로 바꾸기위해 값에 +1
			}
		}
		System.out.println(Integer.toBinaryString(num)); // shifg left 실행 후 num을 2진수 표기
	}

}
