public class MatrixCalculator {
    public static void main(String[] args) {
        int[][] A = {
            {1, 2, 3},
            {4, 5, 6}
        };
        int[][] B = {
            {7, 8, 9},
            {10, 11, 12}
        };
        int[][] C = {
            {1, 2},
            {3, 4},
            {5, 6}
        };

        System.out.println("矩陣加法:");
        printMatrix(addMatrix(A, B));

        System.out.println("矩陣乘法:");
        printMatrix(multiplyMatrix(A, C));

        System.out.println("矩陣轉置:");
        printMatrix(transposeMatrix(A));

        System.out.println("矩陣最大最小值:");
        int[] result = findMaxMin(A);
        System.out.println("最大值: " + result[0]);
        System.out.println("最小值: " + result[1]);
    }

    public static int[][] addMatrix(int[][] a, int[][] b) {
        int[][] result = new int[a.length][a[0].length];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                result[i][j] = a[i][j] + b[i][j];
            }
        }
        return result;
    }

    public static int[][] multiplyMatrix(int[][] a, int[][] b) {
        int rows = a.length;
        int cols = b[0].length;
        int common = b.length;
        int[][] result = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                for (int k = 0; k < common; k++) {
                    result[i][j] += a[i][k] * b[k][j];
                }
            }
        }
        return result;
    }

    public static int[][] transposeMatrix(int[][] m) {
        int[][] result = new int[m[0].length][m.length];
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[0].length; j++) {
                result[j][i] = m[i][j];
            }
        }
        return result;
    }

    public static int[] findMaxMin(int[][] m) {
        int max = m[0][0];
        int min = m[0][0];
        for (int[] row : m) {
            for (int val : row) {
                if (val > max) max = val;
                if (val < min) min = val;
            }
        }
        return new int[]{max, min};
    }

    public static void printMatrix(int[][] m) {
        for (int[] row : m) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }
}