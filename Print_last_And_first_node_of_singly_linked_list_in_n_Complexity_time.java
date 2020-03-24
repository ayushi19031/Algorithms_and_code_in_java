import java.util.*;
public class Evil_Direction_Guy {
	public static class Node{
		Node next; Node prev;
		int data;
		Node(int d){this.data = d;}
		}
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int a = scan.nextInt();
		int[] b1 = new int[a];
		Node[] b2 = new Node[a];
		Node kk1 = new Node(0); Node kk0 = new Node(0);
		for (int i = 0; i < a; i++) {
			b1[i] = scan.nextInt();
			Node j = new Node(b1[i]);
			b2[i] = j;
		}
		for (int i = 0; i < a - 1; i++) {
			b2[i].next = b2[i + 1];
			b2[i + 1].prev = b2[i];
		}
		kk1 = b2[a - 1];
		kk0 = b2[0];
		for (int i = 0; i < a/2; i++) {
			System.out.println(kk0.data);
			System.out.println(kk1.data);
			kk0 = kk0.next;
			kk1 = kk1.prev;
		}
		if (a % 2 != 0) {System.out.println(b2[a/2].data);}
	}
}
