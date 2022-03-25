/*
 * @lc app=leetcode.cn id=21 lang=java
 *
 * [21] 合并两个有序链表
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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1 == null) {
            return list2;
        }
        if(list2 == null) {
            return list1;
        }
        ListNode head = null;
        if(list1.val < list2.val) {
            head = list1;
            list1 = list1.next;
        } else {
            head = list2;
            list2 = list2.next;
        }

        ListNode data = head;

        while(true) {
            if(list1 == null ) {
                data.next = list2;
                break;
            } 

            if(list2 == null ) {
                data.next = list1;
                break;
            } 

            if(list1.val < list2.val) {
                data.next = list1;
                data = data.next;
                list1 = list1.next;
                continue;
            } else {
                data.next = list2;
                data = data.next;
                list2 = list2.next;
                continue;
            }
        }

        return head;
        
        

    }
}
// @lc code=end

