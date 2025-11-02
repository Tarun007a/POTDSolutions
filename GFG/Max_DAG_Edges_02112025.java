package GFG;

// tc - O(1), sc - O(1)
class Solution {
    public int maxEdgesToAdd(int v, int[][] edges) {
        return (v*(v-1))/2 - edges.length;
    }
}