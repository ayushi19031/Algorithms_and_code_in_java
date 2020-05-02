import java.util.*;

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
	void Distance() {
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
	void BFS(int s)
	{
		boolean visited[] = new boolean[V];
		LinkedList<Integer> queue = new LinkedList<Integer>();
		visited[s] = true;
		queue.add(s);
		while (queue.size() != 0)
		{
			s = queue.poll();
			System.out.print(s + " ");
			Iterator<Integer> i = adj[s].listIterator();
			while (i.hasNext())
			{
				int n = i.next();
				if (!visited[n])
				{
					visited[n] = true;
					queue.add(n);
				}
			}
		}
	}
}

public class LoveTriangle {
public static void main(String[] args) {
	Scanner scan = new Scanner(System.in);
	//int a = scan.nextInt();
	Graph g = new Graph(13);
	g.addEdge(1, 2);g.addEdge(1, 3);g.addEdge(1, 4);
	g.addEdge(2, 3);g.addEdge(2, 4); g.addEdge(2, 1); g.addEdge(2, 5 );
	g.addEdge(3, 1);g.addEdge(3, 2);g.addEdge(3, 4);g.addEdge(3, 6);g.addEdge(3, 7);
	g.addEdge(4, 1);g.addEdge(4, 2);g.addEdge(4, 5);g.addEdge(4, 9);g.addEdge(4, 6);g.addEdge(4, 8);g.addEdge(4, 3);g.addEdge(4, 11);
	g.addEdge(5, 2);g.addEdge(5, 4);g.addEdge(5, 9);g.addEdge(5, 10);
	g.addEdge(6, 7);g.addEdge(6, 4);g.addEdge(6, 3);
	g.addEdge(7, 12);g.addEdge(7, 8);g.addEdge(7, 6);g.addEdge(7, 11);
	g.addEdge(8, 12);g.addEdge(8, 13);g.addEdge(8, 4);g.addEdge(8, 7);g.addEdge(8, 10);
	g.addEdge(9, 4);g.addEdge(9, 5);
	g.addEdge(10, 5);g.addEdge(10, 8);
	g.addEdge(11, 4);g.addEdge(11, 7);
	g.addEdge(12, 7);g.addEdge(12, 8);g.addEdge(12, 13);
	g.addEdge(13, 12);g.addEdge(13, 8);
	LinkedList<Integer> queue = new LinkedList<Integer>();
	int[] color = new int[14];
	g.Distance();
	System.out.println(Arrays.toString(g.d));
	System.out.println(Arrays.toString(g.color));
	
}
}
