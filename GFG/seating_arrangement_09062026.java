package GFG;

// tc - O(n), sc - O(1)
class Solution {
    public boolean canSeatAllPeople(int k, int[] seats) {
        int n = seats.length;

        if(k == 0) return true;
        if(n == 1) return seats[0] == 0;

        if(n == 2) {
            if(seats[0] == 0 && seats[1] == 0) return k == 1;
        }

        if(seats[0] == 0 && seats[1] == 0) k--;
        if(seats[n-1] == 0 && seats[n-2] == 0) k--;

        for(int i = 2; i < n-2; i++) {
            if(seats[i] == 0 && seats[i-1] == 0 && seats[i+1] == 0) {
                i++;
                k--;
            }
        }
        return k <= 0;
    }
}
