import java.util.*;

public class M11_GraphBipartite {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt(); 

        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) graph.add(new ArrayList<>());

        for (int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        if (isBipartite(graph, n)) {
            System.out.println("Bipartite");
        } else {
            System.out.println("Not Bipartite");
        }
    }

    private static boolean isBipartite(List<List<Integer>> graph, int n) {
        int[] color = new int[n];
        Arrays.fill(color, -1); 

        for (int start = 0; start < n; start++) {
            if (color[start] == -1) {
                Queue<Integer> q = new LinkedList<>();
                q.add(start);
                color[start] = 0;

                while (!q.isEmpty()) {
                    int node = q.poll();
                    for (int nei : graph.get(node)) {
                        if (color[nei] == -1) {
                            color[nei] = 1 - color[node];
                            q.add(nei);
                        } else if (color[nei] == color[node]) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }
}

