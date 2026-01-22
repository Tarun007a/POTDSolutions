package GFG;

// tc - O(n), sc - O(n)
class Solution {
    private int[] getNextGreater(int[] arr){
        int n = arr.length;
        int[] result = new int[n];
        Stack<Integer> st = new Stack<>();

        for(int i = 0; i < n; i++){
            int ele = arr[i];

            while(!st.isEmpty() && arr[st.peek()] < ele){
                result[st.pop()] = i;
            }

            st.push(i);
        }

        while(!st.isEmpty()){
            result[st.pop()] = n;
        }
        return result;
    }

    private int[] getNextSmaller(int[] arr){
        int n = arr.length;
        int[] result = new int[n];
        Stack<Integer> st = new Stack<>();

        for(int i = 0; i < n; i++){
            int ele = arr[i];

            while(!st.isEmpty() && arr[st.peek()] > ele){
                result[st.pop()] = i;
            }

            st.push(i);
        }

        while(!st.isEmpty()){
            result[st.pop()] = n;
        }
        return result;
    }

    private int[] getPrevSmaller(int[] arr){
        int n = arr.length;
        int[] result = new int[n];
        Stack<Integer> st = new Stack<>();

        for(int i = 0; i < n; i++){
            int ele = arr[i];

            while(!st.isEmpty() && arr[st.peek()] > ele) st.pop();

            if(st.isEmpty()) result[i] = -1;
            else result[i] = st.peek();

            st.push(i);
        }
        return result;
    }

    private int[] getPrevGreater(int[] arr){
        int n = arr.length;
        int[] result = new int[n];
        Stack<Integer> st = new Stack<>();

        for(int i = 0; i < n; i++){
            int ele = arr[i];

            while(!st.isEmpty() && arr[st.peek()] < ele) st.pop();

            if(st.isEmpty()) result[i] = -1;
            else result[i] = st.peek();

            st.push(i);
        }
        return result;
    }

    public int subarrayRanges(int[] arr) {
        int n = arr.length;
        int[] nge = getNextGreater(arr);
        int[] pge = getPrevGreater(arr);
        int[] nse = getNextSmaller(arr);
        int[] pse = getPrevSmaller(arr);
        long result = 0;

        for(int i = 0; i < n; i++){
            long maxCount = (long)(i - pge[i]) * (nge[i] - i);
            long minCount = (long)(i - pse[i]) * (nse[i] - i);

            result += maxCount * arr[i];
            result -= minCount * arr[i];
        }
        return (int)result;
    }
}

