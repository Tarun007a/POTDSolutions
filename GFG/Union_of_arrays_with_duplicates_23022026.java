package GFG;

// tc - O(n+m), sc - O(n+m)
class Solution {
    public static ArrayList<Integer> findUnion(int[] a, int[] b) {
        HashSet<Integer> set = new HashSet<>();
        for(int i : a)set.add(i);
        for(int i : b)set.add(i);
        return new ArrayList<>(set);
    }
}
