package practice;

import java.util.Scanner;

class Tr {
   // field
   String str1, str2;

   public Tr(String x, String y) { // 생성자
      str1 = x;
      str2 = y;
   }
}

class Strcmp extends Tr {
   public Strcmp(String x, String y) { // 생성자
      super(x, y); // 부모클래스 생성자 호출
   }

   public int cmp() { // cmp 메서드 - 문자로 비교하는 메서드 compareTo

      int result = str1.compareTo(str2);
      return result;
   }
}

class Numcmp extends Tr {
   public Numcmp(String x, String y) { // 생성자
      super(x, y); // 부모클래스 생성자 호출
   }

   public int cmp() { // cmp 메서드를 실수로 변환하여 비교하는 메서드
      // 실수형 변수 a,b 선언
      double a;
      double b;
      int result;
      // 문자열 x,y를 실수형으로 변환
      a = Double.parseDouble(str1);
      b = Double.parseDouble(str2);
      // a가 b보다 클 시 1; a가 b보다 작을 시 -1; a와 b가 같을 시 0의 결과값을 받음
      if (a > b)
         result = 1;
      else if (a < b)
         result = -1;
      else
         result = 0;

      return result; // 결과값 반환
   }
}

class Select extends Tr {
   public Select(String x, String y) { // 생성자
      super(x, y); // 부모클래스 생성자 호출
   }

   public Tr Check() { // check 메서드 - 두 문자열의 상태에 맞는 cmp 메서드를 가지는 객체를 리턴(Strcmp/Numcmp)

      for (int i = 0; i < str1.length(); i++) {
         if (Character.isDigit(str1.charAt(i)) == true || str1.charAt(i) == '-' || str1.charAt(i) == '.') {
            continue;
         } else {
            return new Strcmp(str1, str2);
         }
      }

      for (int i = 0; i < str2.length(); i++) {
         if (Character.isDigit(str2.charAt(i)) == true || str2.charAt(i) == '-' || str2.charAt(i) == '.') {
            continue;
         } else {
            return new Strcmp(str1, str2);
         }
      }
      return new Numcmp(str1, str2);
   }

   public int Connect(Tr q) { // connect 메서드 - 매개변수로 받은 객체의 cmp 메서드 실행한 결과를 리턴
                        // (instanceof 사용하여 매개 변수로 받은 객체의 클래스 파악하여 cmp 메소드 실행)
      if (q instanceof Numcmp) {
         return ((Numcmp) q).cmp();
      } else {
         return ((Strcmp) q).cmp();
      }
   }
}

public class Chkstr_Inheritance {

   public static void main(String[] args) {
      
      Scanner sc = new Scanner(System.in);
      String s = sc.nextLine();
      String t = sc.nextLine();

      Tr P, Q;

      P = new Select(s, t); // Select에 객체 P가 들어갈 공간 생성과 초기화(Upcasting)
      Q = ((Select) P).Check();

      System.out.println(((Select) P).Connect(Q));
   }

}
