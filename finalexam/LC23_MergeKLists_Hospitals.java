import java.util.*;

public class LC23_MergeKLists_Hospitals {
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int v) { val = v; }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        ListNode[] lists = new ListNode[k];
        sc.nextLine();

        for(int i=0;i<k;i++){
            String[] nums = sc.nextLine().trim().split(" ");
            ListNode dummy = new ListNode(0), curr = dummy;
            for(String s: nums){
                if(s.equals("-1")) break;
                curr.next = new ListNode(Integer.parseInt(s));
                curr = curr.next;
            }
            lists[i] = dummy.next;
        }
        sc.close();

        ListNode merged = mergeKLists(lists);

        // 輸出
        ListNode curr = merged;
        while(curr != null){
            System.out.print(curr.val);
            if(curr.next != null) System.out.print(" ");
            curr = curr.next;
        }
    }

    static ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>(Comparator.comparingInt(a->a.val));
        for(ListNode node: lists)
            if(node!=null) pq.offer(node);

        ListNode dummy = new ListNode(0), tail=dummy;
        while(!pq.isEmpty()){
            ListNode node = pq.poll();
            tail.next = node;
            tail = tail.next;
            if(node.next != null) pq.offer(node.next);
        }
        return dummy.next;
    }
}
