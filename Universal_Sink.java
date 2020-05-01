// Determine universal sink in graph. Input: ADJACENCY MATRIX
import java.util.*;
public class UniversalsINK {
	public static boolean isSink(int[][] grid, int i) {
		for (int k = 0;  k < grid.length; k++) {
			if (grid[k][i] == 0 && k != i) {
				return false;
			}
		}
		for (int k = 0;  k < grid.length; k++) {
			if (grid[i][k] == 1 ) {
				return false;
			}
		}
		return true;
	}
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int a = scan.nextInt();
		int[][] grid = new int[a][a];
		for (int i = 0; i < a; i++) {
			for (int j = 0 ; j < a; j++) {
				grid[i][j] = scan.nextInt();
			}
		}
		int i = 0;
		int j = 0;
		while (i < a && j < a) {
			if (grid[i][j] == 1) {
				i += 1;
				
			}
			else {
				j += 1;
				}
		}
		if (i >= a) {
			System.out.println("There is no universal sink.");
		}
		else if (isSink(grid, i)) {
			i += 1;
			System.out.println("The universal sink is " + i);
		}
	}
}
