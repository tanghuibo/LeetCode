/*
 * @lc app=leetcode.cn id=86 lang=java
 *
 * [86] 分隔链表
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
    public ListNode partition(ListNode head, int x) {
        ListNode lNode = null;
        ListNode rNode = null;
        ListNode fLNode = null;
        ListNode fRNode = null;
        while(head != null) {
            int val = head.val;
            if(val < x) {
                if(lNode == null) {
                    fLNode = head;
                } else {
                    lNode.next = head;
                }
                lNode = head;
                head = head.next;
                continue;
            } 
            if(rNode == null) {
                fRNode = head;
            } else {
                rNode.next = head;
            }
            rNode = head;
            head = head.next;
        }

        if(rNode != null) {
            rNode.next = null;
        }

        if(fLNode == null) {
            return fRNode;
        }

        lNode.next = fRNode;
        return fLNode;


    }
}
// @lc code=end

