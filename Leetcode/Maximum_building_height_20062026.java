package Leetcode;

// leetcode - 1840
// tc - O(rlogr), sc - O(r)
class Solution {
    public int maxBuilding(int n, int[][] restrictions) {
        int result = 0;
        ArrayList<int[]> list = new ArrayList<>();
        for(int[] restriction : restrictions) list.add(restriction);

        list.add(new int[]{1, 0});
        Collections.sort(list, (a, b) -> a[0]-b[0]);
        if(list.get(list.size()-1)[0] != n) list.add(new int[]{n, n-1});

        int size = list.size();
        for(int i = 1; i < size; i++) {
            int dist = list.get(i)[0] - list.get(i-1)[0];
            list.get(i)[1] = Math.min(list.get(i)[1], list.get(i-1)[1] + dist);
        }

        for(int i = size-2; i >= 0; i--) {
            int dist = list.get(i+1)[0] - list.get(i)[0];
            list.get(i)[1] = Math.min(list.get(i)[1], list.get(i+1)[1] + dist);
        }

        for(int i = 0; i < size-1; i++) {
            int dist = list.get(i+1)[0] - list.get(i)[0];
            int maxPossible = (dist + list.get(i)[1] + list.get(i+1)[1]) / 2;
            result = Math.max(result, maxPossible);
        }

        return result;
    }
}