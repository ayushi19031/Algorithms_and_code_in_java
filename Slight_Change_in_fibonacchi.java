import java.util.*;

public class dsa_lab_l2B_b {
    public static int fun(int g){
        if (g == 0){return 0;}
        else if (g == 1){return 1;}
        else if (g == 2){return 2;}
        else if (g == 3) {return 4;}
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