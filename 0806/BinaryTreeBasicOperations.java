import java.util.*;

public class BinaryTreeBasicOperations {
    static class Node {
        int val;
        Node left, right;
        Node(int v) { val = v; }
    }

    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(5);
        root.right = new Node(20);
        root.left.left = new Node(3);
        root.left.right = new Node(7);
        root.right.right = new Node(30);

        int sum = sumNodes(root);
        int count = countNodes(root);
        System.out.println("節點總和: " + sum);
        System.out.println("平均值: " + (sum * 1.0 / count));
        System.out.println("最大值: " + maxNode(root));
        System.out.println("最小值: " + minNode(root));
        System.out.println("樹寬度: " + treeWidth(root));
        System.out.println("是否完全二元樹: " + isComplete(root));
    }

    public static int sumNodes(Node root) {
        if (root == null) return 0;
        return root.val + sumNodes(root.left) + sumNodes(root.right);
    }

    public static int countNodes(Node root) {
        if (root == null) return 0;
        return 1 + countNodes(root.left) + countNodes(root.right);
    }

    public static int maxNode(Node root) {
        if (root == null) return Integer.MIN_VALUE;
        return Math.max(root.val, Math.max(maxNode(root.left), maxNode(root.right)));
    }

    public static int minNode(Node root) {
        if (root == null) return Integer.MAX_VALUE;
        return Math.min(root.val, Math.min(minNode(root.left), minNode(root.right)));
    }

    public static int treeWidth(Node root) {
        if (root == null) return 0;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        int maxWidth = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            maxWidth = Math.max(maxWidth, size);
            for (int i = 0; i < size; i++) {
                Node curr = queue.poll();
                if (curr.left != null) queue.add(curr.left);
                if (curr.right != null) queue.add(curr.right);
            }
        }
        return maxWidth;
    }

    public static boolean isComplete(Node root) {
        if (root == null) return true;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        boolean end = false;
        while (!queue.isEmpty()) {
            Node curr = queue.poll();
            if (curr == null) {
                end = true;
            } else {
                if (end) return false;
                queue.add(curr.left);
                queue.add(curr.right);
            }
        }
        return true;
    }
}
