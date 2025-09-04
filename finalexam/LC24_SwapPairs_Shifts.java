import java.util.*;

public class LC24_SwapPairs_Shifts {
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int v){ val=v; }
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String[] nums = sc.nextLine().trim().split(" ");
        sc.close();

        ListNode dummy = new ListNode(0), curr=dummy;
        for(String s: nums){
            curr.next = new ListNode(Integer.parseInt(s));
            curr = curr.next;
        }

        ListNode head = swapPairs(dummy.next);

        curr = head;
        while(curr!=null){
            System.out.print(curr.val);
            if(curr.next!=null) System.out.print(" ");
            curr = curr.next;
        }
    }

    static ListNode swapPairs(ListNode head){
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;

        while(prev.next != null && prev.next.next != null){
            ListNode a = prev.next;
            ListNode b = a.next;
            a.next = b.next;
            b.next = a;
            prev.next = b;
            prev = a;
        }
        return dummy.next;
    }
}
