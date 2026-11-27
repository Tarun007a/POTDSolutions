package GFG;

class Solution {
    public int countEdges(ArrayList<ArrayList<Integer>> adj) {
        int result = 0;

        for(ArrayList<Integer> list : adj) result += list.size();

        return result / 2;
    }
}