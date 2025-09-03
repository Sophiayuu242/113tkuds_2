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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prevGroup = dummy;

        while (true) {
            ListNode kth = getKth(prevGroup, k);
            if (kth == null) break;
            ListNode groupNext = kth.next;

            ListNode prev = kth.next;
            ListNode curr = prevGroup.next;

            while (curr != groupNext) {
                ListNode tmp = curr.next;
                curr.next = prev;
                prev = curr;
                curr = tmp;
            }

            ListNode tmp = prevGroup.next;
            prevGroup.next = kth;
            prevGroup = tmp;
        }
        return dummy.next;
    }

    private ListNode getKth(ListNode curr, int k) {
        while (curr != null && k > 0) {
            curr = curr.next;
            k--;
        }
        return curr;
    }
}

/*
解題思路：
1. 每次找出 k 個節點，若不足 k 個則結束。
2. 翻轉該 k 個節點，並重新連接前後鏈表。
3. 使用 getKth 幫助找到分組邊界。
時間複雜度：O(n)，空間複雜度：O(1)。
*/
