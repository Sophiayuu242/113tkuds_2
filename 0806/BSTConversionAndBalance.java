public class BSTConversionAndBalance {
    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int v) { val = v; }
    }

    static TreeNode prev = null;
    static TreeNode head = null;

    public static TreeNode bstToDoublyList(TreeNode root) {
        prev = null;
        head = null;
        convert(root);
        return head;
    }

    private static void convert(TreeNode node) {
        if (node == null) return;
        convert(node.left);
        if (prev != null) {
            prev.right = node;
            node.left = prev;
        } else {
            head = node;
        }
        prev = node;
        convert(node.right);
    }

    public static TreeNode sortedArrayToBST(int[] nums) {
        return buildBST(nums, 0, nums.length - 1);
    }

    private static TreeNode buildBST(int[] arr, int l, int r) {
        if (l > r) return null;
        int m = (l + r) / 2;
        TreeNode node = new TreeNode(arr[m]);
        node.left = buildBST(arr, l, m - 1);
        node.right = buildBST(arr, m + 1, r);
        return node;
    }

    public static boolean isBalanced(TreeNode root) {
        return check(root) != -1;
    }

    private static int check(TreeNode node) {
        if (node == null) return 0;
        int lh = check(node.left);
        if (lh == -1) return -1;
        int rh = check(node.right);
        if (rh == -1) return -1;
        if (Math.abs(lh - rh) > 1) return -1;
        return Math.max(lh, rh) + 1;
    }

    static int sum = 0;
    public static void convertToGreaterTree(TreeNode root) {
        sum = 0;
        convertGreater(root);
    }

    private static void convertGreater(TreeNode node) {
        if (node == null) return;
        convertGreater(node.right);
        sum += node.val;
        node.val = sum;
        convertGreater(node.left);
    }

    public static void inorder(TreeNode node) {
        if (node == null) return;
        inorder(node.left);
        System.out.print(node.val + " ");
        inorder(node.right);
    }

    public static void main(String[] args) {
        int[] sorted = {1, 2, 3, 4, 5, 6, 7};
        TreeNode bst = sortedArrayToBST(sorted);

        System.out.print("BST 中序遍歷: ");
        inorder(bst);
        System.out.println();

        System.out.println("是否平衡: " + isBalanced(bst));

        convertToGreaterTree(bst);
        System.out.print("轉換為 Greater Tree 後中序遍歷: ");
        inorder(bst);
        System.out.println();

        TreeNode doublyList = bstToDoublyList(bst);
        System.out.print("轉換為雙向鏈結串列: ");
        TreeNode curr = doublyList;
        while (curr != null) {
            System.out.print(curr.val + " ");
            curr = curr.right;
        }
        System.out.println();
    }
}
