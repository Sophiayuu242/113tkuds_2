import java.util.*;

public class NumberArrayProcessor {
    public static void main(String[] args) {
        int[] array1 = {5, 3, 9, 1, 3, 5, 7, 9, 2};
        int[] array2 = {1, 3, 5, 7, 9};
        int[] array3 = {2, 3, 5, 7, 11};

        System.out.println("移除重複元素:");
        int[] noDuplicates = removeDuplicates(array1);
        System.out.println(Arrays.toString(noDuplicates));

        System.out.println("合併兩個排序陣列:");
        int[] merged = mergeSortedArrays(array2, array3);
        System.out.println(Arrays.toString(merged));

        System.out.println("出現頻率最高的元素:");
        int mostFrequent = findMostFrequent(array1);
        System.out.println(mostFrequent);

        System.out.println("分割為兩個子陣列:");
        int[][] split = splitArray(array1);
        System.out.println("子陣列 1: " + Arrays.toString(split[0]));
        System.out.println("子陣列 2: " + Arrays.toString(split[1]));
    }

    public static int[] removeDuplicates(int[] arr) {
        LinkedHashSet<Integer> set = new LinkedHashSet<>();
        for (int n : arr) {
            set.add(n);
        }
        int[] result = new int[set.size()];
        int i = 0;
        for (int n : set) {
            result[i++] = n;
        }
        return result;
    }

    public static int[] mergeSortedArrays(int[] a, int[] b) {
        int[] result = new int[a.length + b.length];
        int i = 0, j = 0, k = 0;
        while (i < a.length && j < b.length) {
            if (a[i] <= b[j]) result[k++] = a[i++];
            else result[k++] = b[j++];
        }
        while (i < a.length) result[k++] = a[i++];
        while (j < b.length) result[k++] = b[j++];
        return result;
    }

    public static int findMostFrequent(int[] arr) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int n : arr) {
            freq.put(n, freq.getOrDefault(n, 0) + 1);
        }
        int maxCount = 0, mostFrequent = arr[0];
        for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
            if (entry.getValue() > maxCount) {
                maxCount = entry.getValue();
                mostFrequent = entry.getKey();
            }
        }
        return mostFrequent;
    }

    public static int[][] splitArray(int[] arr) {
        int total = 0;
        for (int n : arr) total += n;

        int half = total / 2;
        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();

        int currentSum = 0;
        for (int n : arr) {
            if (currentSum + n <= half) {
                left.add(n);
                currentSum += n;
            } else {
                right.add(n);
            }
        }

        int[] a = left.stream().mapToInt(i -> i).toArray();
        int[] b = right.stream().mapToInt(i -> i).toArray();
        return new int[][]{a, b};
    }
}
