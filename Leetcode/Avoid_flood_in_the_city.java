package Leetcode;

// we will save the zero days and when a flood is going to occur we will empty the lake using
// the saved zero(summer days) to empty the lake and if we cannot do so then we get a flood
// also we can only empty the lake after it was filled i.e. if 0 1 1 comes
// here if you come to 0 you save it,
// for the 1st idx as 1 is empty fill the lake
// other 1 now, 1 is already filled and we have a 0 but we cannot empty it because the 0 is
// before the 1, means we can only use 0 after then previously filled index
// so we can use zero after the previously filled index (we will use binary seach for this)
// we used tree set to remove efficiently and also get the next index of zero(not need to do bs by own).
class Solution {
    public int[] avoidFlood(int[] rains) {
        int n = rains.length;
        int[] result = new int[rains.length];
        Arrays.fill(result, 1);
        TreeSet<Integer> st = new TreeSet<Integer>();    // to remove and also get next index efficiently
        Map<Integer, Integer> mp = new HashMap<Integer, Integer>();   // when the lake was previously filled
        for (int i = 0; i < rains.length; ++i) {
            if (rains[i] == 0) st.add(i);
            else {
                result[i] = -1;
                if (mp.containsKey(rains[i])) {
                    Integer nextIdx = st.ceiling(mp.get(rains[i]));  // nextidx is idx to empty
                    if (nextIdx == null) {                                // if no idx to empty -> flood
                        return new int[0];
                    }
                    result[nextIdx] = rains[i];      // on nextIdx we emptited this lake
                    st.remove(nextIdx);              // done
                }
                mp.put(rains[i], i);             // update the previously filled index
            }
        }
        return result;
    }
}