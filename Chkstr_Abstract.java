package practice;

import java.util.Scanner;

abstract class Tr1 { // 부모 클래스
   // field
   String str1, str2;

   public Tr1(String x, String y) { // 생성자
      str1 = x;
      str2 = y;
   }

   public abstract int cmp(); // 추상메서드
}

class Strcmp1 extends Tr1 {

   public Strcmp1(String x, String y) { // 생성자
      super(x, y); // 부모클래스 생성자 호출
   }

   public int cmp() { // cmp 메서드 - 문자로 비교하는 메서드 compareTo

      int result = str1.compareTo(str2);
      return result;
   }
}

class Numcmp1 extends Tr1 {

   public Numcmp1(String x, String y) {// 생성자
      super(x, y);
   }

   public int cmp() {
      // 실수형 변수 a,b 선언
      double a;
      double b;
      int result;
      // 문자열 x, y를 실수형으로 변환
      a = Double.parseDouble(str1);
      b = Double.parseDouble(str2);
      // a가 b보다 클 시 1; a가 b보다 작을 시 -1; a와 b가 같을 시 0;의 결과값을 받는 조건문
      if (a > b)
         result = 1;
      else if (a < b)
         result = -1;
      else
         result = 0;

      return result; // 결과값 반환
   }
}

class Select1 {

   String st1, st2; // filed

   public Select1(String s1, String t1) { // 생성자
      st1 = s1;
      st2 = t1;
   }

   public Tr1 check() {

      for (int i = 0; i < st1.length(); i++) {
         if (Character.isDigit(st1.charAt(i)) == true || st1.charAt(i) == '-' || st1.charAt(i) == '.') {
            continue;
         } else {
            return new Strcmp1(st1, st2);
         }
      }

      for (int i = 0; i < st2.length(); i++) {
         if (Character.isDigit(st2.charAt(i)) == true || st2.charAt(i) == '-' || st2.charAt(i) == '.') {
            continue;
         } else {
            return new Strcmp1(st1, st2);
         }
      }
      return new Numcmp1(st1, st2);
   }
}

public class Chkstr_Abstract {

   public static void main(String[] args) {
      
      Scanner sc = new Scanner(System.in);
      String s = sc.nextLine();
      String t = sc.nextLine();

      Select1 P;
      Tr1 Q;

      P = new Select1(s, t);
      Q = P.check();
      System.out.println(Q.cmp());
   }

}
