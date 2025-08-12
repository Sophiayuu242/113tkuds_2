import java.util.*;
public class KthSmallestElement {
    public static int find(int[] arr, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int v : arr) {
            pq.add(v);
            if (pq.size() > k) pq.poll();
        }
        return pq.peek();
    }
    public static void main(String[] args) {
        System.out.println(find(new int[]{7,10,4,3,20,15},3));
        System.out.println(find(new int[]{1},1));
        System.out.println(find(new int[]{3,1,4,1,5,9,2,6},4));
    }
}
