/*
 * [203] Remove Linked List Elements
 *
 * https://leetcode.com/problems/remove-linked-list-elements/description/
 *
 * algorithms
 * Easy (33.39%)
 * Total Accepted:    149.3K
 * Total Submissions: 447K
 * Testcase Example:  '[1,2,6,3,4,5,6]\n6'
 *
 * Remove all elements from a linked list of integers that have value val.
 * 
 * Example
 * Given: 1 --> 2 --> 6 --> 3 --> 4 --> 5 --> 6,  val = 6
 * Return: 1 --> 2 --> 3 --> 4 --> 5
 * 
 * 
 * Credits:Special thanks to @mithmatt for adding this problem and creating all
 * test cases.
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
    public ListNode removeElements(ListNode head, int val) {
        // ListNode curr = head;
        // ListNode prev = null;
        // while(curr != null){
        // 	if(curr.val == val){
        // 		if(prev == null){
        // 			head = curr.next;
        // 		}else{
        // 			prev.next = curr.next;
        // 		}
        // 	}else{
        // 		prev = curr;
        // 	}
        // 	curr = curr.next;
        // }
        // return head;

        /* uses fake head */
        ListNode fakeHead = new ListNode(-1);
        fakeHead.next = head;
        ListNode curr = head, prev = fakeHead;
        while(curr != null){
        	if(curr.val == val){
        		prev.next = curr.next;
        	}else{
        		prev = prev.next;
        	}
        	curr = curr.next;
        }
        return fakeHead.next;
    }
}
