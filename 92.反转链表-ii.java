/*
 * @lc app=leetcode.cn id=92 lang=java
 *
 * [92] 反转链表 II
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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(left == right) {
            return head;
        }
        if(left == 1) {
            return revert(null, head, right - left);
        }

        ListNode returnHead = head;

        for(int i = 2; i < left; i++) {
            head = head.next;
        }

        revert(head, head.next, right - left);


        return returnHead;



    }

    private ListNode revert(ListNode head, ListNode left, int length) {
        ListNode temp = null;
        ListNode initLeft = left;
        for(int i = 0; i <=length; i++) {
            ListNode next = left.next;
           setNext(left, temp);
            temp = left;
            left = next;
        }
        setNext(initLeft, left);


        if(head != null) {
            setNext(head, temp);
        }
        return temp;
    }

    private void setNext(ListNode a, ListNode b) {
        if(a == null) {
            return;
        }
        a.next = b;
    }
}
// @lc code=end

