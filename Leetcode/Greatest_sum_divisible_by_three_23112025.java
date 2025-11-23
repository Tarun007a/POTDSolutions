package Leetcode;

// leetcode : 1262
// tc - O(n), sc O(1)
class Solution {
    public int maxSumDivThree(int[] nums) {
        int n = nums.length;
        int total = 0;

        PriorityQueue<Integer> one = new PriorityQueue<>((a, b) -> b-a);
        PriorityQueue<Integer> two = new PriorityQueue<>((a, b) -> b-a);

        for(int num : nums){
            total += num;

            if(num%3 == 1){
                one.add(num);
                if(one.size() > 2) one.remove();
            }

            else if(num%3 == 2){
                two.add(num);
                if(two.size() > 2) two.remove();
            }
        }

        if(total%3 == 0) return total;

        int first = 100000;
        int second = 100000;

        if(total%3 == 1){
            if(one.size() >= 1){
                if(one.size() == 2) one.remove();
                first = one.remove();
            }
            if(two.size() >= 2) second = two.remove() + two.remove();
        }

        if(total%3 == 2){
            if(one.size() >= 2) first = one.remove() + one.remove();
            if(two.size() >= 1){
                if(two.size() == 2) two.remove();
                second = two.remove();
            }
        }
        return total - Math.min(first, second);
    }
}