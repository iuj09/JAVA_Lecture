package practice;

import java.util.Scanner;

class Time { // Time class
   int h, m, s; // field
   int total;
   static int day = 0;

   public Time(int a, int b, int c) { // 생성자
      h = a;
      m = b;
      s = c;
   }

   public Time add(Time k) { // add method

      int addt = ((h * 3600) + (m * 60) + s) + ((k.h * 3600) + (k.m * 60) + k.s);

      int ts = addt % 60;
      int tm = (addt / 60) % 60;
      int th = (addt / 3600);

      if (addt >= 24 * 3600) {

         int d = th / 24;
         th = th - 24 * d;

         for (int i = 0; i < d; i++) {
            ++day;
         }
         Time t1 = new Time(th, tm, ts);
         return t1;
      }
      Time t1 = new Time(th, tm, ts);
      return t1;
   }

   public Time sub(Time k) { // sub method

      int th, tm, ts, total;
      total = (60 * 60 * h) + (60 * m) + s;
      k.total = (60 * 60 * k.h) + (60 * k.m) + k.s;

      if (total >= k.total) {

         int suball = total - k.total;

         ts = suball % 60;
         tm = (suball / 60) % 60;
         th = (suball / 60) / 60;
      } else {

         int suball = k.total - total;

         ts = suball % 60;
         tm = (suball / 60) % 60;
         th = (suball / 60) / 60;

      }

      Time nn2 = new Time(th, tm, ts);
      return nn2;

   }

   public int compare(Time k) { // compare method

      total = (h * 3600) + (m * 60) + s;
      k.total = (k.h * 3600) + (k.m * 60) + k.s;

      if (total < k.total) {
         return 1;
      } else if (total == k.total) {
         return 0;
      } else {
         return -1;
      }
   }

   public void print(Time k) { // print method

      System.out.printf("%d시 %d분 %d초\n", h, m, s);
   }
}

public class Time_class {

   public static void main(String[] args) {
      
      Scanner sc = new Scanner(System.in);
      int hour = sc.nextInt();
      int min = sc.nextInt();
      int sec = sc.nextInt();

      Time first_time = new Time(10, 10, 10);
      Time second_time = new Time(hour, min, sec);
      Time add_time = first_time.add(second_time); // add 메서드 호출
      Time sub_time = first_time.sub(second_time); // sub 메서드 호출

      System.out.println("두 시간의 합은");
      System.out.printf("%d일 ", Time.day); // print 메서드 호출
      add_time.print(add_time);

      System.out.println("두 시간의 차는");
      sub_time.print(sub_time); // print 메서드 호출

      int result = first_time.compare(second_time); // compare 메서드 호출
      System.out.println(result); // compare 메서드 호출
   }
}
