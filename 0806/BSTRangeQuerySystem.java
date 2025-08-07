import java.util.*;

public class BSTRangeQuerySystem {
    static class Node {
        int val;
        Node left, right;
        Node(int v) { val = v; }
    }

    Node root;

    public void insert(int val) {
        root = insertRec(root, val);
    }

    private Node insertRec(Node root, int val) {
        if (root == null) return new Node(val);
        if (val < root.val) root.left = insertRec(root.left, val);
        else root.right = insertRec(root.right, val);
        return root;
    }

    public List<Integer> rangeQuery(int min, int max) {
        List<Integer> result = new ArrayList<>();
        rangeQueryRec(root, min, max, result);
        return result;
    }

    private void rangeQueryRec(Node node, int min, int max, List<Integer> res) {
        if (node == null) return;
        if (node.val > min) rangeQueryRec(node.left, min, max, res);
        if (node.val >= min && node.val <= max) res.add(node.val);
        if (node.val < max) rangeQueryRec(node.right, min, max, res);
    }

    public int rangeCount(int min, int max) {
        return rangeQuery(min, max).size();
    }

    public int rangeSum(int min, int max) {
        int sum = 0;
        for (int v : rangeQuery(min, max)) sum += v;
        return sum;
    }

    public int closestValue(int target) {
        return closestValueRec(root, target, root.val);
    }

    private int closestValueRec(Node node, int target, int closest) {
        if (node == null) return closest;
        if (Math.abs(node.val - target) < Math.abs(closest - target)) closest = node.val;
        if (target < node.val) return closestValueRec(node.left, target, closest);
        else return closestValueRec(node.right, target, closest);
    }

    public static void main(String[] args) {
        BSTRangeQuerySystem bst = new BSTRangeQuerySystem();
        int[] vals = {20, 10, 30, 5, 15, 25, 35};
        for (int v : vals) bst.insert(v);

        System.out.println("範圍查詢 [10,30]: " + bst.rangeQuery(10, 30));
        System.out.println("範圍計數 [10,30]: " + bst.rangeCount(10, 30));
        System.out.println("範圍總和 [10,30]: " + bst.rangeSum(10, 30));
        System.out.println("最接近 22 的值: " + bst.closestValue(22));
    }
}
