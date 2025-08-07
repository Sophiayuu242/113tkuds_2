import java.util.*;

public class TreeReconstruction {
    static class Node {
        int val;
        Node left, right;
        Node(int v) { val = v; }
    }

    public static Node buildFromPreIn(int[] preorder, int[] inorder) {
        Map<Integer, Integer> inMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) inMap.put(inorder[i], i);
        return helperPreIn(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1, inMap);
    }

    private static Node helperPreIn(int[] pre, int ps, int pe, int[] in, int is, int ie, Map<Integer, Integer> inMap) {
        if (ps > pe || is > ie) return null;
        Node root = new Node(pre[ps]);
        int ri = inMap.get(pre[ps]);
        int leftSize = ri - is;
        root.left = helperPreIn(pre, ps + 1, ps + leftSize, in, is, ri - 1, inMap);
        root.right = helperPreIn(pre, ps + leftSize + 1, pe, in, ri + 1, ie, inMap);
        return root;
    }

    public static Node buildFromPostIn(int[] postorder, int[] inorder) {
        Map<Integer, Integer> inMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) inMap.put(inorder[i], i);
        return helperPostIn(postorder, 0, postorder.length - 1, inorder, 0, inorder.length - 1, inMap);
    }

    private static Node helperPostIn(int[] post, int ps, int pe, int[] in, int is, int ie, Map<Integer, Integer> inMap) {
        if (ps > pe || is > ie) return null;
        Node root = new Node(post[pe]);
        int ri = inMap.get(post[pe]);
        int leftSize = ri - is;
        root.left = helperPostIn(post, ps, ps + leftSize - 1, in, is, ri - 1, inMap);
        root.right = helperPostIn(post, ps + leftSize, pe - 1, in, ri + 1, ie, inMap);
        return root;
    }

    public static Node buildFromLevel(int[] level) {
        if (level.length == 0) return null;
        Node root = new Node(level[0]);
        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        int i = 1;
        while (i < level.length) {
            Node curr = q.poll();
            if (i < level.length) {
                curr.left = new Node(level[i++]);
                q.offer(curr.left);
            }
            if (i < level.length) {
                curr.right = new Node(level[i++]);
                q.offer(curr.right);
            }
        }
        return root;
    }

    public static void inorderPrint(Node node) {
        if (node == null) return;
        inorderPrint(node.left);
        System.out.print(node.val + " ");
        inorderPrint(node.right);
    }

    public static void main(String[] args) {
        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};
        int[] postorder = {9, 15, 7, 20, 3};
        int[] level = {3, 9, 20, 15, 7};

        Node preInTree = buildFromPreIn(preorder, inorder);
        Node postInTree = buildFromPostIn(postorder, inorder);
        Node levelTree = buildFromLevel(level);

        System.out.print("前序+中序重建中序遍歷: ");
        inorderPrint(preInTree);
        System.out.println();

        System.out.print("後序+中序重建中序遍歷: ");
        inorderPrint(postInTree);
        System.out.println();

        System.out.print("層序重建中序遍歷: ");
        inorderPrint(levelTree);
        System.out.println();
    }
}