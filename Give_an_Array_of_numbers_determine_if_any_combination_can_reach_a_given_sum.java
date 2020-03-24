import java.util.*;
public class Thursday_gym_routine {
	public static int ans = 0;
	public static void subsetSums(int []arr, int l, int r, int sum , int x) 
	    { 
		if (l > r) {
			if (sum == x) {ans += 1;}
			return ;
		}
	        if (l <= r) 
	        { 
	            if (sum == x) {ans += 1;} 
	        } 
	        subsetSums(arr, l + 1, r,  
	                   sum + arr[l], x); 
	        subsetSums(arr, l + 1, r, sum, x); 
	    } 
public static void main(String[] args) {
Scanner scan = new Scanner(System.in);
String[] a_ = scan.nextLine().split(" ");
int[] a = new int[2];
for (int i = 0; i < 2; i++) {a[i] = Integer.parseInt(a_[i]);}
String[] b_ = scan.nextLine().split(" ");
int[] b = new int[a[0]];
for (int i = 0; i < a[0]; i++) {b[i] = Integer.parseInt(b_[i]);}
//System.out.println(a[1]);
subsetSums(b, 0, b.length - 1, 0, a[1]);
//System.out.println(ans);
if (ans > 0) {
	System.out.println(1);
}
else {
	System.out.println(0);
}
}
}