/*
 * [83] Remove Duplicates from Sorted List
 *
 * https://leetcode.com/problems/remove-duplicates-from-sorted-list/description/
 *
 * algorithms
 * Easy (40.28%)
 * Total Accepted:    234K
 * Total Submissions: 580.9K
 * Testcase Example:  '[1,1,2]'
 *
 * Given a sorted linked list, delete all duplicates such that each element
 * appear only once.
 *
 * Example 1:
 *
 *
 * Input: 1->1->2
 * Output: 1->2
 *
 *
 * Example 2:
 *
 *
 * Input: 1->1->2->3->3
 * Output: 1->2->3
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
        ListNode first = head;
        while(first.next != null){
            if(first.val == first.next.val){
                first.next = first.next.next;
            }else{
                first = first.next;
            }
        }
        return head;
    }
}
