import java.util.*;

public class LC25_ReverseKGroup_Shifts {
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int v){ val=v; }
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        sc.nextLine();
        String[] nums = sc.nextLine().trim().split(" ");
        sc.close();

        ListNode dummy = new ListNode(0), curr=dummy;
        for(String s: nums){
            curr.next = new ListNode(Integer.parseInt(s));
            curr = curr.next;
        }

        ListNode head = reverseKGroup(dummy.next, k);

        curr = head;
        while(curr != null){
            System.out.print(curr.val);
            if(curr.next!=null) System.out.print(" ");
            curr = curr.next;
        }
    }

    static ListNode reverseKGroup(ListNode head, int k){
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prevGroup = dummy;

        while(true){
            ListNode kth = prevGroup;
            for(int i=0;i<k;i++){
                kth = kth.next;
                if(kth==null) return dummy.next; // 不足 k，返回
            }
            ListNode groupStart = prevGroup.next;
            ListNode nextGroup = kth.next;

            // 反轉 k 節點
            ListNode prev = nextGroup, curr = groupStart;
            for(int i=0;i<k;i++){
                ListNode tmp = curr.next;
                curr.next = prev;
                prev = curr;
                curr = tmp;
            }

            prevGroup.next = prev;
            prevGroup = groupStart;
        }
    }
}
