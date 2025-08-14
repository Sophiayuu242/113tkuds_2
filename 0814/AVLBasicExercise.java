public class AVLBasicExercise {
    static class Node {
        int val, height;
        Node left, right;
        Node(int v) { val = v; height = 1; }
    }
    Node root;

    int height(Node n) { return n == null ? 0 : n.height; }

    int balance(Node n) { return n == null ? 0 : height(n.left) - height(n.right); }

    Node rotateRight(Node y) {
        Node x = y.left, T2 = x.right;
        x.right = y; y.left = T2;
        y.height = Math.max(height(y.left), height(y.right)) + 1;
        x.height = Math.max(height(x.left), height(x.right)) + 1;
        return x;
    }

    Node rotateLeft(Node x) {
        Node y = x.right, T2 = y.left;
        y.left = x; x.right = T2;
        x.height = Math.max(height(x.left), height(x.right)) + 1;
        y.height = Math.max(height(y.left), height(y.right)) + 1;
        return y;
    }

    Node insert(Node n, int v) {
        if (n == null) return new Node(v);
        if (v < n.val) n.left = insert(n.left, v);
        else if (v > n.val) n.right = insert(n.right, v);
        else return n;
        n.height = 1 + Math.max(height(n.left), height(n.right));
        int b = balance(n);
        if (b > 1 && v < n.left.val) return rotateRight(n);
        if (b < -1 && v > n.right.val) return rotateLeft(n);
        if (b > 1 && v > n.left.val) { n.left = rotateLeft(n.left); return rotateRight(n); }
        if (b < -1 && v < n.right.val) { n.right = rotateRight(n.right); return rotateLeft(n); }
        return n;
    }

    void insert(int v) { root = insert(root, v); }

    boolean search(Node n, int v) {
        if (n == null) return false;
        if (n.val == v) return true;
        return v < n.val ? search(n.left, v) : search(n.right, v);
    }

    boolean search(int v) { return search(root, v); }

    int height() { return height(root); }

    boolean isAVL(Node n) {
        if (n == null) return true;
        int l = height(n.left), r = height(n.right);
        if (Math.abs(l - r) > 1) return false;
        return isAVL(n.left) && isAVL(n.right);
    }

    boolean isAVL() { return isAVL(root); }

    public static void main(String[] args) {
        AVLBasicExercise t = new AVLBasicExercise();
        int[] arr = {10,20,30,40,50,25};
        for (int x: arr) t.insert(x);
        System.out.println(t.search(25));
        System.out.println(t.height());
        System.out.println(t.isAVL());
    }
}
