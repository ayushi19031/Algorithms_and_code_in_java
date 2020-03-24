import java.util.*;

public class Binary_trees_2 {
	public static class Node {
		int data; Node left; Node right;
		Node parent;
		public Node(int k) {
			this.data = k;
			this.left = null; this.right = null; this.parent = null;
		}
	}
	public static void PrintIn(Node dummy) {
		if (dummy.left != null) {PrintIn(dummy.left);}
		System.out.print(dummy.data + " ");
		if (dummy.right != null) {PrintIn(dummy.right);}
	}
	public static void PrintPre(Node dummy) {
		System.out.print(dummy.data + " ");
		if (dummy.left != null) {PrintPre(dummy.left);}		
		if (dummy.right != null) {PrintPre(dummy.right);}
	}
	public static void PrintPost(Node dummy) {
		if (dummy.left != null) {PrintPost(dummy.left);}
		if (dummy.right != null) {PrintPost(dummy.right);}
		System.out.print(dummy.data + " ");
	}
	public static void insertNode(Node root, int j) {
		Node kk = new Node(j);
		if (j <= root.data) {
			if (root.left == null) {root.left = kk; kk.parent = root; }
			else {insertNode(root.left, j);}
		}
		else if (j > root.data) {
			if (root.right == null) {root.right = kk; kk.parent = root;}
			else {insertNode(root.right, j);}
		}
	}
	public static Node getFirstNode(Node root, int j) {
		Node pqr = root;
		if (root.data == j) {return pqr;}
		else if (root.data < j) {
			if (root.right != null) {pqr = getFirstNode(root.right, j);}
			else {pqr = null;}
		}
		else if (root.data > j) {
			if (root.left != null) {pqr = getFirstNode(root.left, j);}
			else {pqr = null;}
		}
		return pqr;
	}
	public static Node getLastNode(Node root, int j) {
		Node pqr = root;
		if (root.data == j) {
			if (root.left != null) {if (root.left.data == j) {pqr = getLastNode(root.left, j);} else{pqr = root;}}
			else { pqr = root;}
		}
		else if (j < root.data) {
			if (root.left != null) {pqr = getLastNode(root.left, j);}
			else {pqr = null;}
		}
		else if (j > root.data) {
			if (root.right != null) {pqr = getLastNode(root.right, j);}
			else {pqr = null;}
		}
		return pqr;
	}
	public static void deleteNode(Node root, int j, int swi) {	
		Node pqr = null;
		pqr = getLastNode(root, j);
		if (pqr == null) {return ;}
		if (pqr.left == null && pqr.right == null) {
		//	System.out.println("SNoGF");
			if (pqr.parent != null) {
				if (pqr.parent.left == pqr) {pqr.parent.left = null; pqr.parent = null;}
				else if (pqr.parent.right == pqr) {pqr.parent.right = null; pqr.parent = null;}
			}
		}
		else if (pqr.left == null || pqr.right == null) {
			//System.out.println("SGF");
			if (pqr.left != null) {
				if (pqr.parent.left == pqr) {
					pqr.parent.left = pqr.left; pqr.left.parent = pqr.parent; pqr.parent = null; pqr.left = null;
				}
				else if (pqr.parent.right == pqr) {
					pqr.parent.right = pqr.left; pqr.left.parent = pqr.parent; pqr.parent = null; pqr.left = null;
				}
			}
			else if (pqr.right != null) {
				if (pqr.parent.left == pqr) {
					pqr.parent.left = pqr.right; pqr.right.parent = pqr.parent; pqr.parent = null; pqr.right = null;
				}
				else if (pqr.parent.right == pqr) {
					pqr.parent.right = pqr.right; pqr.right.parent = pqr.parent; pqr.parent = null; pqr.right = null;
				}
			}
		}
		else if (pqr.left != null && pqr.right != null) {
			//System.out.println("DoGF");
			Node ptr = pqr.right;
			while (ptr.left != null) {ptr = ptr.left;}
			deleteNode(root, ptr.data, 0);
			pqr.data = ptr.data;
		}
	}
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int a = Integer.parseInt(scan.nextLine());
		Node dummy = new Node(-100);
		for (int i = 0; i < a; i++) {
			String[] x = scan.nextLine().split(" ");
			if (x[0].equals("INSERT")) {
				int l = Integer.parseInt(x[1]); //System.out.println(l);
				if (dummy.left == null && dummy.right == null) {insertNode(dummy, l);}
				else {insertNode(dummy.right, l);}
			}
			else if (x[0].equals("DELETE")) {
				int l = Integer.parseInt(x[1]);
				deleteNode(dummy, l, 1);
			}
			else if (x[0].equals("PRINTIN")) {
				if (dummy.right != null) {PrintIn(dummy.right); System.out.println("");}
				else {System.out.println("-1");}
			}
			else if (x[0].equals("PRINTPOST")) {
				if (dummy.right != null) {PrintPost(dummy.right); System.out.println("");}
				else {System.out.println("-1");}
			}
			else if (x[0].equals("PRINTPRE")) {
				if (dummy.right != null) {PrintPre(dummy.right); System.out.println("");}
				else {System.out.println("-1");}
			}
		}
	}
}