package Leetcode;

// leetcode - 799
// tc - O(n*n), sc - O(n)
class Solution {
    public double champagneTower(int poured, int query_row, int query_glass) {
        ArrayList<Double> prev = new ArrayList<>();
        prev.add((double)poured);

        for(int i = 1; i <= query_row; i++){
            ArrayList<Double> curr = new ArrayList<>();
            curr.add(0.0);

            for(double quantity : prev){
                quantity--;
                int size = curr.size();
                double half = quantity/2;
                if(half < 0) half = 0;
                double prevQuantity = curr.get(size-1);
                curr.set(size-1, half + prevQuantity);
                curr.add(half);
            }
            prev = curr;
        }
        double result = prev.get(query_glass);
        if(result >= 1) return 1.0;
        return prev.get(query_glass);
    }
}