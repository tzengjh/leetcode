/*
 * [82] Remove Duplicates from Sorted List II
 *
 * https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/description/
 *
 * algorithms
 * Medium (29.99%)
 * Total Accepted:    133.6K
 * Total Submissions: 445.3K
 * Testcase Example:  '[1,2,3,3,4,4,5]'
 *
 * Given a sorted linked list, delete all nodes that have duplicate numbers,
 * leaving only distinct numbers from the original list.
 *
 * Example 1:
 *
 *
 * Input: 1->2->3->3->4->4->5
 * Output: 1->2->5
 *
 *
 * Example 2:
 *
 *
 * Input: 1->1->1->2->3
 * Output: 2->3
 *
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
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null) return head;
        ListNode headNode = new ListNode(0);
        headNode.next = head;
        ListNode pre = headNode, curr = head;
        while(curr != null){
            boolean flag = false;
            while(curr.next != null && curr.val == curr.next.val){
                flag = true;
                curr = curr.next;
            }
            if(flag){
                pre.next = curr.next;
            }else{
                pre = curr;
            }
            curr = curr.next;
        }
        return headNode.next;
    }
}
