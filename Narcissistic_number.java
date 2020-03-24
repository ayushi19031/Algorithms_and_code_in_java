
import java.util.Scanner;

public class solution{
    public static long pow(long a, long b){
        if (b == 0){return 1;}
        else {return a*pow(a, b - 1);}
    }
    public static boolean isnarcissist(long x){
        String y = Long.toString(x);
        long l = y.length(); long ans = 0;
        for (long j = 0; j < l; j++){
            ans += pow(Long.parseLong(Character.toString(y.charAt((int) j))), l);
        }
       // System.out.println(ans);
        if (ans == x){return true;}
        else{return false;}
    }
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        long k = Long.parseLong(scan.nextLine());
        for (int o = 0; o < k; o++) {
        String h_ = scan.nextLine();
        long h = Long.parseLong(h_);
        if (isnarcissist(h)){System.out.println("YES");}
        else {System.out.println("NO");}
        }
        }
}