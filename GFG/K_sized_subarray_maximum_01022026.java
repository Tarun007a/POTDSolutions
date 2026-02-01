package GFG;

// tc - O(n), sc - O(n)
class Solution {
    public ArrayList<Integer> maxOfSubarrays(int arr[], int k) {
        int n = arr.length;
        int[] nextGreater = new int[n];
        ArrayList<Integer> result = new ArrayList<>();

        int i = n-1;
        Stack<Integer> st = new Stack<>();
        st.push(n);

        while(i >= 0){
            while(st.peek() != n && arr[st.peek()] <= arr[i])st.pop();
            nextGreater[i] = st.peek();
            st.push(i);
            i--;
        }

        int curr = 0;
        for(int idx = 0; idx < n-k+1; idx++){
            if(curr < idx)curr++;
            while(nextGreater[curr] < idx+k) curr = nextGreater[curr];
            result.add(arr[curr]);
        }
        return result;
    }
}