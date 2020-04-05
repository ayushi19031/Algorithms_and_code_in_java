//You are on a system with the following scheduling policy - “At any point of time,
//schedule the process with maximum priority”.
//You are given a list of N processes with their id, arrival time and priority. Each process
//needs to run for 5 secs (i.e. the process will exit once it has been scheduled for a total
//of 5 secs). You need to tell the completion time for each process.
//Input
//First line contains number of processes N
//Next N lines contain process id, start time and priority
//Output
//For each process print the time they exited at, in the order 1 to N
//Constraints
//The process IDs are from 1 to N in input
//Start time >= 0
//N <= 10^5
//Priority <= 10^9
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
class Process {
	public long pid;
	public int start;
	public long priority;
	public int left;
	public int ht;
	public int hk;
	public Process(int pid, int start, int priority) {
		this.pid = pid;
		this.start = start;
		this.priority = priority;
		this.left = 5;
	}
}
class Sortbystart implements Comparator<Process>
	{
	 public int compare(Process a, Process b)
	 {
	 return a.start - b.start;
	 }
	}
	
	class MaxyHeap{
		int size = 0;
		int maxsize;
		Process[] array;
		int[] at;
		int time = 0;
		public MaxyHeap(int m) {
			at = new int[m];
			this.maxsize = m + 1;
			array = new Process[maxsize];
			//array[0] = 1;
		}
		public int leftChild(int k) {return (2*k) + 1;}
		public int rightChild(int k) {return 2*k + 2;}
		public int parent(int k) {
			return (k - 1)/2;
		}
		public void decrementMax() {
			array[0].left = array[0].left - 1;
			
		//	System.out.println("ARRAY[0].LEFT = " + array[0].pid + " " + array[0].left);
			if (array[0].left <= 0) {
				array[0].ht  = time;
				at[(int) array[0].pid - 1] = time + 1;
				extractMax();
			}
			return ;
		//	size = size - 1;
			//return array[0];
			}
		public void swap(int a, int b) {
			Process temp = array[a];
			array[a] = array[b];
			array[b] = temp;
		}
		public void extractMax() {
	//	if (size > 0) {System.out.println("MY SIZE: " + size + "SWAPPING: " + array[size - 1].pid);}
			swap(0, size - 1);
			
			size = size - 1;
			//System.out.println("ARRAY[0]  " + array[0]);
			if (size == 2) {
				if (array[0].priority < array[1].priority) {
					swap(0, 1);
				}
			}
			else {
			maxHeapify(0);}
		}
		public boolean isLeaf(int k) {
			if (k >= size/2 && k < size) {
				return true;
			}
			return false;
		}
		public void maxHeapify(int k) {
			if (isLeaf(k)) {
				if (leftChild(k) < size) {
					if (array[leftChild(k)].priority < array[k].priority) {
						swap(k, leftChild(k));
					}
				}
				return ; 
			}
		
			if (array[k].priority < array[leftChild(k)].priority || array[k].priority < array[rightChild(k)].priority) {
				if (array[leftChild(k)].priority > array[rightChild(k)].priority) {
					if (leftChild(k) < size) {
					swap(k, leftChild(k));
					maxHeapify(leftChild(k));}
				}
				else {
					if (rightChild(k) < size) {
					swap(k, rightChild(k));
					maxHeapify(rightChild(k));}
				}
			}
		}
		public void print() {
			for (int i = 0; i < size; i++)
				{System.out.print(array[i].pid + " ");}
			System.out.println("");
		}
		
		public void insert(Process l) {
			array[size] = l;
			size += 1;
			int curr = size - 1;
			while (array[parent(curr)].priority < array[curr].priority) {
				swap(curr, parent(curr));
				curr = parent(curr);
			}
	}
	}
	public class Main{
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		ArrayList<Process> processes =  new ArrayList<Process>();
		int n = scan.nextInt();
		for (int i=0;i<n;i++){
			 int id = scan.nextInt();
			 int st = scan.nextInt();
			 int pr = scan.nextInt();
			 Process kk = new Process(id, st, pr);
			 kk.hk = i;
			 processes.add(kk);
			}
		
		Collections.sort(processes,  new Sortbystart());
		MaxyHeap heap = new MaxyHeap(n);
		int[] array = new int[n];
		int index = 0;
		int time = 0;
		boolean flag = true;
		boolean fm = true;
		int lk = processes.get(0).start;
		while (time <= n*5 + (int) lk){
			//heap.print();
			int tt = 0;
	//		System.out.println("YES!!");
			while (processes.size() != 0) {
			if (processes.get(0).start == time) {
				heap.insert(processes.get(0));
					processes.remove(processes.get(0));}	
			else {
				break;
			}
			}
			if (heap.array[0].left == 0) {
				array[(int) heap.array[0].pid - 1] = time;
			}
				
			if (heap.array[0].left == 0) {
				array[(int) heap.array[0].pid - 1] = time;
			}	
			if (heap.size != 0)
				heap.decrementMax();
			heap.time += 1;
			if (heap.maxsize > 0)
				//heap.maxHeapify(0);
			//heap.print();
		//	System.out.println(time);
		
			
//			if (heap.size == 0 && flag == false) {
		//		System.out.println("Hakuna Matata");
//				break;
//			}
				time += 1;
		}
		int[] pq = heap.at;
		for (int j = 0; j < n; j++) {
			System.out.println(pq[j]);
		}
		}
	
	}
	