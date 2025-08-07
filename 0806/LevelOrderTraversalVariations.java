import java.util.*;

public class LevelOrderTraversalVariations {
    static class Node {
        int val;
        Node left, right;
        Node(int v) { val = v; }
    }

    public static List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> level = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                Node node = queue.poll();
                level.add(node.val);
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
            result.add(level);
        }
        return result;
    }

    public static List<List<Integer>> zigzagLevelOrder(Node root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;
        Queue<Node> queue = new LinkedList<>();
        boolean leftToRight = true;
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            LinkedList<Integer> level = new LinkedList<>();
            for (int i = 0; i < size; i++) {
                Node node = queue.poll();
                if (leftToRight) level.addLast(node.val);
                else level.addFirst(node.val);
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
            leftToRight = !leftToRight;
            result.add(level);
        }
        return result;
    }

    public static List<Integer> rightMostEachLevel(Node root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            Node last = null;
            for (int i = 0; i < size; i++) {
                Node node = queue.poll();
                last = node;
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
            result.add(last.val);
        }
        return result;
    }

    public static Map<Integer, List<Integer>> verticalOrder(Node root) {
        Map<Integer, List<Integer>> map = new TreeMap<>();
        if (root == null) return map;
        Queue<Node> queue = new LinkedList<>();
        Queue<Integer> cols = new LinkedList<>();
        queue.offer(root);
        cols.offer(0);
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            int col = cols.poll();
            map.computeIfAbsent(col, k -> new ArrayList<>()).add(node.val);
            if (node.left != null) {
                queue.offer(node.left);
                cols.offer(col - 1);
            }
            if (node.right != null) {
                queue.offer(node.right);
                cols.offer(col + 1);
            }
        }
        return map;
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        System.out.println("每層分開儲存: " + levelOrder(root));
        System.out.println("Z字形層序: " + zigzagLevelOrder(root));
        System.out.println("每層最後一個: " + rightMostEachLevel(root));
        System.out.println("垂直層序: " + verticalOrder(root));
    }
}