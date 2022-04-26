package practice;

import java.util.Scanner;

class Ts {
  
   // field(멤버 변수 선언)
   public static final int NUM = 0;
   public static final int STR = 1;
   String x, y;

   public Ts(String x1, String y1) { // 생성자 정의
      x = x1;
      y = y1;
   }

   // 주어진 두 문자열의 상태에 대한 정보를 반환시켜주는 함수
   // 두 문자열이 모두 숫자 문자열이면 NUM을, 그렇지 않으면 STR을 반환
   public int Check() { 
     
      // 변수 str1, str2 선언
      String str1 = "";
      String str2 = "";
     
      for (int i = 0; i < str1.length(); i++) {
         if (Character.isDigit(str1.charAt(i)) == true || str1.charAt(i) == '-' || str1.charAt(i) == '.') {
            continue;
         } else {
            return STR;
         }

      }

      for (int i = 0; i < str1.length(); i++) {
         if (Character.isDigit(str2.charAt(i)) == true || str2.charAt(i) == '-' || str2.charAt(i) == '.') {
            continue;
         } else {
            return STR;
         }
      }
      return NUM;
   }
}

public class Chkstr {

   public static void main(String[] args) {
      
      Scanner sc = new Scanner(System.in);
      String s = sc.nextLine();
      String t = sc.nextLine();
      double a, b;
      int result;

      Ts P = new Ts(s, t);
      int cond = P.Check();

      if (cond == Ts.STR) {
         result = s.compareTo(t);
      } else {
         a = Double.parseDouble(s);
         b = Double.parseDouble(t);
         if (a > b)
            result = 1;
         else if (a < b)
            result = -1;
         else
            result = 0;
      }
      System.out.println(result);
   }
}
