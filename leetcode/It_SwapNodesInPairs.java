/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode curr = dummy;

        while (curr.next != null && curr.next.next != null) {
            ListNode first = curr.next;
            ListNode second = curr.next.next;

            first.next = second.next;
            second.next = first;
            curr.next = second;

            curr = first;
        }
        return dummy.next;
    }
}

/*
解題思路：
1. 使用 dummy 節點處理頭節點交換。
2. 每次取兩個節點 first、second，調整指標完成交換。
3. curr 向前移動兩步，繼續處理後續節點。
時間複雜度：O(n)，空間複雜度：O(1)。
*/
