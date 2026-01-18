package Leetcodecontest.weekly485;

// Q-3
// leetcode - 3815
class AuctionSystem {
    static class Pair{
        int userId;
        int amount;

        public Pair(int userId, int amount){
            this.userId = userId;
            this.amount = amount;
        }

        public String toString(){
            return userId + " " + amount;
        }
    }

    HashMap<Integer, HashMap<Integer, Integer>> user;
    HashMap<Integer, PriorityQueue<Pair>> items;

    public AuctionSystem() {
        user = new HashMap<>();
        items = new HashMap<>();
    }

    public void addBid(int userId, int itemId, int bidAmount) {
        if(!items.containsKey(itemId)){
            items.put(itemId, new PriorityQueue<>((a, b) -> {
                if(a.amount == b.amount) return b.userId - a.userId;
                return b.amount - a.amount;
            }));
        }

        if(!user.containsKey(userId)) user.put(userId, new HashMap<>());

        user.get(userId).put(itemId, bidAmount);
        items.get(itemId).add(new Pair(userId, bidAmount));
    }

    public void updateBid(int userId, int itemId, int newAmount) {
        user.get(userId).put(itemId, newAmount);
        items.get(itemId).add(new Pair(userId, newAmount));
    }

    public void removeBid(int userId, int itemId) {
        user.get(userId).put(itemId, -1);
    }

    public int getHighestBidder(int itemId) {
        if(!items.containsKey(itemId)) return -1;
        PriorityQueue<Pair> pq = items.get(itemId);
        // System.out.println(pq);

        while(!pq.isEmpty()){
            Pair p = pq.peek();
            int userId = p.userId;
            int amount = p.amount;

            if(user.get(userId).get(itemId) == amount) return userId;
            else pq.remove();
        }
        return -1;
    }
}

/**
 * Your AuctionSystem object will be instantiated and called as such:
 * AuctionSystem obj = new AuctionSystem();
 * obj.addBid(userId,itemId,bidAmount);
 * obj.updateBid(userId,itemId,newAmount);
 * obj.removeBid(userId,itemId);
 * int param_4 = obj.getHighestBidder(itemId);
 */
