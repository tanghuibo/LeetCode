/*
 * @lc app=leetcode.cn id=83 lang=java
 *
 * [83] 删除排序链表中的重复元素
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
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }

        int beforeVal = head.val;
        ListNode beforeNode = head;
        ListNode temp = head.next;
        while(temp != null) {
            int thisVal = temp.val;
            if(thisVal != beforeVal) {
                beforeNode.next = temp;
                beforeNode = temp;
                beforeVal = thisVal;
            }
            temp = temp.next;
        }

        beforeNode.next = null;

        return head;
    }
}
// @lc code=end

