package Leetcodecontest.weekly487;

class RideSharingSystem {
    HashSet<Integer> canclled;
    HashSet<Integer> addedRiders;
    Queue<Integer> driver;
    Queue<Integer> rider;

    public RideSharingSystem() {
        rider = new ArrayDeque<>();
        driver = new ArrayDeque<>();
        canclled = new HashSet<>();
        addedRiders = new HashSet<>();
    }

    public void addRider(int riderId) {
        rider.add(riderId);
        addedRiders.add(riderId);
    }

    public void addDriver(int driverId) {
        driver.add(driverId);
    }

    public int[] matchDriverWithRider() {
        while(!rider.isEmpty() && canclled.contains(rider.peek())) rider.remove();
        if(rider.isEmpty() || driver.isEmpty()) return new int[]{-1, -1};
        return new int[]{driver.remove(), rider.remove()};
    }

    public void cancelRider(int riderId) {
        if(addedRiders.contains(riderId)) canclled.add(riderId);
    }
}

/**
 * Your RideSharingSystem object will be instantiated and called as such:
 * RideSharingSystem obj = new RideSharingSystem();
 * obj.addRider(riderId);
 * obj.addDriver(driverId);
 * int[] param_3 = obj.matchDriverWithRider();
 * obj.cancelRider(riderId);
 */