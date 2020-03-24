import java.util.*;
public class One_vs_one {
	public static int fun2(int[] b) {
		int ans = 0;
		for (int i = 0; i < b.length; i++) {
			if (b[i] == 0) {ans += 1;}
		}
		return ans;
	}
	public static int[] fun(int[] b, int a) {
		boolean flag = false;
		for (int i = 0; i < a - 1; i++) {
			if (b[i] > 0 && b[i + 1] < 0) {
				if (Math.abs(b[i + 1]) > b[i]) {
				b[i] = 0;	
				}
				else if (Math.abs(b[i + 1]) < b[i]) {
					b[i + 1] = 0;
				}
				else {
					b[i] = 0; b[i + 1] = 0;
				}
				}
	} int t = b.length - fun2(b);
		int[] c = new int[t];
		int j  = 0; int k = 0;
		while (j != t) {
			if (b[k] != 0) {
				c[j] = b[k];
				j += 1;
			}
			k += 1;
		}
		for (int h = 0; h < t - 1; h++) {
			if (c[h] > 0 && c[h + 1] < 0) {
				flag = true; break;
			}
		}
		if (flag == true) {
		return fun(c, t);
		}
		else {return c;}
		}
		
	public static void main(String[] args) {
	Scanner scan = new Scanner(System.in);
	int a = Integer.parseInt(scan.nextLine());
	String[] b_ = scan.nextLine().split(" ");
	int[] b = new int[a];
	for (int i = 0; i < a; i++) {
		b[i] = Integer.parseInt(b_[i]);
	}
	int[] y = fun(b, a);
	for (int i = 0; i < y.length; i++) {
		if (y[i] != 0) {
			System.out.print(Integer.toString(y[i]) + " ");
		}
	}
	
	} 
}
