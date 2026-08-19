package Leetcode;

// leetcode - 1386
// tc - O(q), sc - O(q)
class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        int result = 0;
        HashMap<Integer, HashSet<Integer>> mp = new HashMap<>();

        for(int[] seat : reservedSeats) {
            if(!mp.containsKey(seat[0])) mp.put(seat[0], new HashSet<>());
            mp.get(seat[0]).add(seat[1]);
        }

        result += (n - mp.size()) * 2;

        for(int i : mp.keySet()) {

            HashSet<Integer> set = mp.get(i);
            boolean took = false;

            if(!(set.contains(2) ||  set.contains(3) ||  set.contains(4) ||  set.contains(5))) {
                result++;
                took = true;
            }

            if(!(set.contains(6) ||  set.contains(7) ||  set.contains(8) ||  set.contains(9))) {
                result++;
                took = true;
            }

            if(!took && !(set.contains(4) ||  set.contains(5) ||  set.contains(6) ||  set.contains(7))) result++;
        }
        return result;
    }
}
