package GFG;

class Solution {
    class Point{
        int x;
        int y;
        public Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    public ArrayList<ArrayList<Integer>> kClosest(int[][] points, int k) {
        PriorityQueue<Point> pq = new PriorityQueue<>((a, b) -> (Math.sqrt(a.x*a.x + a.y*a.y) - Math.sqrt(b.x*b.x + b.y*b.y) > 0 ? -1 : 1));
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        for(int[] point : points){
            pq.add(new Point(point[0], point[1]));
            if(pq.size() > k) pq.remove();
        }

        while(!pq.isEmpty()){
            Point point = pq.remove();
            ArrayList<Integer> curr = new ArrayList<>();
            curr.add(point.x);
            curr.add(point.y);
            result.add(curr);
        }
        return result;
    }
}