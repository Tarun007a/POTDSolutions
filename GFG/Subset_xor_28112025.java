package GFG;

// tc - O(n), sc - O(1)
class Solution {
    public static ArrayList<Integer> subsetXOR(int n) {
        int xor=0;

        ArrayList<Integer> result = new ArrayList<>();

        for(int i = 1; i <= n; i++){
            xor ^= i;
            result.add(i);
        }

        if(xor != n){
            int k = xor ^ n;    // get the diffrence between xor and n
            result.remove(Integer.valueOf(k));  // add it to result;
        }
        return result;
    }
}
