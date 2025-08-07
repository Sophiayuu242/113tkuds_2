public class RecursionVsIteration {
    public static void main(String[] args) {
        int n = 5;
        int[] arr = {1, 2, 3, 4, 5};
        String s = "Hello World";

        System.out.println("二項式係數 C(" + n + ", 3):");
        System.out.println("遞迴: " + binomialRecursive(n, 3));
        System.out.println("迭代: " + binomialIterative(n, 3));

        System.out.println("陣列所有元素乘積:");
        System.out.println("遞迴: " + productRecursive(arr, 0));
        System.out.println("迭代: " + productIterative(arr));

        System.out.println("字串中元音數量:");
        System.out.println("遞迴: " + countVowelsRecursive(s, 0));
        System.out.println("迭代: " + countVowelsIterative(s));

        String brackets1 = "()()";
        String brackets2 = "(()))";

        System.out.println("括號配對檢查:");
        System.out.println("遞迴 (\"" + brackets1 + "\"): " + isBalancedRecursive(brackets1, 0, 0));
        System.out.println("遞迴 (\"" + brackets2 + "\"): " + isBalancedRecursive(brackets2, 0, 0));
        System.out.println("迭代 (\"" + brackets1 + "\"): " + isBalancedIterative(brackets1));
        System.out.println("迭代 (\"" + brackets2 + "\"): " + isBalancedIterative(brackets2));
    }

    // 二項式係數遞迴
    public static int binomialRecursive(int n, int k) {
        if (k == 0 || k == n) return 1;
        return binomialRecursive(n - 1, k - 1) + binomialRecursive(n - 1, k);
    }

    // 二項式係數迭代（使用動態規劃）
    public static int binomialIterative(int n, int k) {
        int[][] C = new int[n + 1][k + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= Math.min(i, k); j++) {
                if (j == 0 || j == i) C[i][j] = 1;
                else C[i][j] = C[i - 1][j - 1] + C[i - 1][j];
            }
        }
        return C[n][k];
    }

    // 陣列乘積遞迴
    public static int productRecursive(int[] arr, int index) {
        if (index == arr.length) return 1;
        return arr[index] * productRecursive(arr, index + 1);
    }

    // 陣列乘積迭代
    public static int productIterative(int[] arr) {
        int prod = 1;
        for (int val : arr) prod *= val;
        return prod;
    }

    // 字串元音數量遞迴
    public static int countVowelsRecursive(String s, int index) {
        if (index == s.length()) return 0;
        char c = Character.toLowerCase(s.charAt(index));
        int count = (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') ? 1 : 0;
        return count + countVowelsRecursive(s, index + 1);
    }

    // 字串元音數量迭代
    public static int countVowelsIterative(String s) {
        int count = 0;
        for (char c : s.toLowerCase().toCharArray()) {
            if ("aeiou".indexOf(c) >= 0) count++;
        }
        return count;
    }

    // 括號配對遞迴
    public static boolean isBalancedRecursive(String s, int index, int count) {
        if (count < 0) return false;
        if (index == s.length()) return count == 0;

        char c = s.charAt(index);
        if (c == '(') return isBalancedRecursive(s, index + 1, count + 1);
        else if (c == ')') return isBalancedRecursive(s, index + 1, count - 1);
        else return isBalancedRecursive(s, index + 1, count);
    }

    // 括號配對迭代
    public static boolean isBalancedIterative(String s) {
        int count = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') count++;
            else if (c == ')') count--;
            if (count < 0) return false;
        }
        return count == 0;
    }
}