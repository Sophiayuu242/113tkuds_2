import java.util.*;

public class BSTKthElement {
    static class Node {
        int val;
        Node left, right;
        Node(int v) { val = v; }
    }

    static class BST {
        Node root;

        public void insert(int val) {
            root = insert(root, val);
        }

        private Node insert(Node node, int val) {
            if (node == null) return new Node(val);
            if (val < node.val) node.left = insert(node.left, val);
            else node.right = insert(node.right, val);
            return node;
        }

        public int kthSmallest(int k) {
            List<Integer> list = new ArrayList<>();
            inorder(root, list);
            return list.get(k - 1);
        }

        public int kthLargest(int k) {
            List<Integer> list = new ArrayList<>();
            inorder(root, list);
            return list.get(list.size() - k);
        }

        public List<Integer> rangeQuery(int k1, int k2) {
            List<Integer> result = new ArrayList<>();
            inorder(root, result);
            List<Integer> range = new ArrayList<>();
            for (int x : result) {
                if (x >= k1 && x <= k2) range.add(x);
            }
            return range;
        }

        private void inorder(Node node, List<Integer> list) {
            if (node == null) return;
            inorder(node.left, list);
            list.add(node.val);
            inorder(node.right, list);
        }

        public void delete(int key) {
            root = delete(root, key);
        }

        private Node delete(Node node, int key) {
            if (node == null) return null;
            if (key < node.val) node.left = delete(node.left, key);
            else if (key > node.val) node.right = delete(node.right, key);
            else {
                if (node.left == null) return node.right;
                if (node.right == null) return node.left;
                Node min = getMin(node.right);
                node.val = min.val;
                node.right = delete(node.right, min.val);
            }
            return node;
        }

        private Node getMin(Node node) {
            while (node.left != null) node = node.left;
            return node;
        }
    }

    public static void main(String[] args) {
        BST tree = new BST();
        int[] data = {20, 8, 22, 4, 12, 10, 14};
        for (int val : data) tree.insert(val);

        System.out.println("第3小元素: " + tree.kthSmallest(3));
        System.out.println("第2大元素: " + tree.kthLargest(2));
        System.out.println("第3到第5小元素: " + tree.rangeQuery(10, 20));

        tree.insert(6);
        tree.delete(10);
        System.out.println("插入6後，刪除10，再查第3小: " + tree.kthSmallest(3));
    }
}