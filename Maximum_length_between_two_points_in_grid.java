import java.util.*;
public class DS19L101 {
public static int solve_grid(String[][] grid,int x , int y, int row, int column) {
	int a = 0; int b = 0;
	
		if (x < row - 1 && y < column ) {
			 if (grid[x][y].equals("x")) {a =  1 + solve_grid(grid , x+1 , y, row, column);}
			 else {a = solve_grid(grid , x+1 , y,row, column);  }
		}
		if (y < column - 1 && x < row) {
			if (grid[x][y].equals("x")) {b =  1 + solve_grid(grid , x , y + 1, row, column);}
			 else {b = solve_grid(grid , x , y + 1,row, column);  }
		}
	
if (a > b) {return a;}
else {return b;}
}
public static void main(String[] args) {
	Scanner scan = new Scanner(System.in);
	int a = Integer.parseInt(scan.nextLine());
	String[][] array = new String[a][a];
			for (int i= 0; i < a; i++) {
				array[i] = scan.nextLine().split("");
			}
		
    int j = solve_grid(array, 0, 0, a , a);
    if (array[a - 1][a - 1].equals("x")) {j += 1;}
    System.out.println(j);
}
}
