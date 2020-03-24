import java.util.*;
class Lab_practie2{
    static int score = 0; 
    public static int fun(int[][] grid, int flag, int i, int l){
        int a = 0; int b = 0; int c = 0; int t = 0;
        if (i < l){
    if (flag == - 1){
     a = fun(grid, 0, i + 1, l ) + grid[i][0];
     b = fun(grid, 1, i + 1, l) + grid[i][1];
     c = fun(grid, 2, i + 1, l) + grid[i][2];
    }
    if (flag == 0){
     a = fun(grid, 1, i + 1, l) + grid[i][1];
    b = fun(grid, 2, i + 1, l) + grid[i][2];    
    }
    if (flag == 1){
      a = fun(grid, 0, i + 1, l) + grid[i][0];
    b = fun(grid, 2, i + 1, l) + grid[i][2];   
    }
       if (flag == 2){
      a = fun(grid, 1, i + 1, l) + grid[i][1];
    b = fun(grid, 0, i + 1, l) + grid[i][0];   
    }
    if (a >= b && a >= c){t = a;}
    else if (b >= a && b >= c){t = b;}
    else if (c >= a && c >= a){t = c;}
    score += t;
    return t;}
    else{ return 0;}
    }
public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        String k_ = scan.nextLine(); int k = Integer.parseInt(k_);
        int[][] grid= new int[k][3];
        for (int i = 0; i < k; i++){
        String a__ = scan.nextLine();
        String[] a_ = a__.split(" ", a__.length());
        int[] a = new int[3];
        for (int j = 0; j < 3; j ++){a[j] = Integer.parseInt(a_[j]);}
        grid[i] = a;
        }
        System.out.println(fun(grid, -1, 0, k));
    }
}