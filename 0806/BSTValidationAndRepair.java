
public class BSTValidationAndRepair {
    static class Node {
        int val;
        Node left, right;
        Node(int v) { val = v; }
    }

    public static boolean isValidBST(Node root) {
        return validate(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public static boolean validate(Node node, long min, long max) {
        if (node == null) return true;
        if (node.val <= min || node.val >= max) return false;
        return validate(node.left, min, node.val) && validate(node.right, node.val, max);
    }

    static Node first, second, prev;

    public static void recoverTree(Node root) {
        first = second = prev = null;
        inorder(root);
        if (first != null && second != null) {
            int temp = first.val;
            first.val = second.val;
            second.val = temp;
        }
    }

    public static void inorder(Node node) {
        if (node == null) return;
        inorder(node.left);
        if (prev != null && prev.val > node.val) {
            if (first == null) first = prev;
            second = node;
        }
        prev = node;
        inorder(node.right);
    }

    public static int countInvalidNodes(Node root) {
        return countInvalidNodesHelper(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public static int countInvalidNodesHelper(Node node, long min, long max) {
        if (node == null) return 0;
        int count = 0;
        if (node.val <= min || node.val >= max) count = 1;
        return count + countInvalidNodesHelper(node.left, min, node.val) + countInvalidNodesHelper(node.right, node.val, max);
    }

    public static void inorderPrint(Node node) {
        if (node == null) return;
        inorderPrint(node.left);
        System.out.print(node.val + " ");
        inorderPrint(node.right);
    }

    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(5);
        root.right = new Node(15);
        root.right.left = new Node(20); // 錯誤節點
        root.right.right = new Node(6); // 錯誤節點

        System.out.println("是否為有效BST: " + isValidBST(root));
        System.out.println("錯誤節點數: " + countInvalidNodes(root));
        recoverTree(root);
        System.out.println("修復後是否有效BST: " + isValidBST(root));
        System.out.print("中序遍歷: ");
        inorderPrint(root);
    }
}