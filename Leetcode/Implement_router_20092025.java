package Leetcode;

//leetcode - 3508
class Router {
    Set<Packet> packets;
    Queue<Packet> q;
    int limit;
    HashMap<Integer, List<Packet>> mp;
    HashMap<Integer, Integer> startPoint;

    class Packet{
        int source;
        int destination;
        int timestamp;

        public Packet(int source, int destination, int timestamp){
            this.source = source;
            this.destination = destination;
            this.timestamp = timestamp;
        }

        @Override
        public int hashCode(){
            return Objects.hash(source, destination, timestamp);
        }

        @Override
        public String toString(){
            return "Source : " + source + " | Destination : " + destination + " | Timestamp : " + timestamp;
        }

        @Override
        public boolean equals(Object o){
            Packet p = (Packet) o;
            return (this.source == p.source && this.destination == p.destination && this.timestamp == p.timestamp);
        }
    }


    public Router(int memoryLimit) {
        packets = new HashSet<>();
        q = new ArrayDeque<>();
        limit = memoryLimit;
        mp = new HashMap<>();
        startPoint  = new HashMap<>();
    }

    public boolean addPacket(int source, int destination, int timestamp) {
        // System.out.println(packets);
        Packet p = new Packet(source, destination, timestamp);
        if(packets.contains(p)) return false;

        packets.add(p);
        q.add(p);
        if(!mp.containsKey(destination)){
            mp.put(destination, new ArrayList<>());
            startPoint.put(destination, 0);
        }
        mp.get(destination).add(p);

        if(q.size() > limit){
            Packet remove = q.remove();
            packets.remove(remove);
            startPoint.put(remove.destination, startPoint.get(remove.destination)+1);
        }

        return true;
    }

    public int[] forwardPacket() {
        // System.out.println(packets);
        if(q.size() == 0) return new int[]{};

        Packet p = q.remove();
        packets.remove(p);
        startPoint.put(p.destination, startPoint.get(p.destination)+1);

        return new int[]{p.source, p.destination, p.timestamp};
    }

    public int getCount(int destination, int startTime, int endTime) {
        // System.out.println(packets);
        if(!mp.containsKey(destination)) return 0;

        List<Packet> list = mp.get(destination);
        int st = startPoint.get(destination);
        // System.out.println(st);

        int up = bsUpperBound(list, st, endTime);
        int lb = bsLowerBound(list, st, startTime);
        if(up == -1 || lb == -1) return 0;
        return up-lb+1;
    }

    private int bsLowerBound(List<Packet> list, int st, int time){
        int end = list.size()-1;
        int result = -1;

        while(st <= end){
            int mid = st-(st-end)/2;
            if(list.get(mid).timestamp >= time){
                result = mid;
                end = mid-1;
            }
            else st = mid+1;
        }
        // System.out.println(result);
        return result;
    }

    private int bsUpperBound(List<Packet> list, int st, int time){
        int end = list.size()-1;
        // System.out.println(st + " " + end);
        int result = -1;

        while(st <= end){
            int mid = st-(st-end)/2;
            // System.out.println(mid);
            if(list.get(mid).timestamp <= time){
                result = mid;
                st = mid+1;
            }
            else end = mid-1;
        }
        // System.out.println(result);
        return result;
    }
}