import java.util.*;
public class M01_BuildHeap {
    static boolean isMaxHeap;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String type = sc.next(); 
        isMaxHeap = type.equals("max");

        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        buildHeap(arr, n);

        for (int i = 0; i < n; i++) {
            System.out.print(arr[i]);
            if (i < n - 1) System.out.print(" ");
        }
    }

    static void buildHeap(int[] arr, int n) {
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }
    }

    static void heapify(int[] arr, int n, int i) {
        int extreme = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < n && compare(arr[left], arr[extreme])) {
            extreme = left;
        }
        if (right < n && compare(arr[right], arr[extreme])) {
            extreme = right;
        }

        if (extreme != i) {
            int temp = arr[i];
            arr[i] = arr[extreme];
            arr[extreme] = temp;

            heapify(arr, n, extreme);
        }
    }

    static boolean compare(int a, int b) {
        if (isMaxHeap) return a > b;  
        else return a < b;      
    }
}

/*
 * Time Complexity: O(n)
 * 說明：
 * 1. heapify 單次操作最差 O(log n)，但自底向上建堆只需 O(n)。
 * 2. 證明：n/2 節點高度分佈為 (n/4 × 1 + n/8 × 2 + …) = O(n)。
 * 3. 因此整體建堆複雜度為 O(n)，比逐一 insert O(n log n) 更快。
 */