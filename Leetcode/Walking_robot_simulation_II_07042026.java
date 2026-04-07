package Leetcode;

// leetcode - 2069
// every method works in O(1) and for n calls tc - O(1)
class Robot {
    int height, width;
    int x, y;
    int dir;
    int round;
    int cumSteps;

    public Robot(int width, int height) {
        this.height = height;
        this.width = width;
        x = 0;
        y = 0;
        dir = 1;
        cumSteps = 0;
        if (width == 1) round = height;
        else if (height == 1) round = width;
        else round = 2 * (width + height) - 4;
    }

    public void step(int num) {
        cumSteps += num;
    }

    // O(1)
    public void takeSteps(int num) {
        if(num == 0) return;

        num = num%round;

        /* important observation to note that if the robot takes round trip so
        the direction can change if you are 0, 0 and directon is east and it you take
        a full round trip you direction will become south.
        */
        if(num == 0) num = round;

        while(true) {
            if(dir == 0) {
                int max = height - x - 1;
                if(num <= max) {
                    x += num;
                    break;
                }
                else {
                    num -= max;
                    x = height-1;
                    dir = 3;
                }
            }
            else if(dir == 1) {
                int max = width - y - 1;
                if(num <= max){
                    y += num;
                    break;
                }
                else {
                    num -= max;
                    y = width-1;
                    dir = 0;
                }
            }
            else if(dir == 2) {
                int max = x;
                if(num <= max) {
                    x -= num;
                    break;
                }
                else {
                    num -= max;
                    x = 0;
                    dir = 1;
                }
            }
            else {
                int max = y;
                if(num <= max) {
                    y -= num;
                    break;
                }
                else {
                    num -= max;
                    y = 0;
                    dir = 2;
                }
            }
        }
    }

    public int[] getPos() {
        takeSteps(cumSteps);
        cumSteps = 0;
        return new int[]{y, x};
    }

    public String getDir() {
        takeSteps(cumSteps);
        cumSteps = 0;
        return switch(dir) {
            case 0 -> "North";
            case 1 -> "East";
            case 2 -> "South";
            case 3 -> "West";
            default -> "";
        };
    }
}