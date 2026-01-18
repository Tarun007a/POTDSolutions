package GFG;

// tc - O(n), sc - O(n)
class Solution {
    public ArrayList<Integer> nextFreqGreater(int[] arr) {
        int n = arr.length;

        ArrayList<Integer> result = new ArrayList<>();
        HashMap<Integer, Integer> mp = new HashMap<>();
        Deque<Integer> st = new ArrayDeque<Integer>();

        for(int i : arr){
            mp.put(i, mp.getOrDefault(i, 0)+1);
            result.add(0);
        }

        for(int i = 0; i < n; i++){
            while(!st.isEmpty() && mp.get(arr[st.peek()]) < mp.get(arr[i])){
                result.set(st.pop(), arr[i]);
            }
            st.push(i);
        }

        while(!st.isEmpty()) result.set(st.pop(), -1);

        return result;
    }
}