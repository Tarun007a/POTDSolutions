package GFG;

// tc - O(n), sc - O(n)
class Solution {
    public int countAtMostK(int arr[], int k) {
        int n = arr.length;
        HashMap<Integer, Integer> mp = new HashMap<>();
        int prev = 0;
        int result = 0;

        for(int i = 0; i < n; i++){
            mp.put(arr[i], mp.getOrDefault(arr[i], 0)+1);

            while(mp.size() > k){
                int toRemove = arr[prev++];
                mp.put(toRemove, mp.get(toRemove)-1);
                if(mp.get(toRemove) == 0) mp.remove(toRemove);
            }
            result += (i-prev+1);
        }
        return result;
    }
}

