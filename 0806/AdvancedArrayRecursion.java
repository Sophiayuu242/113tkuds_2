import java.util.Arrays;

public class AdvancedArrayRecursion {
    public static void main(String[] args) {
        int[] arr = {9, 3, 7, 1, 5, 4};
        quickSort(arr, 0, arr.length - 1);
        System.out.println("快速排序: " + Arrays.toString(arr));

        int[] sorted1 = {1, 3, 5};
        int[] sorted2 = {2, 4, 6};
        int[] merged = merge(sorted1, sorted2, 0, 0, new int[sorted1.length + sorted2.length], 0);
        System.out.println("遞迴合併: " + Arrays.toString(merged));

        int[] kArr = {7, 2, 9, 1, 4};
        System.out.println("第 3 小元素: " + kthSmallest(kArr, 3));

        int[] targetArr = {3, 2, 1, 4};
        System.out.println("是否存在子序列和為 6: " + hasSubsetSum(targetArr, 0, 6));
    }

    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pivotIdx = partition(arr, low, high);
            quickSort(arr, low, pivotIdx - 1);
            quickSort(arr, pivotIdx + 1, high);
        }
    }

    public static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low;
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                int tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;
                i++;
            }
        }
        int tmp = arr[i];
        arr[i] = arr[high];
        arr[high] = tmp;
        return i;
    }

    public static int[] merge(int[] a, int[] b, int i, int j, int[] result, int k) {
        if (i == a.length) {
            while (j < b.length) result[k++] = b[j++];
            return result;
        }
        if (j == b.length) {
            while (i < a.length) result[k++] = a[i++];
            return result;
        }
        if (a[i] <= b[j]) {
            result[k] = a[i];
            return merge(a, b, i + 1, j, result, k + 1);
        } else {
            result[k] = b[j];
            return merge(a, b, i, j + 1, result, k + 1);
        }
    }

    public static int kthSmallest(int[] arr, int k) {
        quickSort(arr, 0, arr.length - 1);
        return arr[k - 1];
    }

    public static boolean hasSubsetSum(int[] arr, int index, int target) {
        if (target == 0) return true;
        if (index == arr.length || target < 0) return false;
        return hasSubsetSum(arr, index + 1, target - arr[index]) || hasSubsetSum(arr, index + 1, target);
    }
}
