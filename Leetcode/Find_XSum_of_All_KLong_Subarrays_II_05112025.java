package Leetcode;

// leetcode - 3321
// tc - O(nlogn), sc - O(n)
class Xsum{
    private int x;
    private long result;
    private TreeSet<Pair> large;
    private TreeSet<Pair> small;
    private HashMap<Integer, Integer> mp;

    public Xsum(int x){
        this.x = x;
        this.result = 0;
        this.large = new TreeSet<>();
        this.small = new TreeSet<>();
        mp = new HashMap<>();
    }

    private static class Pair implements Comparable<Pair>{
        int first;
        int second;

        public Pair(int first, int second){
            this.first = first;
            this.second = second;
        }

        @Override
        public int compareTo(Pair p){
            if(first != p.first) return first - p.first;
            return second - p.second;   // if freq is same then large value is first
        }

        @Override
        public boolean equals(Object o){
            Pair p = (Pair) o;
            return first == p.first && second == p.second;
        }

        @Override
        public int hashCode(){
            return Objects.hash(first, second);
        }

        @Override
        public String toString(){
            return first + " " + second;
        }
    }

    public void insert(int n){
        if(mp.containsKey(n) && mp.get(n) > 0){
            removePair(new Pair(mp.get(n), n));
        }
        mp.put(n, mp.getOrDefault(n, 0)+1);
        insertPair(new Pair(mp.get(n), n));
    }

    public void remove(int n){
        removePair(new Pair(mp.get(n), n));
        mp.put(n, mp.get(n)-1);
        if(mp.get(n) > 0){
            insertPair(new Pair(mp.get(n), n));
        }
    }

    private void insertPair(Pair p){
        if(large.size() < x){
            large.add(p);
            result += (long)p.first * (long)p.second;
        }
        else if(p.compareTo(large.first()) > 0){
            large.add(p);
            result += (long)p.first * (long)p.second;
            Pair toRemove = large.first();
            result -= (long)toRemove.first * (long)toRemove.second;
            large.remove(toRemove);
            small.add(toRemove);
        }
        else small.add(p);
    }

    private void removePair(Pair p){
        if(small.contains(p)) small.remove(p);
        else{
            result -= (long)p.first * (long)p.second;
            large.remove(p);
            if(!small.isEmpty()){
                Pair toAdd = small.last();
                result += (long)toAdd.first * (long)toAdd.second;
                small.remove(toAdd);
                large.add(toAdd);
            }
        }
    }

    public long get(){
        return result;
    }
}
class Solution {
    public long[] findXSum(int[] nums, int k, int x) {
        int n = nums.length;
        Xsum obj = new Xsum(x);
        long[] result = new long[n-k+1];

        for(int i = 0; i < n; i++){
            obj.insert(nums[i]);
            if(i >= k) obj.remove(nums[i-k]);
            if(i >= k-1) result[i-k+1] = obj.get();
        }
        return result;
    }
}
