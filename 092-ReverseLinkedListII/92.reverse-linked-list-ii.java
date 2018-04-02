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
    	ListNode prev = null;
    	ListNode curr = head;
    	for(int i = 1; i < n; i++){
    		if(i >= m){
    			if(prev == null){
    				ListNode p = head;
    				head = curr.next;
    				curr.next = curr.next.next;
    				head.next = p;
    			}else{
    				ListNode p = prev.next;
    				prev.next = curr.next;
    				curr.next = curr.next.next;
    				prev.next.next = p;
    			}
    		}else{
    			prev = curr;
    			curr = curr.next;
    		}
    	}
    	return head;
    }
}
