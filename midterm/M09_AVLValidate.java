import java.util.*;

public class M09_AVLValidate {
    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int v) { val = v; }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = sc.nextInt();

        TreeNode root = buildTree(arr);

        if (!isBST(root, Long.MIN_VALUE, Long.MAX_VALUE)) {
            System.out.println("Invalid BST");
            return;
        }

        if (checkAVL(root) == -1) {
            System.out.println("Invalid AVL");
            return;
        }

        System.out.println("Valid");
    }

    private static TreeNode buildTree(int[] arr) {
        if (arr.length == 0 || arr[0] == -1) return null;
        TreeNode root = new TreeNode(arr[0]);
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int i = 1;
        while (!q.isEmpty() && i < arr.length) {
            TreeNode node = q.poll();
            if (i < arr.length && arr[i] != -1) {
                node.left = new TreeNode(arr[i]);
                q.add(node.left);
            }
            i++;
            if (i < arr.length && arr[i] != -1) {
                node.right = new TreeNode(arr[i]);
                q.add(node.right);
            }
            i++;
        }
        return root;
    }

    private static boolean isBST(TreeNode node, long min, long max) {
        if (node == null) return true;
        if (node.val <= min || node.val >= max) return false;
        return isBST(node.left, min, node.val) && isBST(node.right, node.val, max);
    }

    private static int checkAVL(TreeNode node) {
        if (node == null) return 0;
        int lh = checkAVL(node.left);
        if (lh == -1) return -1;
        int rh = checkAVL(node.right);
        if (rh == -1) return -1;

        if (Math.abs(lh - rh) > 1) return -1; // 平衡因子超過 1
        return Math.max(lh, rh) + 1;
    }
}

/*
 * Time Complexity: O(n)
 * 說明：
 * - 檢查 BST：每個節點訪問一次，O(n)。
 * - 檢查 AVL：每個節點後序遍歷一次，計算高度並驗證平衡，O(n)。
 * - 總合為 O(n)。
 */