package Leetcode;

// leetcode - 2402
// tc - O(mlog + 2*mlogn), sc - O(n)
class Solution {
    class Pair{
        int roomNo;
        int time;
        public Pair(int roomNo, int time){
            this.roomNo = roomNo;
            this.time = time;
        }
        public String toString(){
            return roomNo + " " + time;
        }
    }

    public int mostBooked(int n, int[][] meetings) {
        int m = meetings.length;
        int[] roomsUsed = new int[n];

        Arrays.sort(meetings, (a, b) -> a[0] - b[0]);

        PriorityQueue<Pair> filledRooms =  new PriorityQueue<>((a, b) -> {
            if(a.time - b.time == 0) return a.roomNo - b.roomNo;
            return a.time - b.time;
        });

        PriorityQueue<Pair> emptyRooms = new PriorityQueue<>((a, b) -> {
            return a.roomNo - b.roomNo;
        });

        for(int i = 0; i < n; i++) emptyRooms.add(new Pair(i, 0));

        for(int[] meeting : meetings){
            int st = meeting[0];

            while(!filledRooms.isEmpty() && filledRooms.peek().time <= st){
                Pair pair = filledRooms.remove();
                emptyRooms.add(new Pair(pair.roomNo, st));
            }

            if(emptyRooms.isEmpty()){
                Pair pair = filledRooms.remove();
                emptyRooms.add(new Pair(pair.roomNo, pair.time));
            }

            Pair curr = emptyRooms.remove();
            roomsUsed[curr.roomNo]++;

            filledRooms.add(new Pair(curr.roomNo, Math.max(curr.time, st) + meeting[1] - meeting[0]));
        }

        int result = 0;
        for(int i = 1; i < n; i++){
            if(roomsUsed[i] > roomsUsed[result]) result = i;
        }
        return result;
    }
}
