package GFG;

// tc - O(nlogn) sc - O(n)
class Solution {
    public int minOperations(int[] arr) {
        int total = 0;
        int result = 0;
        PriorityQueue<Double> pq = new PriorityQueue<>((a, b) ->{
            if(a > b) return -1;
            return 1;
        });

        for(int i : arr){
            total += i;
            pq.add((double)i);
        }

        double toReduce = total/2.0;

        while(toReduce > 0){
            double ele = pq.remove();
            toReduce -= ele/2;
            pq.add(ele/2);
            result++;
        }
        return result;
    }
}
