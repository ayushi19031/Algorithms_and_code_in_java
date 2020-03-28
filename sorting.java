import java.util.*;
// Implementation of merge sort in java.
// function take an array as an input and returns after sorting it using merge sort.
public class Xyz_12 {
    public static void swap(int[] array, int a, int b){
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }
    public static void merge(int[] array, int s, int mid, int e){
        int[] L = new int[mid - s + 1];
        int[] R = new int[e - mid];
        for (int i = 0; i < mid - s + 1; i++){
            L[i] = array[s + i];
        }
        for (int i = 0; i < e - mid; i++){
            R[i] = array[mid + i + 1];
        } 
        int l = 0; int r = 0; int i =s;
       while (l < mid - s + 1 && r < e - mid) {
        if (L[l] <= R[r]) {array[i] = L[l]; l += 1; i += 1;}
        else if (L[l] > R[r]) {array[i] = R[r]; r += 1; i += 1;}}
        
            while (l < mid - s + 1){
                array[i] = L[l]; l += 1; i += 1;
            }
            while (r < e - mid){array[i] = R[r]; r += 1; i += 1;}
    }
    public static void MergeSort(int[] array ,int s, int e){
    if (e - s == 1){
        if (array[s] > array[e])
        {swap(array, s, e);}
    }
    else if (e - s > 1){
        int mid = (s + e)/2;
        MergeSort(array , s, mid); MergeSort(array, mid + 1, e);
        merge(array, s, mid, e);
    }
}
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in); 
        int a = Integer.parseInt(scan.nextLine());
        String[] b_ = scan.nextLine().split(" ");
        int[] b = new int[a]; 
        for (int i = 0; i < a; i++) {b[i] = Integer.parseInt(b_[i]);}
        MergeSort(b, 0, b.length - 1);
        for (int j = 0; j < b.length; j++) {
            System.out.print(Integer.toString(b[j]) + " ");
}
    }
    }
