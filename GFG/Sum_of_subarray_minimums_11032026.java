package GFG;

// tc - O(n) & sc - O(n)
class Solution {
    public int sumSubMins(int[] arr) {
        int n = arr.length;
        int result = 0;
        int[] nextSmaller = new int[n];
        int[] prevSmaller = new int[n];

        Stack<Integer> st = new Stack<>();

        st.push(0);

        for(int i = 1; i < n; i++){
            while(!st.isEmpty() && arr[i] <= arr[st.peek()]){
                nextSmaller[st.pop()] = i;
            }
            st.push(i);
        }
        while(!st.isEmpty()) nextSmaller[st.pop()] = n;

        st.push(n-1);
        for(int i = n-2; i >= 0; i--){
            while(!st.isEmpty() && arr[i] < arr[st.peek()]){
                prevSmaller[st.pop()] = i;
            }
            st.push(i);
        }
        while(!st.isEmpty()) prevSmaller[st.pop()] = -1;

        for(int i = 0; i < n; i++){
            int prev = i-prevSmaller[i];
            int next = nextSmaller[i]-i;
            result += prev*next*arr[i];
        }
        return result;
    }
}
