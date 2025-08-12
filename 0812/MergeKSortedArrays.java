import java.util.*;
class Node { int val, ai, ei; Node(int v,int a,int e){val=v;ai=a;ei=e;} }
public class MergeKSortedArrays {
    public static List<Integer> merge(int[][] arrays) {
        List<Integer> res = new ArrayList<>();
        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(a->a.val));
        for (int i=0;i<arrays.length;i++) if (arrays[i].length>0) pq.add(new Node(arrays[i][0],i,0));
        while (!pq.isEmpty()) {
            Node n = pq.poll();
            res.add(n.val);
            if (n.ei+1<arrays[n.ai].length) pq.add(new Node(arrays[n.ai][n.ei+1],n.ai,n.ei+1));
        }
        return res;
    }
    public static void main(String[] args) {
        System.out.println(merge(new int[][]{{1,4,5},{1,3,4},{2,6}}));
        System.out.println(merge(new int[][]{{1,2,3},{4,5,6},{7,8,9}}));
        System.out.println(merge(new int[][]{{1},{0}}));
    }
}