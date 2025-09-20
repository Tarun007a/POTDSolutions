package GFG;

class Solution {
    public static int longestSubarray(int[] arr) {
        int n = arr.length;

        int[] nextGreater = new int[n];
        int[] prevGreater = new int[n];

        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && arr[st.peek()] < arr[i]) {
                nextGreater[st.pop()] = i;
            }
            st.push(i);
        }

        while(!st.isEmpty()) nextGreater[st.pop()] = n;



        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && arr[st.peek()] < arr[i]) {
                prevGreater[st.pop()] = i;
            }
            st.push(i);
        }

        while(!st.isEmpty()) prevGreater[st.pop()] = -1;

        int maxLength = 0;
        for (int i = 0; i < n; i++) {
            int windowSize = nextGreater[i] - prevGreater[i] - 1;
            if (windowSize >= arr[i]) {
                maxLength = Math.max(maxLength, windowSize);
            }
        }

        return maxLength;

    }
}