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
        if(head == null)
        	return null;
        ListNode headNode = head;
        while(headNode.next != null){
        	ListNode node = headNode.next;
        	headNode.next = headNode.next.next;
        	node.next = head;
        	head = node;
        }
        return head;
    }
}
