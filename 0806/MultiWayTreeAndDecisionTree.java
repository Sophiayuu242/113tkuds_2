import java.util.*;

public class MultiWayTreeAndDecisionTree {

    static class MultiWayNode {
        String value;
        List<MultiWayNode> children = new ArrayList<>();

        MultiWayNode(String value) {
            this.value = value;
        }
    }

    public static void dfs(MultiWayNode root) {
        if (root == null) return;
        System.out.print(root.value + " ");
        for (MultiWayNode child : root.children) {
            dfs(child);
        }
    }

    public static void bfs(MultiWayNode root) {
        if (root == null) return;
        Queue<MultiWayNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            MultiWayNode node = queue.poll();
            System.out.print(node.value + " ");
            for (MultiWayNode child : node.children) {
                queue.offer(child);
            }
        }
    }

    public static int treeHeight(MultiWayNode root) {
        if (root == null) return 0;
        int max = 0;
        for (MultiWayNode child : root.children) {
            max = Math.max(max, treeHeight(child));
        }
        return max + 1;
    }

    public static void printDegree(MultiWayNode root) {
        if (root == null) return;
        System.out.println(root.value + " 度數: " + root.children.size());
        for (MultiWayNode child : root.children) {
            printDegree(child);
        }
    }

    public static void guessNumberGame(Scanner scanner) {
        System.out.println("想一個數字 1~100");
        decisionTree(scanner, 1, 100);
    }

    public static void decisionTree(Scanner scanner, int low, int high) {
        if (low > high) {
            System.out.println("你是不是在亂回答？");
            return;
        }
        int mid = (low + high) / 2;
        System.out.println("你的數字是 " + mid + " 嗎？(y/n)");
        String ans = scanner.nextLine();
        if (ans.equals("y")) {
            System.out.println("猜對了！");
        } else {
            System.out.println("比 " + mid + " 大嗎？(y/n)");
            String ans2 = scanner.nextLine();
            if (ans2.equals("y")) {
                decisionTree(scanner, mid + 1, high);
            } else {
                decisionTree(scanner, low, mid - 1);
            }
        }
    }

    public static void main(String[] args) {
        MultiWayNode root = new MultiWayNode("A");
        MultiWayNode b = new MultiWayNode("B");
        MultiWayNode c = new MultiWayNode("C");
        MultiWayNode d = new MultiWayNode("D");
        MultiWayNode e = new MultiWayNode("E");
        MultiWayNode f = new MultiWayNode("F");

        root.children.add(b);
        root.children.add(c);
        root.children.add(d);
        b.children.add(e);
        b.children.add(f);

        System.out.print("DFS: ");
        dfs(root);
        System.out.println();

        System.out.print("BFS: ");
        bfs(root);
        System.out.println();

        System.out.println("高度: " + treeHeight(root));

        System.out.println("每個節點的度數:");
        printDegree(root);

        System.out.println("啟動猜數字決策樹遊戲:");
        Scanner scanner = new Scanner(System.in);
        guessNumberGame(scanner);
    }
}
