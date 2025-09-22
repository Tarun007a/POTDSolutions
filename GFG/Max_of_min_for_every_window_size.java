package GFG;
class Solution {
    public ArrayList<Integer> maxOfMins(int[] arr) {
        int n = arr.length;
        ArrayList<Integer> result = new ArrayList<>();
        ArrayList<Integer> len = new ArrayList<>();
        Stack<Integer> st = new Stack<>();

        for(int i = 0; i < n; i++){
            result.add(0);
            len.add(0);
        }

        for(int i = 0; i < n; i++){
            while(!st.isEmpty() && arr[st.peek()] >= arr[i]){
                int ele = st.pop();
                int size = (st.isEmpty() ? i : i - st.peek() -1);
                len.set(ele, size);
            }
            st.push(i);
        }

        while(!st.isEmpty()){
            int ele = st.pop();
            int size = (st.isEmpty() ? n : n - st.peek() -1);
            len.set(ele, size);
        }


        for(int i = 0; i < n; i++){
            int size = len.get(i)-1;
            result.set(size, Math.max(result.get(size), arr[i]));
        }

        for(int i = n-2; i >= 0; i--){
            result.set(i, Math.max(result.get(i), result.get(i+1)));
        }

        return result;
    }
}
