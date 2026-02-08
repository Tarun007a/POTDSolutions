package Leetcodecontest.weekly488;

class Solution {
    public List<Long> mergeAdjacent(int[] nums) {
        int n = nums.length;
        Stack<Long> st = new Stack<>();

        for(int i : nums){
            long val = i;
            while(!st.isEmpty() && st.peek() == val){
                st.pop();
                val *= 2;
            }
            st.push(val);
        }
        ArrayList<Long> result = new ArrayList<>();
        while(!st.isEmpty()) result.add(st.pop());
        Collections.reverse(result);
        return result;
    }
}