package Leetcode;

// leetcode - 1461
// tc - O(n), sc - O(2^k)
class Solution {
    public boolean hasAllCodes(String s, int k) {
        if (s.length() < k) return false;
        Set<Integer> set = new HashSet<>();
        int current = 0;

        for (int i = 0; i < k; i++) {
            current = current * 2 + (s.charAt(i) - '0');
        }

        set.add(current);

        int power = 1 << (k-1);

        for (int i = k; i < s.length(); i++) {
            int leftBit = s.charAt(i - k) - '0';
            int newBit = s.charAt(i) - '0';

            // Remove leftmost bit
            current = current - (leftBit * power);

            // Shift left
            current = current * 2;

            // Insert new bit
            current = current + newBit;

            set.add(current);
            if (set.size() == (1 << k)) return true;
        }
        return set.size() == (1 << k);
    }
}