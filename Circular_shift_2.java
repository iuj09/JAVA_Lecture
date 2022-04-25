package practice;

import java.util.Scanner; // Scanner 클래스 호출

public class Circular_shift_2 {

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);  // Scanner 객체 생성
		int num = in.nextInt();  // 변수 num의 형태 설정(정수형 데이터)
		int n = in.nextInt();  //  변수 n의 형태 설정(bit)
		int check = 0x80000000;  // 변수 선언
				
		System.out.println(Integer.toBinaryString(num));  // shift right 실행 전 num의 2진수 표기
		
		for (int i = 0; i < n; ++i) {  // i의 범위 설정
			if (num >= 0)  // num이 양수일 경우
				if ((num & 1) == 0)  // num의 끝자리가 0일 경우
					num = num >> 1;  // shift right 실행
				else {  // (num & 1) != 0일 경우
					num = num >> 1;  // shift right 실행
					num = (num | check);  // num과 check의 자리 비교(비트 연산자 |)
				}
			else {  // num이 음수일 경우
				if ((num & 1) == 0) { // num의 끝자리가 0일 경우
					num = num >> 1; // shift right 실행
					num = (num & ~check);  // num과 'check의 보수'의 자리 비교(비트 연산자 &)
			}
			else {
				num = num >> 1;  // shift right 실행
				}
			}
		}
		System.out.println(Integer.toBinaryString(num));  // shift right 실행 후 num의 2진수 표기
	}
}
