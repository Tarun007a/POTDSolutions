package GFG;

// tc - O(n), sc - O(1)
class Solution {
    public ArrayList<Integer> update(int n, int[] updates) {
        ArrayList<Integer> result = new ArrayList<>();

        for(int i = 0; i < n; i++) result.add(0);

        for(int update : updates) {
            result.set(update-1, result.get(update-1)+1);
        }

        for(int i = 1; i < n; i++) {
            result.set(i, result.get(i-1) + result.get(i));
        }
        return result;
    }
}