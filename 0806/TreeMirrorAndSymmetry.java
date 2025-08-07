public class TreeMirrorAndSymmetry {
    static class Node {
        int val;
        Node left, right;
        Node(int v) { val = v; }
    }

    public static boolean isSymmetric(Node root) {
        if (root == null) return true;
        return isMirror(root.left, root.right);
    }

    public static boolean isMirror(Node a, Node b) {
        if (a == null && b == null) return true;
        if (a == null || b == null) return false;
        return a.val == b.val && isMirror(a.left, b.right) && isMirror(a.right, b.left);
    }

    public static Node mirrorTree(Node root) {
        if (root == null) return null;
        Node temp = root.left;
        root.left = mirrorTree(root.right);
        root.right = mirrorTree(temp);
        return root;
    }

    public static boolean areMirror(Node a, Node b) {
        if (a == null && b == null) return true;
        if (a == null || b == null) return false;
        return a.val == b.val && areMirror(a.left, b.right) && areMirror(a.right, b.left);
    }

    public static boolean isSubtree(Node main, Node sub) {
        if (main == null) return false;
        if (isSameTree(main, sub)) return true;
        return isSubtree(main.left, sub) || isSubtree(main.right, sub);
    }

    public static boolean isSameTree(Node a, Node b) {
        if (a == null && b == null) return true;
        if (a == null || b == null) return false;
        return a.val == b.val && isSameTree(a.left, b.left) && isSameTree(a.right, b.right);
    }

    public static void inorder(Node root) {
        if (root != null) {
            inorder(root.left);
            System.out.print(root.val + " ");
            inorder(root.right);
        }
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(2);
        root.left.left = new Node(3);
        root.left.right = new Node(4);
        root.right.left = new Node(4);
        root.right.right = new Node(3);

        System.out.println("對稱樹: " + isSymmetric(root));

        Node mirror = mirrorTree(root);
        inorder(mirror);
        System.out.println();

        Node a = new Node(1);
        a.left = new Node(2);
        a.right = new Node(3);
        Node b = new Node(1);
        b.left = new Node(3);
        b.right = new Node(2);
        System.out.println("是否互為鏡像: " + areMirror(a, b));

        Node sub = new Node(2);
        sub.left = new Node(4);
        sub.right = new Node(3);
        System.out.println("是否為子樹: " + isSubtree(root, sub));
    }
}