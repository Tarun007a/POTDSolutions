package Leetcode;

// leetcode - 2751
// tc - O(nlogn), sc - O(n)
class Solution {
    class Robot{
        int posi;
        int health;
        char dir;
        public Robot(int posi, int health, char dir){
            this.posi = posi;
            this.health = health;
            this.dir = dir;
        }
    }
    public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
        int n = positions.length;
        Stack<Robot> st = new Stack<>();
        List<Robot> robots = new ArrayList<>();
        HashMap<Integer, Integer> mp = new HashMap<>();

        for(int i = 0; i < n; i++){
            robots.add(new Robot(positions[i], healths[i], directions.charAt(i)));
            mp.put(positions[i], healths[i]);
        }

        Collections.sort(robots, (a,b)-> Integer.compare(a.posi, b.posi));

        int i = 0;
        while(i < n){
            Robot r = robots.get(i);

            if(st.isEmpty() || r.dir == st.peek().dir || (r.dir == 'R'&& st.peek().dir == 'L')){
                st.push(r);
                i++;
            }
            else{
                Robot s = st.pop();
                if(s.health == r.health){
                    mp.put(s.posi, -1);
                    mp.put(r.posi, -1);
                    i++;
                }
                else if(s.health > r.health){
                    // set there new health
                    mp.put(r.posi, -1);
                    mp.put(s.posi, s.health-1);

                    // here we set the stats of s in r as we remveo r and keep
                    // and in next iteration we need to again process it therefore
                    // we also not increment i as this is stack process full nested length
                    r.health = s.health-1;
                    r.posi = s.posi;
                    r.dir = s.dir;
                }
                else{
                    // this time s is removed which we have removed from statck
                    // and now in next itr we need to process r only so just reduce
                    // it health and set health in map
                    mp.put(r.posi, r.health-1);
                    r.health--;
                    mp.put(s.posi, -1);
                }
            }
        }

        List<Integer> result = new ArrayList<>();
        for(int j : positions){
            if(mp.get(j) != -1)result.add(mp.get(j));
        }
        return result;
    }
}