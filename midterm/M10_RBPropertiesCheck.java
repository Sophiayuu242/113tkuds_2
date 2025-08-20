import java.util.*;

public class M10_RBPropertiesCheck {
    static class Node {
        int val;
        char color; // 'R' or 'B'
        Node left, right;
        Node(int v, char c) { val = v; color = c; }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] nodes = new String[n];
        sc.nextLine(); 
        for (int i = 0; i < n; i++) {
            nodes[i] = sc.nextLine().trim();
        }

        Node root = buildTree(nodes);

        if (root == null) {
            System.out.println("Invalid");
            return;
        }

        if (root.color != 'B') {
            System.out.println("Invalid");
            return;
        }

        if (validate(root).isValid) {
            System.out.println("Valid");
        } else {
            System.out.println("Invalid");
        }
    }

    private static Node buildTree(String[] arr) {
        if (arr.length == 0 || arr[0].equals("-1")) return null;

        String[] rootData = arr[0].split(" ");
        Node root = new Node(Integer.parseInt(rootData[0]), rootData[1].charAt(0));
        Queue<Node> q = new LinkedList<>();
        q.add(root);

        int i = 1;
        while (!q.isEmpty() && i < arr.length) {
            Node node = q.poll();

           
            if (i < arr.length && !arr[i].equals("-1")) {
                String[] parts = arr[i].split(" ");
                node.left = new Node(Integer.parseInt(parts[0]), parts[1].charAt(0));
                q.add(node.left);
            }
            i++;

           
            if (i < arr.length && !arr[i].equals("-1")) {
                String[] parts = arr[i].split(" ");
                node.right = new Node(Integer.parseInt(parts[0]), parts[1].charAt(0));
                q.add(node.right);
            }
            i++;
        }

        return root;
    }

    static class Result {
        boolean isValid;
        int blackHeight;
        Result(boolean v, int h) { isValid = v; blackHeight = h; }
    }

    private static Result validate(Node node) {
        if (node == null) {
            return new Result(true, 1); // null 節點算黑色葉子
        }

        Result left = validate(node.left);
        Result right = validate(node.right);


        if (!left.isValid || !right.isValid) return new Result(false, 0);
        if (node.color == 'R') {
            if ((node.left != null && node.left.color == 'R') ||
                (node.right != null && node.right.color == 'R')) {
                return new Result(false, 0);
            }
        }

        if (left.blackHeight != right.blackHeight) return new Result(false, 0);

        int bh = left.blackHeight + (node.color == 'B' ? 1 : 0);

        return new Result(true, bh);
    }
}

/*
 * Time Complexity: O(n)
 * 說明：
 * - 建樹過程遍歷每個節點一次 O(n)。
 * - 驗證過程：對每個節點做後序遞迴，檢查紅黑性質與黑高度 O(n)。
 * - 總體時間複雜度為 O(n)。
 */