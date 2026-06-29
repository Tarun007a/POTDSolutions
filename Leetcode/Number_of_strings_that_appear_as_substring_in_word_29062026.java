package Leetcode;

// leetcode - 1967
// tc - O(n * m * k), sc - O(1)
class Solution {
    public int numOfStrings(String[] patterns, String word) {
        int result = 0;

        for(String pattern : patterns) {
            if(word.contains(pattern)) result++;
        }
        return result;
    }
}