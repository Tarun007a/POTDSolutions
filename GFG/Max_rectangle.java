package GFG;
class Solution {
    private static int[] getNextSmaller(int[] arr){
        int n = arr.length;
        Stack<Integer> st = new Stack<>();
        int[] result = new int[n];

        for(int i = 0; i < n; i++){
            while(!st.isEmpty() && arr[st.peek()] > arr[i]){
                result[st.pop()] = i;
            }
            st.push(i);
        }
        while(!st.isEmpty()) result[st.pop()] = n;
        return result;
    }

    private static int[] getPrevSmaller(int[] arr){
        int n = arr.length;
        Stack<Integer> st = new Stack<>();
        int[] result = new int[n];

        for(int i = n-1; i >= 0; i--){
            while(!st.isEmpty() && arr[st.peek()] > arr[i]){
                result[st.pop()] = i;
            }
            st.push(i);
        }
        while(!st.isEmpty()) result[st.pop()] = -1;
        return result;
    }

    static int maxArea(int mat[][]) {
        int n = mat.length;
        int m = mat[0].length;
        int result = 0;
        int[] heights = new int[m];

        for(int i = 0; i < n; i++){

            for(int j = 0; j < m; j++){
                if(mat[i][j] == 0) heights[j] = 0;
                else heights[j]++;
            }

            int[] nextSmaller = getNextSmaller(heights);
            int[] prevSmaller = getPrevSmaller(heights);

            // System.out.println(Arrays.toString(nextSmaller));
            // System.out.println(Arrays.toString(prevSmaller));
            // System.out.println(Arrays.toString(heights));

            for(int j = 0; j < m; j++){
                if(mat[i][j] == 1){
                    int len = nextSmaller[j] - prevSmaller[j] -1;
                    int width = heights[j];
                    // System.out.println(i + " " + j + " " + len + " " + width);
                    result = Math.max(result, len*width);
                }
            }
        }
        return result;
    }
}
























