package GFG;

// 02/11/2026
// tc - O(n), sc - O(n)
class Solution {
    public int largestSumCycle(int[] edge) {
        int n = edge.length;
        int result = 0;
        boolean[] isVisited = new boolean[n];

        for(int i = 0; i < n; i++) {
            if(isVisited[i]) continue;

            int currSum = 0;
            int currNode = i;
            Queue<Integer> q = new ArrayDeque<>();

            while(true) {
                if(!isVisited[currNode]) {
                    isVisited[currNode] = true;
                    currSum += currNode;
                    q.add(currNode);

                    currNode = edge[currNode];

                    if(currNode == -1) {
                        while(!q.isEmpty()) q.remove();
                        break;
                    }
                }
                else {
                    while(!q.isEmpty() && q.peek() != currNode) currSum -= q.remove();
                    result = Math.max(result, currSum);
                    break;
                }
            }
        }

        return result == 0 ? -1 : result;
    }
}