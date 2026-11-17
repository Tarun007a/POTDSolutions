package GFG;

// tc - O(n), sc - O(1)
class Solution {
    public boolean findPattern(String s) {
        int countX = 0;
        int countY = 0;

        for(char ch : s.toCharArray()) {
            if(ch == 'x') {
                countX++;
                if(countY > 0) return false;
            }
            else {
                countY++;

                if(countX == 0) return false;

                if(countY == countX) {
                    countX = 0;
                    countY = 0;
                }
            }
        }
        if(countX > 0 || countY > 0) return false;
        return true;
    }
}
