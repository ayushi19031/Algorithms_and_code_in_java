import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Graph{
	public int V;
	public int[] color;
	public int[] d ;
	public int[] pi  ;
	Queue<Integer> queue = new LinkedList<>();
	public LinkedList<Integer> adj[];
	Graph(int v){
		V = v;
		d = new int[v + 1];
		pi  = new int[v + 1];
		color = new int[v + 1];
		adj = new LinkedList[v + 1];
		for (int i = 0; i < v + 1; i++) {
			adj[i] = new LinkedList();
		}
	}
	public void addEdge(int v, int w) {
		adj[v].add(w);
	}
	public void Distance() {
		for (int i = 1; i < V + 1; i++) {
			d[i] = Integer.MAX_VALUE;
		}
		color[1] = 1;
		d[1] = 0;
		pi[1] = -10;
		queue.add(1);
		System.out.println("Queue.size(): " + queue.size());
		while (queue.size() != 0) {
			int k = queue.poll();
			System.out.println("K: " + k);
			Iterator<Integer> iter  = adj[k].listIterator();
			while (iter.hasNext()) {
				int nn = iter.next();
				if (color[nn] == 0) {
					color[nn] = 1;
					d[nn]  = d[k] + 1;
					queue.add(nn);
				}
			}
			color[k]  = 2;
		}
		}
	public boolean isCycle() {
		int[] indegree = new int[V + 1];
		for (int i = 1; i < V + 1; i++) {
			Iterator<Integer> iter  = adj[i].listIterator();
			while (iter.hasNext()) {
				int nn = iter.next();
				indegree[nn] += 1;
			}
		}
		System.out.println("INDEGREE: " + Arrays.toString(indegree));
		Queue<Integer> qc = new LinkedList<>();
		for (int i = 1; i < V + 1; i++) {
			if (indegree[i] == 0) {
				qc.add(i);
			}
		}
		System.out.println(qc.peek());
		int countVisitedNodes = 0;
		while (qc.size() != 0) {
		int w = qc.poll();
		countVisitedNodes += 1;
		Iterator<Integer> iter  = adj[w].listIterator();
		while (iter.hasNext()) {
			int jk = iter.next();
			System.out.println("JK: " + jk);
			indegree[jk] -= 1;
			if (indegree[jk] == 0) {
				qc.add(jk);
			}
		}
		System.out.println(qc.peek());
	}
		System.out.println("countVisitedNodes: " + countVisitedNodes);
		if (countVisitedNodes != V) {
			return true;
		}
		else {
			return false;
		}}
	public boolean isBi() {
		int[] detect = new int[V + 1];
		int[] c1 = new int[V + 1];
		detect[1] = 1;
		Queue<Integer> qb = new LinkedList<>();
		qb.add(1);
		while (qb.size() != 0) {
			int k = qb.poll();
			c1[k] = 1;
			Iterator<Integer> iter  = adj[k].listIterator();
			while (iter.hasNext()) {
				int jk = iter.next();
				if (detect[k] == 1) {
					if (detect[jk] != 1){detect[jk] = 2;}
					else {return false;}
				}
				else {
					if (detect[jk] != 2){detect[jk] = 1;}
					else {return false;}
				}
				if (c1[jk] == 0) {
					qb.add(jk);
				}
			}
		}
		return true;
	}
}
public class isBi {
public static void main(String[] args) {
	Scanner scan = new Scanner(System.in);
	//int a = scan.nextInt();
//	Graph g = new Graph(13);
//	g.addEdge(1, 2);g.addEdge(1, 3);g.addEdge(1, 4);
//	g.addEdge(2, 3);g.addEdge(2, 4); g.addEdge(2, 1); g.addEdge(2, 5 );
//	g.addEdge(3, 1);g.addEdge(3, 2);g.addEdge(3, 4);g.addEdge(3, 6);g.addEdge(3, 7);
//	g.addEdge(4, 1);g.addEdge(4, 2);g.addEdge(4, 5);g.addEdge(4, 9);g.addEdge(4, 6);g.addEdge(4, 8);g.addEdge(4, 3);g.addEdge(4, 11);
//	g.addEdge(5, 2);g.addEdge(5, 4);g.addEdge(5, 9);g.addEdge(5, 10);
//	g.addEdge(6, 7);g.addEdge(6, 4);g.addEdge(6, 3);
//	g.addEdge(7, 12);g.addEdge(7, 8);g.addEdge(7, 6);g.addEdge(7, 11);
//	g.addEdge(8, 12);g.addEdge(8, 13);g.addEdge(8, 4);g.addEdge(8, 7);g.addEdge(8, 10);
//	g.addEdge(9, 4);g.addEdge(9, 5);
//	g.addEdge(10, 5);g.addEdge(10, 8);
//	g.addEdge(11, 4);g.addEdge(11, 7);
//	g.addEdge(12, 7);g.addEdge(12, 8);g.addEdge(12, 13);
//	g.addEdge(13, 12);g.addEdge(13, 8);
	Graph g = new Graph(5); 
    //g.addEdge(, 1); 
//    g.addEdge(1, 2); 
//    g.addEdge(2, 3); 
//    g.addEdge(3, 4); 
//    g.addEdge(4, 5); 
//		g.addEdge(1, 4);g.addEdge(1, 2);
//		g.addEdge(2, 1);g.addEdge(2, 3);
//		g.addEdge(3, 2);g.addEdge(3, 4);
//		g.addEdge(4, 1);g.addEdge(4, 3);
			g.addEdge(1, 2);g.addEdge(2, 3);
			g.addEdge(3, 4);g.addEdge(4, 5);g.addEdge(5, 1);
	//g.Distance();
	//System.out.println(Arrays.toString(g.d));
	//System.out.println(Arrays.toString(g.color));
	if (g.isBi() == true) {
		System.out.println("HAS CYCLE");
	}
	else {
		System.out.println("NO CYCLE");
	}
}
}
