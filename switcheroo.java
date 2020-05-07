import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Grapht{
	public int V;
	public int[] color;
	public int[] colorx;
	public int[] d ;
	public int[] pi  ;
	public int[] time;
	public int timeM = 1;
	Queue<Integer> queue = new LinkedList<>();
	public LinkedList<Integer> adj[];
	Grapht(int v){
		timeM = 0;
		V = v;
		d = new int[v + 1];
		pi  = new int[v + 1];
		color = new int[v + 1];
		colorx = new int[v + 1];
		time = new int[v + 1];
		adj = new LinkedList[v + 1];
		for (int i = 0; i < v + 1; i++) {
			adj[i] = new LinkedList();
		}
	}
	public void addEdge(int v, int w) {
		adj[v].add(w);
	}
	public void dfsUtil(int jk) {
		color[jk] = 1;
		time[jk] = timeM;
		timeM += 1;
		Iterator<Integer> iter  = adj[jk].listIterator();
		while (iter.hasNext()) {
			int kd = iter.next();
			if (color[kd] == 0) {
				dfsUtil(kd);
			}
		}
		
	} 
	public void DFS(int t) {
		Iterator<Integer> iter  = adj[t].listIterator();
		while (iter.hasNext()) {
			int kk = iter.next();
			if (color[kk] == 0) {
				dfsUtil(kk);
			}
		}
		color = colorx.clone();
	//	System.out.println("COLORS: " + Arrays.toString(color));
		timeM = 1;
	}
}
public class isDistanceEqual {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int a = scan.nextInt();
		for (int i = 0; i < a; i++) {
			int b = scan.nextInt();
			Grapht g = new Grapht(b);
			int[] c = new int[b];
			for (int j = 0; j < b; j++) {
				c[j] = scan.nextInt();
				g.addEdge(j + 1, c[j]);
			}
			for (int j = 0; j < b; j++) {
				g.DFS(j + 1);
				if (j == 0) {
					int kh = g.time[1] + 1;
					System.out.print(kh + " ");}
				else {
				System.out.print(g.time[j + 1] + " ");}
			}
			System.out.println("");
		}
	}
}

