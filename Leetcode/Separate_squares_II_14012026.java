package Leetcode;

// still not clear
// leetcode - 3454

class Solution {
    static class Event {
        int y, type;
        int x1, x2;

        Event(int y, int type, int x1, int x2) {
            this.y = y;
            this.type = type;
            this.x1 = x1;
            this.x2 = x2;
        }
    }

    static class Strip {
        int y, height;
        double width;

        Strip(int y, int height, double width) {
            this.y = y;
            this.height = height;
            this.width = width;
        }
    }

    private double getUnionWidth(List<int[]> intervals) {
        if (intervals.isEmpty()) return 0.0;

        intervals.sort(Comparator.comparingInt(a -> a[0]));

        double width = 0;
        int currL = intervals.get(0)[0];
        int currR = intervals.get(0)[1];

        for (int i = 1; i < intervals.size(); i++) {
            int l = intervals.get(i)[0];
            int r = intervals.get(i)[1];

            if (l > currR) {
                width += currR - currL;
                currL = l;
                currR = r;
            } else {
                currR = Math.max(currR, r);
            }
        }

        width += currR - currL;
        return width;
    }

    public double separateSquares(int[][] squares) {

        List<Event> events = new ArrayList<>();

        for (int[] s : squares) {
            int x = s[0];
            int y = s[1];
            int l = s[2];

            events.add(new Event(y, +1, x, x + l));
            events.add(new Event(y + l, -1, x, x + l));
        }

        events.sort(Comparator.comparingInt(e -> e.y));

        List<int[]> activeX = new ArrayList<>();
        List<Strip> strips = new ArrayList<>();

        double totalArea = 0;
        int prevY = events.get(0).y;

        for (Event e : events) {
            if (e.y > prevY) {
                double width = getUnionWidth(activeX);
                int height = e.y - prevY;

                if (width > 0) {
                    strips.add(new Strip(prevY, height, width));
                    totalArea += width * height;
                }
            }

            if (e.type == +1) {
                activeX.add(new int[]{e.x1, e.x2});
            } else {
                for (int i = 0; i < activeX.size(); i++) {
                    int[] in = activeX.get(i);
                    if (in[0] == e.x1 && in[1] == e.x2) {
                        activeX.remove(i);
                        break;
                    }
                }
            }

            prevY = e.y;
        }

        double target = totalArea / 2.0;
        double currArea = 0;

        for (Strip s : strips) {
            double area = s.width * s.height;

            if (currArea + area >= target) {
                double need = target - currArea;
                return s.y + (need / s.width);
            }

            currArea += area;
        }

        return 0.0;
    }
}
