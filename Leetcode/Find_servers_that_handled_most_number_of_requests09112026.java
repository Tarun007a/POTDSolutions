package Leetcode;

// leetcode - 1606
// tc - O(n * logk), sc - O(k)
class Solution {
    private class Server {
        int idx;
        int time;

        public Server(int idx, int time) {
            this.idx = idx;
            this.time = time;
        }
    }

    public List<Integer> busiestServers(int k, int[] arrival, int[] load) {
        int n = arrival.length;
        int[] count = new int[k];

        TreeSet<Integer> available = new TreeSet<>();
        PriorityQueue<Server> busy = new PriorityQueue<>((a, b) -> a.time - b.time);

        for(int i = 0; i < k; i++) available.add(i);

        for(int i = 0; i < n; i++) {
            int time = arrival[i];
            int stIdx = i % k;

            while(!busy.isEmpty() && busy.peek().time <= time) {
                available.add(busy.remove().idx);
            }

            if(available.size() == 0) continue;

            Integer next = available.ceiling(stIdx);

            int assignTo = -1;

            if(next == null) assignTo = available.first();
            else assignTo = next;

            count[assignTo]++;
            available.remove(assignTo);
            busy.add(new Server(assignTo, time + load[i]));
            // System.out.println(i + " -> " + assignTo);
        }

        ArrayList<Integer> result = new ArrayList<>();
        int max = Arrays.stream(count).max().getAsInt();

        for(int i = 0; i < k; i++) {
            if(count[i] == max) result.add(i);
        }

        return result;
    }
}