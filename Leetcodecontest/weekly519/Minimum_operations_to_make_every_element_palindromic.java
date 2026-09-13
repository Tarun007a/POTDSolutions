package Leetcodecontest.weekly519;

class Solution {
    static List<Long> even;
    static List<Long> odd;
    private static List<Long> generate() {
        List<Long> result = new ArrayList<>();

        for(long i = 0; i < 10; i++) result.add(i);

        for(long i = 1; i <= 10000; i++) {
            long reverse = 0;

            long temp = i;
            long newNum = i;

            while(temp != 0) {
                newNum = newNum * 10;
                reverse = reverse * 10 + temp%10;
                temp /= 10;
            }
            result.add(newNum + reverse);

            for(long j = 0; j < 10; j++) {
                long curr = i * 10 + j;

                temp = i;

                while(temp != 0) {
                    curr *= 10;
                    temp /= 10;
                }
                result.add(curr + reverse);
            }
        }

        result.add(10000000001l);
        result.add(20000000002l);

        return result;
    }

    static {
        List<Long> numbers = generate();
        even = new ArrayList<>();
        odd = new ArrayList<>();

        for(long ele : numbers) {
            if(ele%2 == 0) even.add(ele);
            else odd.add(ele);
        }

        Collections.sort(even);
        Collections.sort(odd);
    }

    private long lowerBound(long num, List<Long> list) {
        int lo = 0;
        int hi = list.size()-1;
        long result = 0;

        while(lo <= hi) {
            int mid = (lo + hi) / 2;

            if(list.get(mid) <= num) {
                result = list.get(mid);
                lo = mid+1;
            }
            else hi = mid-1;
        }
        return result;
    }

    private long upperBound(int num, List<Long> list) {
        int lo = 0;
        int hi = list.size()-1;
        long result = 0;

        while(lo <= hi) {
            int mid = (lo + hi) / 2;

            if(list.get(mid) >= num) {
                result = list.get(mid);
                hi = mid-1;
            }
            else lo = mid+1;
        }
        return result;
    }

    public long minOperations(int[] nums) {
        long result = 0;

        for(int num : nums) {
            long left, right;
            if(num%2 == 0) {
                left = lowerBound(num, even);
                right = upperBound(num, even);
            }
            else {
                left = lowerBound(num, odd);
                right = upperBound(num, odd);
            }

            // System.out.println(left + " " + right + " " + num);
            long min = Math.min(num-left, right-num);
            result += (long)min/2;
        }

        return result;
    }
}