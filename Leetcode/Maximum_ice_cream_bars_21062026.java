// leetcode - 1833
// tc - o(n), sc - O(max)
class Solution {
    public int maxIceCream(int[] costs, int coins) {
        int result = 0;
        int max = 0;

        for(int cost : costs) {
            max = Math.max(max, cost);
        }

        int[] count = new int[max+1];
        for(int cost : costs) {
            count[cost]++;
        }

        for(int i = 1; i <= max; i++) {
            int c = count[i];
            int cost = i;

            if(coins >= cost*c){
                result += c;
                coins -= c * cost;
            }
            else {
                result += coins / cost;
                break;
            }
        }
        return result;
    }
}