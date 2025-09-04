import java.util.*;

public class LC19_RemoveNth_Node_Clinic {
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int v) { val = v; }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        for(int i=0; i<n; i++) {
            curr.next = new ListNode(sc.nextInt());
            curr = curr.next;
        }
        int k = sc.nextInt();
        sc.close();

        ListNode head = removeNthFromEnd(dummy.next, k);

        // 輸出刪除後序列
        curr = head;
        while(curr != null) {
            System.out.print(curr.val);
            if(curr.next != null) System.out.print(" ");
            curr = curr.next;
        }
    }

    static ListNode removeNthFromEnd(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode fast = dummy, slow = dummy;

        // fast 先走 k 步
        for(int i=0; i<k; i++) fast = fast.next;

        // 同步移動到 fast 到尾
        while(fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }

        // slow.next 就是要刪除的節點
        slow.next = slow.next.next;

        return dummy.next;
    }
}
