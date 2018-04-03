/*
 * [141] Linked List Cycle
 *
 * https://leetcode.com/problems/linked-list-cycle/description/
 *
 * algorithms
 * Easy (35.07%)
 * Total Accepted:    244.1K
 * Total Submissions: 696.1K
 * Testcase Example:  '[]\nno cycle'
 *
 * 
 * Given a linked list, determine if it has a cycle in it.
 * 
 * 
 * 
 * Follow up:
 * Can you solve it without using extra space?
 * 
 */
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */

public class Solution {
    public boolean hasCycle(ListNode head) {
    	if(head == null) return false;
    	ListNode slow = head, fast = head;
    	do{
    		// check fast.next.next == null in case of NullPointerException when calling fast.next next time.
    		if(fast.next == null || fast.next.next == null)  
    			return false;
    		slow = slow.next;
    		fast = fast.next.next;
    	}while(slow != fast);
    	return true;
    }
}
