package GFG;

// time complexity - O(2^9)*k (k for coping list)
class Solution {
    private void getCombinations(int reqSum, int k, int st, boolean[] isVisited, ArrayList<Integer> list, ArrayList<ArrayList<Integer>> result){
        if(reqSum == 0 && k == 0){
            ArrayList<Integer> curr = new ArrayList<>(list);
            result.add(curr);
            return;
        }
        if(reqSum == 0 || k == 0) return;

        for(int i = st; i <= reqSum && i < 10; i++){
            if(!isVisited[i]){
                isVisited[i] = true;
                list.add(i);

                getCombinations(reqSum-i, k-1, i+1, isVisited, list, result);

                list.remove(list.size()-1);
                isVisited[i] = false;
            }
        }
    }

    public ArrayList<ArrayList<Integer>> combinationSum(int n, int k) {
        boolean[] isVisited = new boolean[10];
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>();

        getCombinations(n, k, 1, isVisited, list, result);
        return result;
    }
}
