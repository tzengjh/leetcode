/*
 * [142] Linked List Cycle II
 *
 * https://leetcode.com/problems/linked-list-cycle-ii/description/
 *
 * algorithms
 * Medium (30.62%)
 * Total Accepted:    143.7K
 * Total Submissions: 469.4K
 * Testcase Example:  '[]\nno cycle'
 *
 *
 * Given a linked list, return the node where the cycle begins. If there is no
 * cycle, return null.
 *
 *
 *
 * Note: Do not modify the linked list.
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
    public ListNode detectCycle(ListNode head) {
        if(head == null) return null;
        ListNode faster = head, slower = head;
        do{
            if(faster.next == null || faster.next.next == null)
                return null;
            faster = faster.next.next;
            slower = slower.next;
        }while(faster != slower);
        ListNode node = head;
        while(node != slower){
            node = node.next;
            slower = slower.next;
        }
        return node;
    }
}
