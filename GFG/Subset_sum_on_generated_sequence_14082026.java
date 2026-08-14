package GFG;

// tc - O(n), sc - O(n)
class Solution {
    public boolean isPossible(int[] arr, int s, int x) {
        int n = arr.length;
        int sum = s;
        ArrayList<Integer> list = new ArrayList<>();
        HashSet<Integer> set = new HashSet<>();
        list.add(s);

        for(int i = 0; i < n; i++) {
            list.add(sum + arr[i]);
            sum += (sum + arr[i]);
        }

        for(int i = list.size()-1; i >= 0; i--) {
            int ele = list.get(i);
            if(ele <= x) x -= ele;

            if(x == 0) return true;
        }

        return false;
    }