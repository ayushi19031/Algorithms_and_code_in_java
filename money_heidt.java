import java.util.*;
class HuffmanNode {
	String key; 
	int frequency;
	HuffmanNode left;
	HuffmanNode right;
	public HuffmanNode(String h, int k) {
		this.key = h; this.frequency = k;
	}
}
class MyComparator implements Comparator<HuffmanNode> { 
    public int compare(HuffmanNode x, HuffmanNode y) 
    { 
    	
        int t = y.frequency - x.frequency;
    	if (t != 0) {return t;}
    	else {
    		int a1 = x.key.charAt(0); 
    		int a2	=(int) y.key.charAt(0);
    		return a2 - a1;
    	}
    } 
}
public class Huffy{
//	public static void print(HuffmanNode hfh) {
//		if (hfh.left != null) {
//			print(hfh.left);
//		}
//		System.out.println(hfh.key + " " + hfh.frequency);
//		if (hfh.right != null) {
//			print(hfh.right);
//		}
//	}
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int a = scan.nextInt();
		for (int apj = 0; apj < a; apj++) {	
			int b = scan.nextInt();
			PriorityQueue<HuffmanNode> queue = new PriorityQueue<HuffmanNode>(b, new MyComparator());
			
			for (int j = 0; j < b; j++) {
			String kk = scan.next();
			int freq = scan.nextInt(); 
			HuffmanNode hff = new HuffmanNode(kk, freq + 1);
			queue.add(hff);
			}
			HuffmanNode root = null;
			while (queue.size() > 1) {
				HuffmanNode x = queue.poll();
			//	System.out.print(x.frequency + " ");
				HuffmanNode y = queue.poll();
			//	System.out.println(y.frequency);
				HuffmanNode kkrh = new HuffmanNode("~", x.frequency + y.frequency);
				kkrh.left = x; kkrh.right = y;
				queue.add(kkrh);
				if (queue.size() == 1) {
					root = kkrh;
				//	System.out.println(root.frequency);
					break;
				}
			}
			String tt = scan.next();
	//		System.out.println("TT: " + tt + " " + tt.length());
			int g = 0;
			HuffmanNode pqr = root;
			//print(pqr);
			int hpn = 0;
			while (g < tt.length()) {
				//System.out.println(g);
				//System.out.println(pqr.right);
				if (Character.toString(tt.charAt(g)).equals("1") && pqr.left != null) {
					pqr = pqr.left;
					g += 1;
				}
				else if (Character.toString(tt.charAt(g)).equals("0") && pqr.right != null) {
					pqr = pqr.right;
					g += 1;
				}
				else if (pqr.left == null && pqr.right == null) {
					System.out.print(pqr.key) ;
						//System.out.print(" " + g);
						pqr = root;
						hpn += 1;
				}
			}
			if (pqr != root && hpn != tt.length()) {
				System.out.print(pqr.key);
			}
			System.out.println("");
				}
		}
}

