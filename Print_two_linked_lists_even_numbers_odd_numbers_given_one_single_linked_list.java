import java.util.*;
public class ABhiman_to_rescue {
	Node head; 
	public static class Node{
		int data; Node prev; Node next;
		Node(int d){this.data = d;}}
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int a = scan.nextInt();
		int[] b = new int[a];
		Node head = new Node(0);
		Node head1 = new Node(0);Node head2 = new Node(0);Node ptr1 = head1; Node ptr2 = head2; 
		for (int i = 0; i < a ;i++) {
			b[i] = scan.nextInt();
			Node f = new Node(b[i]);
			if (b[i] % 2 == 0) {ptr1.next = f; ptr1 = ptr1.next;}
			else {ptr2.next = f; ptr2 = ptr2.next; }
		}
		
		Node final1;Node final2;
		int v2 = 0;
		if (head2.next != null) {final2 = head2.next;}
		else {final2 = null;}
		
		while (final2 != null) {
			System.out.print(final2.data + " ");
			if (final2.next != null) {final2 = final2.next;}
			else {final2  = null;}
		}
		System.out.println("");
		int v1 = 0;
		if (head1.next != null) {final1 = head1.next;}
		else {final1 = null;}
		while (final1 != null) {
			System.out.print(final1.data + " ");
			if (final1.next != null) {final1 = final1.next;}
			else {final1  = null;}
		}
	
}
}