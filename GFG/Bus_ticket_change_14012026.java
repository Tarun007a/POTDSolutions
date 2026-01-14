package GFG;

// tc - O(n), sc - O(1)
class Solution {
    public boolean canServe(int[] arr) {
        int five = 0;
        int ten = 0;
        int twenty = 0;

        for(int i : arr){
            if(i == 5)five++;

            else if(i == 10){
                if(five == 0) return false;
                five--;
                ten++;
            }

            else{
                if(five == 0) return false;
                if(ten > 0){
                    ten--;
                    five--;
                    twenty++;
                }
                else{
                    if(five < 3) return false;
                    five -= 3;
                    twenty++;
                }
            }
        }
        return true;
    }
}