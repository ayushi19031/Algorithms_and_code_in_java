import java.util.*;
// Implementation of merge sort in java.
// function take an array as an input and returns after sorting it using merge sort.
public class Xyz_12 {
    public static void swap(float[] b3,int[] b1, int[] b2, int a, int b){
        int temp = b1[a];
        b1[a] = b1[b];
        b1[b] = temp;
        temp = b2[a];
        b2[a] = b2[b];
        b2[b] = temp;
        float tempx = b3[a];
        b3[a] = b3[b];
        b3[b] = tempx;
    }
    public static void merge(float[] xx ,int[] b, int[] c, int s, int mid, int e){
        float[] Lx = new float[mid - s + 1];
        int[] Lb = new int[mid - s + 1];
        int[] Lc = new int[mid - s + 1];
        int[] Rb = new int[e - mid];int[] Rc = new int[e - mid];
        float[] Rx = new float[e - mid];
        for (int i = 0; i < mid - s + 1; i++){
            Lx[i] = xx[s + i];
            Lb[i] = b[s + i];
            Lc[i] = c[s + i];
        }
        for (int i = 0; i < e - mid; i++){
            Rx[i] = xx[mid + i + 1];
            Rb[i] = b[mid + i + 1];
            Rc[i] = c[mid + i + 1];
        } 
        int l = 0; int r = 0; int i =s;
       while (l < mid - s + 1 && r < e - mid) {
        if (Lx[l] <= Rx[r]) {xx[i] = Lx[l]; b[i] = Lb[l];c[i] = Lc[l]; l += 1; i += 1;}
        else if (Lx[l] > Rx[r]) {xx[i] = Rx[r]; b[i] = Rb[r]; c[i] = Rc[r]; r += 1; i += 1;}}
        
            while (l < mid - s + 1){
                xx[i] = Lx[l];b[i] = Lb[l]; c[i] = Lc[l]; l += 1; i += 1;
            }
            while (r < e - mid){xx[i] = Rx[r]; b[i] = Rb[r]; c[i] = Rc[r]; r += 1; i += 1;}
    }
    public static void MergeSort(int[] b, int[] c, float[] xx,  int s, int e){
    if (e - s == 1){
        if (xx[s] > xx[e])
        {swap(xx, b,c, s, e);}
    }
    else if (e - s > 1){
        int mid = (s + e)/2;
        MergeSort(b, c, xx,  s, mid); MergeSort(b, c, xx,   mid + 1, e);
        merge(xx, b, c, s, mid, e);
    }
}
public static float funMax(int[] b, int[] c, int s, int e){
    float mini = Float.MIN_VALUE;
    for (int i = s; i <e  ; i++){
        float kk = (float) c[i]/b[i];
        if (kk > mini){
            mini = kk;
        }
    }
    return mini;
}
public static float funT(int[] b, int[] c, int s, int e){
    float mini = Float.MIN_VALUE;
    for (int i = s; i < e; i++){
        float rk = (float) c[i]/b[i];
        //System.out.println("RK: " + rk);
        boolean fg = true;
        for (int j = s; j< e; j++){
            if (rk*b[j] < c[j]){
                fg = false;
                break;
            }
        }
        if (fg == true){
          //  System.out.println(rk);
            return rk;
            
        }
    }
    return 0;
}
public static float funSum(int[] b, int[] c, int s, int e, float maxi){
    float ans = 0;
    for (int i = s; i <e  ; i++){
        if (maxi * b[i] > c[i]){
            ans += maxi*b[i];
        }
        else {
            ans += c[i];
        }
    }
    return ans;
}
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in); 
        int n = scan.nextInt();
        int k = scan.nextInt();
        int[] b = new int[n];
        int[] c = new int[n];
        float[] rr = new float[n];
        for (int i = 0; i < n; i++){
            b[i] = scan.nextInt();
        }
        for (int i = 0; i < n; i++){
            c[i] = scan.nextInt();
            rr[i] = (float) c[i]/b[i];
        }
        float mini = Float.MAX_VALUE;
        MergeSort(b, c, rr,  0, n - 1);
      // System.out.println(Arrays.toString(rr));
    //    System.out.println(Arrays.toString(b));

      //  System.out.println(Arrays.toString(c));
            for (int i = 0; i < n - k + 1; i++){
            
            float maxi = funT(b, c, i, i+ k);
        //    System.out.println(maxi);
            float ans =    funSum(b, c, i, i + k, maxi);
        //    System.out.println(ans);
            if (ans < mini){
                mini = ans;
            }
            }
        int y = (int) Math.round(mini);
        if (y >= mini){
        System.out.println(y);}
        else{
            System.out.println(y + 1);
        }
    }
    }
