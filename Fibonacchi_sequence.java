import java.util.*;

public class dsa_l2_A{
    public static int fun(int g){
        if (g == 0){return 0;}
        else if (g == 1){return 0;}
        else if (g == 2){return 1;}
        else if (g == 3) {return 1;}
        else{
            return fun(g - 1) + fun(g - 2) + fun(g - 3);
        }
    }
    public static void main(String args[]){
        Scanner scan = new Scanner(System.in);
        String a_ = scan.nextLine();
        int a = Integer.parseInt(a_);
        System.out.println(fun(a));
    }
}