package practice;

import java.util.Scanner; // Scanner 클래스 호출

public class Circular_shift {

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);  // Scanner 객체 생성
		int num = in.nextInt();  // 변수 num의 형태 설정
		int n = in.nextInt();  // 변수 n의 형태 설정
		int check = 0x80000000;  // 변수 선언
		
		System.out.println(Integer.toBinaryString(num));  // shift left 실행 전 num의 2진수 표기
		
		for (int i = 0; i < n; ++i) {  // 변수 i의 범위 설정
			if ((num & 1) == 0)  // num의 끝자리가 0일 경우
				num = num << 1;  // shift left 실행
			else {  // num의 첫비트가 1인경우
				num = num << 1;  // shift left 실행
				num = (num | 1);  // num의 마지막비트 1로 바꾸기
			}
		}
		System.out.println(Integer.toBinaryString(num));  // shift left 실행 후 num의 2진수 표기
	}

}
