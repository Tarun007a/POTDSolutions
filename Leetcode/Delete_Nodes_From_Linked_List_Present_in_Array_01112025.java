package Leetcode;

// leetcode - 3217
// tc - O(n), sc - O(m)
class Solution {
    public ListNode modifiedList(int[] nums, ListNode head) {
        ListNode dummyHead = new ListNode(0, head);
        HashSet<Integer> set = new HashSet<>();
        for(int i : nums)set.add(i);
        ListNode temp = dummyHead;
        while(temp.next != null){
            if(set.contains(temp.next.val)){
                temp.next = temp.next.next;
            }
            else temp = temp.next;
        }
        return dummyHead.next;
    }
}