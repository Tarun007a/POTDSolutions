package GFG;

// tc - o(klogn), sc - O(n)
class Solution {
    public int maxAmount(int[] arr, int k) {
        int result = 0;
        int mod = 1000_000_007;
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b-a);
        for(int num : arr) pq.add(num);

        while(k != 0) {
            k--;
            int price = pq.remove();
            if(price <= 0) break;

            result = (result + price) % mod;
            pq.add(price-1);
        }
        return result;
    }
}