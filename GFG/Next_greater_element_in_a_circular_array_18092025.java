package GFG;
class Solution {
    public ArrayList<Integer> nextGreater(int[] arr) {
        int n = arr.length;
        int[] result = new int[n];
        Stack<Integer> st = new Stack<>();

        st.push(0);
        for(int i = 1; i < n; i++){
            while(!st.isEmpty() && arr[st.peek()] < arr[i]){
                int idx = st.pop();
                result[idx] = arr[i];
            }
            st.push(i);
        }

        for(int i = 0; i < n; i++){
            while(!st.isEmpty() && arr[st.peek()] < arr[i]){
                int idx = st.pop();
                result[idx] = arr[i];
            }
        }

        while(!st.isEmpty())result[st.pop()] = -1;

        ArrayList<Integer> list = new ArrayList<>();
        for(int i : result)list.add(i);
        return list;
    }
}