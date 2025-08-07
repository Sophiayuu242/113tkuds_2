import java.util.Arrays;

public class SelectionSortImplementation {
    public static void main(String[] args) {
        int[] arr = {64, 25, 12, 22, 11};
        System.out.println("原始陣列: " + Arrays.toString(arr));
        int comparisons = 0;
        int swaps = 0;

        for (int i = 0; i < arr.length - 1; i++) {
            int minIdx = i;
            for (int j = i + 1; j < arr.length; j++) {
                comparisons++;
                if (arr[j] < arr[minIdx]) {
                    minIdx = j;
                }
            }

            if (minIdx != i) {
                int temp = arr[i];
                arr[i] = arr[minIdx];
                arr[minIdx] = temp;
                swaps++;
            }

            System.out.println("第 " + (i + 1) + " 輪排序結果: " + Arrays.toString(arr));
        }

        System.out.println("總比較次數: " + comparisons);
        System.out.println("總交換次數: " + swaps);
    }
}