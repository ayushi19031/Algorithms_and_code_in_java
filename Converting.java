import java.util.*;
public class dsa_p_lab_1_A{
    public static int fun(int a, int b, int c){
    if (b > a){
    if (b % c == 0){
        return 1 + fun(a, b/c, c);
        }
    else{ int u = c*(b/c + 1) - b ;int u1 = u/2; int u2 = 0;if (u%2 == 0){u2 = 0;} else {u2 = 1;}
        return u1 + u2 + fun(a, c*(b/c + 1), c);
        }
    }
     else if (b < a){
         int u1 = (a - b)/2;int u2 = 0; if ((a - b) % 2 != 0){u2 = 1;} else {u2 = 0;}
        return u1 + u2; 
        }
    else if (b == a){return 0;}    
    
        return 0;
    }
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        String a_ = scan.nextLine();
        int a = Integer.parseInt(a_);
        for (int i = 0; i < a; i++){
            String b__ = scan.nextLine();
            String[] b_ = b__.split(" ", b__.length());
            int[] b = new int[3];;
            for (int j = 0; j < 3; j++){b[j] = Integer.parseInt(b_[j]);}
            System.out.println(fun(b[0], b[1], b[2]));
        }
    }
}