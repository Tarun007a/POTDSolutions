package Leetcode;

// leetcode - 2092
// firstly understand this then only you will understand the second one
// here we create a graph where for node x we store all y where it can go and at what time
// and we will do bfs by maintaning the earliest time at which i got to know
// this leads to tle so better one is to simply use pq
// class Solution {
//     public List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {
//         Map<Integer, List<int[]>> graph = new HashMap<>();
//         for (int[] meeting : meetings) {
//             int x = meeting[0], y = meeting[1], t = meeting[2];
//             if(!graph.containsKey(x)) graph.put(x, new ArrayList<>());
//             if(!graph.containsKey(x)) graph.put(y, new ArrayList<>());
//             graph.get(x).add(new int[]{t, y});
//             graph.get(y).add(new int[]{t, x});
//         }

//         int[] earliest = new int[n];
//         Arrays.fill(earliest, Integer.MAX_VALUE);
//         earliest[0] = 0;
//         earliest[firstPerson] = 0;

//         Queue<int[]> q = new LinkedList<>();
//         q.offer(new int[]{0, 0});
//         q.offer(new int[]{firstPerson, 0});

//         while(!q.isEmpty()){
//             int[] personAndTime = q.poll();
//             int person =personAndTime[0], time = personAndTime[1];

//             for(int [] nextPersonAndTime: graph.getOrDefault(person, new ArrayList<>())){
//                 int t = nextPersonAndTime[0], nextPerson = nextPersonAndTime[1];
//                 if (t >= time && earliest[nextPerson] > t) {
//                     earliest[nextPerson] = t;
//                     q.offer(new int[]{nextPerson, t});
//                 }
//             }
//         }

//         List<Integer> ans = new ArrayList<>();
//         for (int i = 0; i < n; ++i) {
//             if (earliest[i] != Integer.MAX_VALUE) {
//                 ans.add(i);
//             }
//         }
//         return ans;
//     }
// }

// here we use pq so go something like dijkstra and almost similar to prev one
//T.C : O((N+M) * (log(M+N) + M))
//S.C : O(N+M)
class Solution {
    public List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {
        Map<Integer, List<int[]>> graph = new HashMap<>();
        for (int[] meeting : meetings) {
            int person1 = meeting[0];
            int person2 = meeting[1];
            int time    = meeting[2];
            if(!graph.containsKey(person1)) graph.put(person1, new ArrayList<>());
            if(!graph.containsKey(person2)) graph.put(person2, new ArrayList<>());
            graph.get(person1).add(new int[]{time, person2});
            graph.get(person2).add(new int[]{time, person1});
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        pq.offer(new int[]{0, 0});
        pq.offer(new int[]{0, firstPerson});

        boolean[] visited = new boolean[n];

        while (!pq.isEmpty()) {
            int[] timePerson = pq.remove();
            int time = timePerson[0];
            int person = timePerson[1];
            if (visited[person]) continue;

            visited[person] = true;
            for (int[] nextPersonTime : graph.getOrDefault(person, new ArrayList<>())) {
                int t = nextPersonTime[0];
                int nextPerson = nextPersonTime[1];
                if (!visited[nextPerson] && t >= time) {
                    pq.add(new int[]{t, nextPerson});
                }
            }
        }

        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            if (visited[i]) {
                ans.add(i);
            }
        }
        return ans;
    }
}
