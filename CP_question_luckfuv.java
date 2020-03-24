import java.util.*;
public class CF832A {
public static void main(String[] args) {
	Scanner scan = new Scanner(System.in);
	String[] a_ = scan.nextLine().split(" ");
	long[] a = new long[2];
	for (int i = 0 ; i < 2; i++) {
		a[i] = Long.parseLong(a_[i]);
	}
	long x = a[0]/a[1];
	if (x % 2 == 0) {System.out.println("NO");}
	else {System.out.println("YES");}
}
}

