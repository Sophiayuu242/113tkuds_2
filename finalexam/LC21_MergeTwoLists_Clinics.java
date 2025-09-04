import java.util.*;

public class LC21_MergeTwoLists_Clinics {
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int v) { val = v; }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        ListNode l1 = buildList(sc, n);
        ListNode l2 = buildList(sc, m);
        sc.close();

        ListNode merged = mergeTwoLists(l1, l2);

        // 輸出合併後序列
        ListNode curr = merged;
        while(curr != null) {
            System.out.print(curr.val);
            if(curr.next != null) System.out.print(" ");
            curr = curr.next;
        }
    }

    static ListNode buildList(Scanner sc, int len) {
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        for(int i=0; i<len; i++) {
            curr.next = new ListNode(sc.nextInt());
            curr = curr.next;
        }
        return dummy.next;
    }

    static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;

        while(l1 != null && l2 != null) {
            if(l1.val <= l2.val) {
                tail.next = l1;
                l1 = l1.next;
            } else {
                tail.next = l2;
                l2 = l2.next;
            }
            tail = tail.next;
        }

        // 接上剩餘節點
        tail.next = (l1 != null) ? l1 : l2;

        return dummy.next;
    }
}
