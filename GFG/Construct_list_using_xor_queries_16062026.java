package GFG;

// tc - O(n), sc - O(n)
class Solution {
    public ArrayList<Integer> constructList(int[][] queries) {
        ArrayList<Integer> result = new ArrayList<>();
        ArrayList<Integer> xor = new ArrayList<>();
        int cummXor = 0;
        result.add(0);
        xor.add(0);
        xor.add(0);

        for(int[] query : queries) {
            if(query[0] == 0) {
                result.add(query[1]);
                xor.add(0);
            }
            else {
                int len = result.size();
                xor.set(0, xor.get(0) ^ query[1]);
                xor.set(len, xor.get(len) ^ query[1]);
            }
        }

        for(int i = 0; i < result.size(); i++) {
            cummXor ^= xor.get(i);
            result.set(i, result.get(i) ^ cummXor);
        }

        Collections.sort(result);
        return result;
    }
}