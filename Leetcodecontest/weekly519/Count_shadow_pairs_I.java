package Leetcodecontest.weekly519;

class Solution {
    public long shadowPairs(int[] nums) {
        long result = 0;
        Stack<Integer> st = new Stack<>();
        HashMap<Integer, Integer> freq = new HashMap<>();

        for(int num : nums) {
            while(!st.isEmpty() && num < st.peek()) {
                int remove = st.pop();
                if(freq.containsKey(remove)) freq.remove(remove);
            }

            if(!st.isEmpty()) {
                int peek = st.peek();
                result += (long)st.size();

                if(peek == num) result -= (long)freq.get(peek);
            }
            st.push(num);
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }
        return result;
    }
}