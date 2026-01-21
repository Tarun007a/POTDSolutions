package GFG;

// tc - O(n), sc - O(n)
class Solution {
    public ArrayList<Integer> calculateSpan(int[] arr) {
        int n = arr.length;
        Stack<Integer> st = new Stack<>();
        ArrayList<Integer> result = new ArrayList<>();
        int[] prevGreater = new int[n];

        for(int i = 0; i < n; i++){
            while(!st.isEmpty() && arr[st.peek()] <= arr[i]) st.pop();
            if(st.isEmpty()) result.add(i+1);
            else result.add(i-st.peek());
            st.push(i);
        }
        return result;
    }
}
