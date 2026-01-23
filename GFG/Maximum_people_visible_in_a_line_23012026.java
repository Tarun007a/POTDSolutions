package GFG;

// tc - O(n), sc - O(n)
class Solution {
    private int[] getNextGreater(int[] arr){
        int n = arr.length;
        int[] result = new int[n];
        Stack<Integer> st = new Stack<>();

        for(int i = 0; i < n; i++){
            int ele = arr[i];

            while(!st.isEmpty() && arr[st.peek()] <= ele){
                result[st.pop()] = i;
            }

            st.push(i);
        }

        while(!st.isEmpty()){
            result[st.pop()] = n;
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

    public int maxPeople(int[] arr) {
        int n = arr.length;
        int result = 0;

        int[] nge = getNextGreater(arr);
        int[] pge = getPrevGreater(arr);

        for(int i = 0; i < n; i++){
            int curr = nge[i] - i + i - pge[i] - 1;
            result = Math.max(curr, result);
        }
        return result;
    }
}
