/*
 * @lc app=leetcode.cn id=82 lang=java
 *
 * [82] 删除排序链表中的重复元素 II
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

        ListNode result = null;
        ListNode currentItem = null;
        ListNode beforeNode = null;
        Integer beforeData = null;
        boolean needAdd = true;

        while(head != null) {
            int currentData = head.val;
            if(beforeNode == null) {
                beforeNode = head;
                beforeData = currentData;
                head = head.next;
                continue;
            }

            if(currentData != beforeData) {
                if(needAdd) {
                    if(result == null) {
                        result = beforeNode;
                        currentItem = beforeNode;
                    } else {
                       
                        currentItem.next = beforeNode;
                        currentItem = beforeNode;
                    }
                }

                if(head.next == null) {
                    if(result == null) {
                        result = head;
                        currentItem = head;
                    } else {
                        currentItem.next = head;
                        currentItem = head;
                    }
                    break;
                }
                needAdd = true;
                beforeData = currentData;
            }  else {
                needAdd = false;
            }

            beforeNode = head;

            head = head.next;

        }
        if(currentItem != null) {
            currentItem.next = null;
        }


        return result;
        

    }
}
// @lc code=end

