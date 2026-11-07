package Leetcode;

// leetcode - 1882
// tc - O((n + m)logn), sc - O(n + m)
class Solution {
    private class Server {
        int idx;
        int weight;
        int freeTime;

        public Server(int idx, int weight, int freeTime) {
            this.idx = idx;
            this.weight = weight;
            this.freeTime = freeTime;
        }

        public String toString() {
            return idx + " " + weight + " " + freeTime;
        }
    }

    private class BusyServer {
        int idx;
        int time;
        int weight;

        public BusyServer(int idx, int time, int weight) {
            this.idx = idx;
            this.time = time;
            this.weight = weight;
        }

        public String toString() {
            return idx + " " + time + " " + weight;
        }
    }

    public int[] assignTasks(int[] servers, int[] tasks) {
        int n = servers.length;
        int m = tasks.length;

        int[] result = new int[m];

        PriorityQueue<Server> availableServers = new PriorityQueue<>((a, b) -> {
            if(a.weight == b.weight) return a.idx - b.idx;
            return a.weight - b.weight;
        });

        PriorityQueue<BusyServer> busyServers = new PriorityQueue<>((a, b) -> {
            return a.time - b.time;
        });

        for(int i = 0; i < n; i++) {
            availableServers.add(new Server(i, servers[i], 0));
        }

        for(int i = 0; i < m; i++) {
            // System.out.println(i + " - > ");
            // System.out.println(busyServers);
            while(!busyServers.isEmpty() && busyServers.peek().time <= i) {
                // System.out.println(busyServers.peek().time);
                BusyServer free = busyServers.remove();
                availableServers.add(new Server(free.idx, free.weight, i));
            }

            if(availableServers.isEmpty()) {
                int freeTime = busyServers.peek().time;

                while(!busyServers.isEmpty() && busyServers.peek().time <= freeTime) {
                    BusyServer free = busyServers.remove();
                    availableServers.add(new Server(free.idx, free.weight, free.time));
                }
            }

            // System.out.println(availableServers);
            // System.out.println(busyServers);

            Server server = availableServers.remove();
            result[i] = server.idx;
            busyServers.add(new BusyServer(server.idx, Math.max(server.freeTime, i) + tasks[i], server.weight));

            // System.out.println(availableServers);
            // System.out.println(busyServers);
        }
        return result;
    }
}















