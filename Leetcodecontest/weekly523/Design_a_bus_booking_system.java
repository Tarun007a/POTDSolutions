package Leetcodecontest.weekly523;

class BusBooking {
    int[][] seats;
    int bookedSeats = 0;
    int currTime = 0;

    public BusBooking(int n) {
        seats = new int[n+1][4];
    }

    public void toggle(String seat) {
        int row = Integer.parseInt(seat.substring(1));
        int col = 0;

        char ch = seat.charAt(0);
        if(ch == 'A') col = 0;
        else if(ch == 'B') col = 1;
        else if(ch == 'C') col = 2;
        else col = 3;

        if(seats[row][col] != 0) {
            currTime -= seats[row][col];
            seats[row][col] = 0;
            bookedSeats--;
        }
        else {
            bookedSeats++;
            if(col == 1 || col == 2) {
                currTime++;

                seats[row][col] = 1;
            }
            else {
                if(col == 0) {
                    if(seats[row][1] == 0) {
                        currTime++;
                        seats[row][col] = 1;
                    }
                    else {
                        currTime += 3;
                        seats[row][col] = 3;
                    }
                }
                else {
                    if(seats[row][2] == 0) {
                        currTime++;
                        seats[row][col] = 1;
                    }
                    else {
                        currTime += 3;
                        seats[row][col] = 3;
                    }
                }
            }
        }
    }

    public int getTotalTime() {
        return currTime;
    }

    public int getMinTime() {
        return bookedSeats;
    }
}

/**
 * Your BusBooking object will be instantiated and called as such:
 * BusBooking obj = new BusBooking(n);
 * obj.toggle(seat);
 * int param_2 = obj.getTotalTime();
 * int param_3 = obj.getMinTime();
 */