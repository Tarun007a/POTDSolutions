package GFG;

// tc - O(n), sc - O(k)
class Solution {
    ArrayList<Integer> countDistinct(int arr[], int k) {
        int n = arr.length;
        HashMap<Integer, Integer> mp = new HashMap<>();
        ArrayList<Integer> result = new ArrayList<>();

        for(int i = 0; i < k; i++) mp.put(arr[i], mp.getOrDefault(arr[i], 0) + 1);
        result.add(mp.size());

        for(int i = k; i < n; i++){
            mp.put(arr[i], mp.getOrDefault(arr[i], 0) + 1);
            mp.put(arr[i-k], mp.get(arr[i-k])-1);

            if(mp.get(arr[i-k]) == 0) mp.remove(arr[i-k]);

            result.add(mp.size());
        }
        return result;
    }
}