package Leetcodecontest.weekly489;

// leetcode - 3842
class Solution {
    public List<Integer> toggleLightBulbs(List<Integer> bulbs) {
        boolean[] result = new boolean[101];

        for(int i : bulbs){
            result[i] = !result[i];
        }

        List<Integer> list = new ArrayList<>();
        for(int i = 1; i <= 100; i++){
            if(result[i]) list.add(i);
        }

        return list;
    }
}