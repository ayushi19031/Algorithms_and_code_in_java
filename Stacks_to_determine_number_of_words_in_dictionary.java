// Using stacks determine how many words in a list of numbers without duplication
import java.util.*;
public class How_many_words {
	static void merge(String arr[], int l, int m, int r) 
    { 
        // Find sizes of two subarrays to be merged 
        int n1 = m - l + 1; 
        int n2 = r - m; 
  
        /* Create temp arrays */
        String L[] = new String[n1]; 
        String R[] = new String[n2]; 
  
        /*Copy data to temp arrays*/
        for (int i=0; i<n1; ++i) 
            L[i] = arr[l + i]; 
        for (int j=0; j<n2; ++j) 
            R[j] = arr[m + 1+ j]; 
  
  
        /* Merge the temp arrays */
  
        // Initial indexes of first and second subarrays 
        int i = 0, j = 0; 
  
        // Initial index of merged subarry array 
        int k = l; 
        while (i < n1 && j < n2) 
        { 
            if (L[i].compareTo(R[j]) < 0) 
            { 
                arr[k] = L[i]; 
                i++; 
            } 
            else
            { 
                arr[k] = R[j]; 
                j++; 
            } 
            k++; 
        } 
  
        /* Copy remaining elements of L[] if any */
        while (i < n1) 
        { 
            arr[k] = L[i]; 
            i++; 
            k++; 
        } 
  
        /* Copy remaining elements of R[] if any */
        while (j < n2) 
        { 
            arr[k] = R[j]; 
            j++; 
            k++; 
        } 
    }
	static void sort(String arr[], int l, int r) 
    { 
        if (l < r) 
        { 
            // Find the middle point 
            int m = (l+r)/2; 
  
            // Sort first and second halves 
            sort(arr, l, m); 
            sort(arr , m+1, r); 
  
            // Merge the sorted halves 
            merge(arr, l, m, r); 
        } 
    } 
  
	    public static void main(String[] args) {
	    Scanner scan = new Scanner(System.in);
	    int a = Integer.parseInt(scan.nextLine());
	    String[] x = new String[a];
	    for (int i = 0; i < a; i++) {
	    	x[i] = scan.nextLine();
	    }
	    if (x.length == 1) {
	    System.out.println(1);
	    }
	    else if (x.length == 2) {
	    	if(x[0].compareTo(x[1]) == 0) {System.out.println(1);}
	    	else {System.out.println(2);}
	    }
	    else {
	    sort(x, 0, x.length - 1);
	    int ans = 0;
	    for (int i = 1; i < a; i++) {
	    	if (x[i].compareTo(x[i - 1]) != 0) {
	    		ans += 1;
	    	}
	    }
	    System.out.println(ans + 1);
	    }
}
	    }
