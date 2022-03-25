/*
 * @lc app=leetcode.cn id=24 lang=java
 *
 * [24] 两两交换链表中的节点
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
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        ListNode result = head.next;
        ListNode temp = head;
        

        // 2 -> 1 ->3
        // temp =  1 next = 2
        // 2 -> 1 -> 3
        ListNode preNode = null;

        while(temp != null && temp.next != null) {
            ListNode next = temp.next;
            temp.next = next.next;
            next.next = temp;
            if(preNode != null) {
                preNode.next = next;
            }
            preNode = temp;
            temp = temp.next;
        }
        return result;

    }
}
// @lc code=end

