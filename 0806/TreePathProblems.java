import java.util.*;

public class TreePathProblems {
    static class Node {
        int val;
        Node left, right;
        Node(int v) { val = v; }
    }

    public static List<List<Integer>> allPaths(Node root) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        dfs(root, path, result);
        return result;
    }

    private static void dfs(Node node, List<Integer> path, List<List<Integer>> result) {
        if (node == null) return;
        path.add(node.val);
        if (node.left == null && node.right == null) result.add(new ArrayList<>(path));
        else {
            dfs(node.left, path, result);
            dfs(node.right, path, result);
        }
        path.remove(path.size() - 1);
    }

    public static boolean hasPathSum(Node node, int target) {
        if (node == null) return false;
        if (node.left == null && node.right == null) return node.val == target;
        return hasPathSum(node.left, target - node.val) || hasPathSum(node.right, target - node.val);
    }

    public static int maxRootToLeafSum(Node node) {
        if (node == null) return 0;
        if (node.left == null && node.right == null) return node.val;
        return node.val + Math.max(maxRootToLeafSum(node.left), maxRootToLeafSum(node.right));
    }

    static int maxSum = Integer.MIN_VALUE;

    public static int maxPathSum(Node root) {
        maxSum = Integer.MIN_VALUE;
        maxPathDown(root);
        return maxSum;
    }

    private static int maxPathDown(Node node) {
        if (node == null) return 0;
        int left = Math.max(0, maxPathDown(node.left));
        int right = Math.max(0, maxPathDown(node.right));
        maxSum = Math.max(maxSum, left + right + node.val);
        return node.val + Math.max(left, right);
    }

    public static void main(String[] args) {
        Node root = new Node(5);
        root.left = new Node(4);
        root.right = new Node(8);
        root.left.left = new Node(11);
        root.left.left.left = new Node(7);
        root.left.left.right = new Node(2);
        root.right.left = new Node(13);
        root.right.right = new Node(4);
        root.right.right.right = new Node(1);

        System.out.println("所有根到葉路徑:");
        for (List<Integer> path : allPaths(root)) System.out.println(path);

        System.out.println("是否有和為22的路徑: " + hasPathSum(root, 22));
        System.out.println("最大根到葉路徑和: " + maxRootToLeafSum(root));
        System.out.println("樹的直徑（最大任意兩點間路徑和）: " + maxPathSum(root));
    }
}