package Leetcode;

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
// leetcode - 2058
// tc - O(n), sc - O(1)
class Solution {
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        int idx = 1;
        int firstLocal = -1;
        int lastLocal = -1;
        int minDist = -1;
        int prev = head.val;
        int lastCritical = -1;

        ListNode temp = head.next;


        while(temp.next != null) {
            if((temp.val > prev && temp.val > temp.next.val) ||
                    (temp.val < prev && temp.val < temp.next.val)) {

                if(firstLocal == -1) firstLocal = idx;
                lastLocal = idx;

                if(minDist == -1 && lastCritical != -1){
                    minDist = idx - lastCritical;
                }
                else minDist = Math.min(minDist, idx - lastCritical);

                lastCritical = idx;
            }
            idx++;
            prev = temp.val;
            temp = temp.next;
        }

        int maxDist = -1;
        if(firstLocal != lastLocal)
            maxDist = lastLocal - firstLocal;

        return new int[]{minDist, maxDist};
    }
}