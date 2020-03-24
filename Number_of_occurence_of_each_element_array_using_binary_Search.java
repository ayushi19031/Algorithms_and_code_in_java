import java.util.*;

public class Mainad {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = input.nextInt();

        }
        int q = input.nextInt();
        for (int i = 0; i < q; i++) {
            int x = input.nextInt();
            int max = max(arr, n, x);
            int min = min(arr, n, x);
            if (min == 10000000 || max ==-1) {
                System.out.println(-1);

            }else{
                System.out.println(max-min+1);


            }
        }

    }

    public static int min(int[] arr, int n, int x) {
        int low = 0;
        int high = n - 1;
        int min = 10000000;
        while (low <= high) {
            int mid = (low + high) / 2;

            if (arr[mid] == x) {
                min = mid;
                low = low;
                high = mid - 1;
            }
            if (arr[mid] > x) {
                low = low;
                high = mid - 1;

            }
            if (arr[mid] < x) {
                high = high;
                low = mid + 1;

            }

        }
        return min;

    }

    public static int max(int[] arr, int n, int x) {
        int low = 0;
        int high = n - 1;
        int max = -1;
        while (low <= high) {
            int mid = (low + high) / 2;

            if (arr[mid] == x) {
                max = mid;
                low = mid + 1;
                high = high;
            }
            if (arr[mid] > x) {
                low = low;
                high = mid - 1;

            }
            if (arr[mid] < x) {
                high = high;
                low = mid + 1;

            }

        }
        return max;

    }


}