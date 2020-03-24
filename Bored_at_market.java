import java.util.*;
public class Bored_at_the_market {
	Node head; static int iter = 0;
	public static class Node{
		int data; Node prev; Node next;
		Node(int d){this.data = d;}}
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int a = Integer.parseInt(scan.nextLine());
		String[] b_ = scan.nextLine().split(" ");
		int[] b = new int[a];
		for (int i = 0; i < a; i++) {b[i] = Integer.parseInt(b_[i]);}
		Node head = new Node(0);Node ptr2 = head;
		Node ptr1 = head;
		for (int i = 0; i < a; i++) {
			Node f = new Node(b[i]);
			ptr1.next = f;
			ptr1 = ptr1.next;
			}
		ptr2 = ptr2.next; head = head.next;
		int no_of_queries = Integer.parseInt(scan.nextLine());
		for (int i = 0; i < no_of_queries; i++) {
			String[] query_ = scan.nextLine().split(" "); int[] query = new int[query_.length];
			for (int j = 0; j < query_.length; j++) {
				query[j] = Integer.parseInt(query_[j]);
			}
			if (query[0] == 3) {
				head = head.next; ptr2 = head;
			}
			else if (query[0] == 2) {
				Node ptr3 = ptr2;
				while (ptr3.next != null) {ptr3 = ptr3.next;}
				Node x = new Node(query[1]);
				ptr3.next = x;
		}
			else if (query[0] == 1) {
			Node ptr4 = ptr2;
			int iter = 0;
			while (iter != query[1] - 1) {
				ptr4 = ptr4.next;
				iter += 1;
			}
			System.out.println(ptr4.data);
			}
			}
	}
}