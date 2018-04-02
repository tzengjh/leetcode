/*
 * [206] Reverse Linked List
 *
 * https://leetcode.com/problems/reverse-linked-list/description/
 *
 * algorithms
 * Easy (46.71%)
 * Total Accepted:    334.4K
 * Total Submissions: 715.9K
 * Testcase Example:  '[]'
 *
 * Reverse a singly linked list.
 * 
 * click to show more hints.
 * 
 * Hint:
 * A linked list can be reversed either iteratively or recursively. Could you
 * implement both?
 * 
 */
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        // if(head == null)
        // 	return null;
        // ListNode headNode = reverseList(head.next);
        // if(headNode == null) return head;
        // ListNode node = headNode;
        // while(node.next!=null)
        // 	node = node.next;
        // node.next = head;
        // head.next = null; // set head.next = null;
        // return headNode;
        if(head == null || head.next == null)
            return head;
        ListNode headNode = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return headNode;
    }
}
