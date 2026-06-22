// tc - O(n), sc - O(1)
class Solution {
    public int maxArea(List<Integer> height) {
        int n = height.size();
        int result = 0;
        int i = 0;
        int j = n-1;

        while(i < j) {
            int currH = Math.min(height.get(j), height.get(i));
            int currW = j - i - 1;
            result = Math.max(result, currH * currW);

            if(height.get(i) > height.get(j)) j--;
            else i++;
        }
        return result;
    }
}