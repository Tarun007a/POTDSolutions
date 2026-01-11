package Leetcode;

// leetcode - 85
// tc - O(n*m), sc - O(m)
class Solution {
    public int largestRect(int[] arr){
        int n = arr.length;
        Stack<Integer> st = new Stack<>();
        int ans = 0;

        for(int i = 0; i <= n; i++){
            while(!st.isEmpty() && (i == n || arr[st.peek()] > arr[i])){
                int pop = st.pop();
                int width = i;
                if(!st.isEmpty())width = i-st.peek()-1;
                int height = arr[pop];
                ans = Math.max(ans,width*height);
            }
            st.push(i);
        }
        return ans;
    }
    public int maximalRectangle(char[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int[] arr = new int[m];
        int ans = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(matrix[i][j] == '1')arr[j]++;
                else arr[j] = 0;
            }
            ans = Math.max(ans,largestRect(arr));
        }
        return ans;
    }
}