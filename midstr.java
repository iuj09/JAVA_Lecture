package practice;

import java.util.Scanner;

public class midstr {

   public static void main(String[] args) {

	  Scanner sc = new Scanner(System.in);
      String s = sc.nextLine();
      String a = sc.nextLine();
      String b = sc.nextLine();

      String result = midstr(s, a, b);
      System.out.println(result);
   }

   public static String midstr(String... strs) {

      String ps = strs[0];
      int pa = Integer.parseInt(strs[1]);
      int pb = Integer.parseInt(strs[2]);
      String temp;
      temp = ps.substring(pa - 1, pa + pb - 1);

      return temp;
   }
}
