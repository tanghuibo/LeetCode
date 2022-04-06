import java.util.List;

/*
 * @lc app=leetcode.cn id=61 lang=java
 *
 * [61] 旋转链表
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
    public ListNode rotateRight(ListNode head, int k) {

        int length = 0;
        ListNode tail = head;

        ListNode temp = head;
        while(temp != null) {
            tail = temp;
            length++;
            temp = temp.next;
        }
        if(length <= 1) {
            return head;
        }
        int tailIndex = length - k % length - 1;
        if(tailIndex == length - 1) {
            return head;
        }

        ListNode newTail = getByIndex(head, tailIndex);
        ListNode newHead = newTail.next;
        newTail.next = null;
        tail.next = head;
        return newHead;

    }

    private ListNode getByIndex(ListNode head, int index) {
        for (int i = 0; i < index; i++) {
            head = head.next;
        }
        return head;
    }
}
// @lc code=end

