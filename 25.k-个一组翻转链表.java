/*
 * @lc app=leetcode.cn id=25 lang=java
 *
 * [25] K 个一组翻转链表
 */

// @lc code=start
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
        if(k < 2) {
            return head;
        }

        ListNode hair = new ListNode(0);
        hair.next = head;
        ListNode preNode = hair;
        while(head != null) {
            ListNode startHead = head;
            for(int i = 0; i < k - 1; i++) {
                head = head.next;
                if(head == null) {
                    return hair.next;
                }
            }
            reverse(startHead, head);
            preNode.next = head; 
            preNode = startHead;
            head = startHead.next;
        }
        return hair.next;
    }

    private void reverse(ListNode head, ListNode tail) {
        ListNode preNode = tail.next;
        while (preNode != tail) {
            ListNode nextNode = head.next;
            head.next = preNode;
            preNode = head;
            head = nextNode;
        }
    }
}
// @lc code=end

