package Leetcode;

//leetcode - 3542
// tc - O(n^2), sc - O(n)
class Solution {
    private static class Segment{
        int st;
        int end;
        int min;
        public Segment(int st, int end, int min){
            this.st = st;
            this.end = end;
            this.min = min;
        }

        @Override
        public String toString(){
            return st + " " + end + " " + min;
        }
    }

    private void breakAndAdd(Segment segment, Queue<Segment> q, int[] nums){
        int st = -1;
        int end = -1;
        int min = -1;

        for(int i = segment.st; i <= segment.end; i++){
            if(nums[i] != segment.min){
                if(st == -1){
                    st = i;
                    end = i;
                    min = nums[i];
                }
                else{
                    end = i;
                    min = Math.min(min, nums[i]);
                }
            }
            else{
                if(st != -1){
                    q.add(new Segment(st, end, min));
                    st = -1;
                }
            }
        }
        if(st != -1){
            q.add(new Segment(st, end, min));
        }
    }

    public int minOperations(int[] nums) {
        int n = nums.length;
        int result = 0;
        Queue<Segment> q = new ArrayDeque<>();

        int st = -1;
        int min = -1;
        int end = -1;

        for(int i = 0; i < n; i++){
            if(nums[i] != 0){
                if(st == -1){
                    st = i;
                    end = i;
                    min = nums[i];
                }
                else{
                    end = i;
                    min = Math.min(min, nums[i]);
                }
            }
            else{
                if(st != -1){
                    q.add(new Segment(st, end, min));
                    st = -1;
                }
            }
        }
        if(st != -1){
            q.add(new Segment(st, end, min));
        }

        // System.out.println(q);

        while(!q.isEmpty()){
            Segment seg = q.remove();
            // System.out.println(seg);
            result++;
            breakAndAdd(seg, q, nums);
        }

        return result;
    }
}



// tc - O(n), sc - O(n)
class Solution {
    public int minOperations(int[] nums) {
        int n = nums.length;
        int result = 0;
        Stack<Integer> st = new Stack<>();

        for(int i : nums){
            while(!st.isEmpty() && st.peek() > i){
                st.pop();
            }
            if(i == 0) continue;
            if(st.isEmpty() || st.peek() < i){
                result++;
                st.push(i);
            }
        }
        return result;
    }
}