package Leetcode;

//floyds warshall algo
class Solution {
    class Pair{
        int ch;
        int cost;
        public Pair(int ch, int cost){
            this.ch = ch;
            this.cost = cost;
        }
    }
    public long findCost(int u, int v, long[][] cost, List<List<Pair>> adj){
        if(cost[u][v] != 0)return cost[u][v];
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->a.cost-b.cost);
        boolean[] isVisited = new boolean[26];
        pq.add(new Pair(u, 0));
        while(!pq.isEmpty()){
            Pair p = pq.remove();
            int node = p.ch;
            if(isVisited[node])continue;
            isVisited[node] = true;
            cost[u][node] = p.cost;
            for(Pair curr : adj.get(node)){
                if(!isVisited[curr.ch])pq.add(new Pair(curr.ch, p.cost+curr.cost));
            }
        }
        return cost[u][v];
    }
    public long minimumCost(String source, String target, char[] original, char[] changed, int[] costTo) {
        int n = original.length;
        List<List<Pair>> adj = new ArrayList<>();
        long[][] cost = new long[26][26];
        for(int i = 0; i < 26; i++)adj.add(new ArrayList<>());
        long ans = 0;

        for(int i = 0; i < n; i++){
            int u = (int)(original[i]-'a');
            int v = (int)(changed[i]-'a');
            adj.get(u).add(new Pair(v, costTo[i]));
            //cost[u][v] = costTo[i];
        }

        for(int i = 0; i < source.length(); i++){
            int u = (int)(source.charAt(i)-'a');
            int v = (int)(target.charAt(i)-'a');
            if(u == v)continue;
            long c = findCost(u, v, cost, adj);
            //System.out.println(u+" "+v+" "+c);
            if(c == 0){
                return -1;
            }
            ans += c;
        }
        return ans;
    }
}
