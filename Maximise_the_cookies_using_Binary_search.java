
import java.util.*;
public class dsa_lab_6_satisfying{
public static boolean fun(long[] b,long[] c,long i, long magic_ingredient){
    boolean flag= true;
    long r = magic_ingredient;
    for (int j = 0; j < c.length; j++){
        long t = c[j] - b[j]*(i + 1);
        if (t < 0){if (r < b[j]*(i + 1) - c[j]){flag = false;break;}
            else {r = r - ((b[j])*(i + 1) - c[j]);}
            }
    }
     if (flag == true) {return true;}
        else {return false;}
}
public static long fun_1(long[] b, long[] c, long s, long e, long magic_ingredient){
  long mid = (s + e) %2;
  //System.out.println(mid);
  if (mid == 0) {mid = (s + e)/2;}
  else if (mid == 1) {mid = ((s + e)/2) + 1;}
if (e - s > 2){
    if (fun(b, c, mid, magic_ingredient) != true){return fun_1(b, c, s, mid, magic_ingredient);}
    else{return fun_1(b, c, mid, e , magic_ingredient);}
    }
   // else if (s == e){if (fun(b, c, s, magic_ingredient) == true){return s;}}
else if (e - s == 2){
        if (fun(b, c, e, magic_ingredient) == true) {return e;}
        else if (fun(b, c, e - 1, magic_ingredient) == true) {return e-1;}
        else if (fun(b, c, e - 2, magic_ingredient) == true) {return s;}
        }
else if (e - s == 1) {
      if (fun(b, c, e, magic_ingredient) == true) {return e;}
        else if (fun(b, c, e - 1, magic_ingredient) == true) {return e-1;}
    }
else  {return s;}
   return 0;
}
public static void main (String[] args) {
    Scanner scan = new Scanner(System.in);
    String a__ = scan.nextLine();
    String[] a_ = a__.split(" ", a__.length());
    int[] a = new int[2];
    for (int i = 0; i < 2; i++){a[i] = Integer.parseInt(a_[i]);}
    String b__ = scan.nextLine();
    String[] b_ = b__.split(" ", b__.length());
    long[] b = new long[a[0]];
    long sum_b = 0;
    for (int i = 0; i < a[0]; i++){b[i] = Long.parseLong(b_[i]); sum_b += b[i];}
    String c__ = scan.nextLine();
    String[] c_ = c__.split(" ", c__.length());
    long[] c = new long[a[0]];long sum_c = 0;
    for (int i = 0; i < a[0]; i++){c[i] = Long.parseLong(c_[i]);sum_c += c[i];}
    long h = a[1];
        long res= (h + sum_c)/sum_b;
    long ans_1 = fun_1(b, c, 0, res + 1, a[1]) ;
    if (ans_1 != 0) {System.out.println(ans_1 + 1);}
    else {if (fun(b, c, 0, a[1]) == true) {System.out.println(1);}
    else {System.out.println(0);}
    }
    }
}