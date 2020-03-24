import java.util.*;
public class Three_Legged_Defenders {
public static void main(String[] args) {
	Scanner scan = new Scanner(System.in);
	int a = scan.nextInt();
	for (int i = 0; i < a; i++) {
		int ans = 0;
	int b = scan.nextInt();
	int[] c = new int[b];
	for (int j = 0; j < b; j++) {
		c[j] = scan.nextInt();
		ans += c[j]/3;
		
	}
	System.out.println(ans);
	}
}
}
