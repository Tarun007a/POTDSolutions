package GFG;

// tc - O(n), sc - O(1)
class Solution {
    public boolean areIsomorphic(String s1, String s2) {
        int n = s1.length();
        int[] mapping = new int[26];
        Arrays.fill(mapping, -1);
        HashSet<Integer> mapped = new HashSet<>();

        for(int i = 0; i < n; i++){
            int idx = s1.charAt(i) - 'a';
            int mappedIdx = s2.charAt(i) - 'a';
            if(mapping[idx] == -1) {
                if(mapped.contains(mappedIdx)) return false;
                mapped.add(mappedIdx);
                mapping[idx] = mappedIdx;
            }
            else if(mapping[idx] != mappedIdx) return false;
        }
        return true;
    }
}