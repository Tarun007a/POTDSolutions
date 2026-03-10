package GFG;

// tc & sc - O(n)
class Solution {
    public int countSubarrays(int[] arr) {
        int n = arr.length;
        int result = 0;
        Deque<Integer> st = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            while(!st.isEmpty() && arr[st.peekLast()] > arr[i]) {
                result += i - st.removeLast();
            }
            st.addLast(i);
        }
        while(!st.isEmpty()) result += n - st.removeLast();
        return result;
    }
}
