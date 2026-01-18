package Leetcodecontest.weekly485;

// Q-2
// leetcode - 3814
class Solution {
    static class Pair{
        int cost;
        int capacity;
        int first;
        int second;

        public Pair(int cost, int capacity){
            this.cost = cost;
            this.capacity = capacity;
            first = -1;
            second = -1;
        }

        public String toString(){
            return cost + " " + capacity + " " + first + " " + second;
        }
    }

    public int getMax(int cost, Pair[] pairs){
        int lo = 0;
        int hi = pairs.length-1;
        int result = -1;

        while(lo <= hi){
            int mid = lo-(lo-hi)/2;
            if(pairs[mid].cost <= cost){
                result = mid;
                lo = mid+1;
            }
            else hi = mid-1;
        }
        return result;
    }

    public int maxCapacity(int[] costs, int[] capacity, int budget) {
        int n = costs.length;
        int result = 0;
        Pair[] pairs = new Pair[n];

        for(int i = 0; i < n; i++){
            pairs[i] = new Pair(costs[i], capacity[i]);
        }

        Arrays.sort(pairs, (a, b) -> (a.cost == b.cost ? b.capacity - a.capacity : a.cost - b.cost));

        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> pairs[a].capacity - pairs[b].capacity);

        for(int i = 0; i < n; i++){
            pq.add(i);
            if(pq.size() > 2) pq.remove();

            if(pq.size() == 1) pairs[i].first = pq.peek();
            else{
                pairs[i].second = pq.remove();
                pairs[i].first = pq.peek();
                pq.add(pairs[i].second);
            }
        }


        // System.out.println(Arrays.toString(pairs));

        for(int i = 0; i < n; i++){
            if(pairs[i].cost >= budget) return result;

            int idx = getMax(budget - pairs[i].cost - 1, pairs);
            if(idx == -1){
                result = Math.max(result, pairs[i].capacity);
                continue;
            }

            int currMax = pairs[idx].first;
            currMax = pairs[currMax].capacity;

            if(pairs[idx].first == i){
                if(pairs[idx].second == -1) currMax = 0;
                else {
                    currMax = pairs[idx].second;
                    currMax = pairs[currMax].capacity;
                }
            }
            result = Math.max(result, pairs[i].capacity + currMax);
        }
        return result;
    }
}

