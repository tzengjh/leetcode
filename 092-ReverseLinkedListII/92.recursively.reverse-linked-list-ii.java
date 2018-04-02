/*
 * [92] Reverse Linked List II
 *
 * https://leetcode.com/problems/reverse-linked-list-ii/description/
 *
 * algorithms
 * Medium (31.34%)
 * Total Accepted:    135.8K
 * Total Submissions: 433.6K
 * Testcase Example:  '[5]\n1\n1'
 *
 * 
 * Reverse a linked list from position m to n. Do it in-place and in
 * one-pass.
 * 
 * 
 * 
 * For example:
 * Given 1->2->3->4->5->NULL, m = 2 and n = 4,
 * 
 * 
 * return 1->4->3->2->5->NULL.
 * 
 * 
 * Note:
 * Given m, n satisfy the following condition:
 * 1 ≤ m ≤ n ≤ length of list.
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
    public ListNode reverseBetween(ListNode head, int m, int n) {
    	if(n == m) return head;
    	ListNode node = head;
    	ListNode prev = null;
    	for(int i = 1; i < m; i++){
    		prev = node;
    		node = node.next;
    	}
    	ListNode rever = reverseBetween(node.next, 1, n - m);
    	if(prev != null) prev.next = rever;
    	else head = rever;
    	ListNode p = node.next.next;
    	node.next.next = node;
    	node.next = p;
    	return head;
    }
}
