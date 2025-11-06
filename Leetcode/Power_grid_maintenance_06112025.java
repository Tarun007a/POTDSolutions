package Leetcode;


// leetcode - 3607
// tc   -> off - O(1)
//      -> add - nlog(n)
//      -> get - log(n) (amortized)
//      -> creating dsu - O(nlogn)
//sc - O(1)
class Node{
    int n;
    PriorityQueue<Integer> pq;
    HashSet<Integer> visited;

    public Node(int n){
        this.n = n;
        pq = new PriorityQueue<>();
        visited = new HashSet<>();
    }
}

class DSU{
    int[] parent;
    int[] size;
    Node[] nodes;

    public DSU(int n){
        nodes = new Node[n+1];
        parent = new int[n+1];
        size = new int[n+1];

        for(int i = 0; i <= n; i++){
            size[i] = 1;
            parent[i] = i;
            nodes[i] = new Node(n);
            nodes[i].pq.add(i);
        }
    }

    private int findUPar(int n){
        if(parent[n] == n) return n;
        return parent[n] = findUPar(parent[n]);
    }

    public int get(int n){
        Node par = nodes[findUPar(n)];
        if(!par.visited.contains(n)) return n;
        while(!par.pq.isEmpty()){
            int num = par.pq.peek();
            if(par.visited.contains(num)) par.pq.remove();
            else return num;
        }
        return -1;
    }

    public void off(int n){
        Node node = nodes[findUPar(n)];
        node.visited.add(n);
    }

    public void add(int u, int v){
        int parU = findUPar(u);
        int parV = findUPar(v);

        if(parU == parV) return;
        if(size[parU] > size[parV]){
            parent[parV] = parU;
            size[parU] += size[parV];

            Node nodeU = nodes[parU];
            Node nodeV = nodes[parV];

            while(!nodeV.pq.isEmpty()){
                nodeU.pq.add(nodeV.pq.remove());
            }
            for(int i : nodeV.visited){
                nodeU.visited.add(i);
            }
            nodeV.visited = nodeU.visited;
            nodeV.pq = nodeU.pq;
        }
        else{
            parent[parU] = parV;
            size[parV] += size[parU];

            Node nodeU = nodes[parU];
            Node nodeV = nodes[parV];

            while(!nodeU.pq.isEmpty()){
                nodeV.pq.add(nodeU.pq.remove());
            }
            for(int i : nodeU.visited){
                nodeV.visited.add(i);
            }
            nodeU.visited = nodeV.visited;
            nodeU.pq = nodeV.pq;
        }
    }
}
class Solution {
    public int[] processQueries(int c, int[][] connections, int[][] queries) {
        int m = queries.length;
        ArrayList<Integer> list = new ArrayList<>();
        DSU dsu = new DSU(c);

        for(int[] connect : connections){
            dsu.add(connect[0], connect[1]);
        }

        for(int i = 0; i < m; i++){
            if(queries[i][0] == 1){
                list.add(dsu.get(queries[i][1]));
            }
            else{
                dsu.off(queries[i][1]);
            }
        }

        int[] result = new int[list.size()];
        for(int i = 0; i < list.size(); i++){
            result[i] = list.get(i);
        }
        return result;
    }
}
