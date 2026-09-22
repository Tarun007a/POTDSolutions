package Leetcode;

// code story with mik
// leetcode - 3525
// tc - O(q.log(n)), sc - O(n)
class Solution {
    class Node {
        int product;
        int[] count;

        public Node(int product) {
            this.product = product;
            count = new int[5];
        }
    }

    class SegmentTree {
        Node[] segTree;
        int n;
        int k;

        public SegmentTree(int[] nums, int k) {
            n = nums.length;
            segTree = new Node[n*4];
            this.k = k;

            buildSegTree(0, 0, n-1, nums);
        }

        public void buildLeaf(int idx, int val) {
            Node curr = new Node(val%k);

            for(int i = 0; i < 5; i++) curr.count[i] = 0;
            curr.count[val%k] = 1;

            segTree[idx] = curr;
        }

        public void update(int idx, int val) {
            updateSegTree(0, 0, n-1, idx, val);
        }

        public Node mergeNode(Node node1, Node node2) {
            Node node = new Node((node1.product * node2.product) % k);

            for(int i = 0; i < 5; i++) node.count[i] = node1.count[i];
            for(int i = 0; i < 5; i++) {
                int newRem = (node1.product * i) % k;
                node.count[newRem] += node2.count[i];
            }
            return node;
        }

        public void updateSegTree(int i, int st, int end, int idx, int val) {
            if(st == end) {
                buildLeaf(i, val);
                return;
            }

            int mid = st + (end - st) / 2;
            if(idx <= mid) updateSegTree(2*i+1, st, mid, idx, val);
            else updateSegTree(2*i+2, mid+1, end, idx, val);

            segTree[i] = mergeNode(segTree[2*i+1], segTree[2*i+2]);
        }

        public void buildSegTree(int idx, int st, int end, int[] nums) {
            if(st == end) {
                buildLeaf(idx, nums[st]);
                return;
            }

            int mid = st + (end - st) / 2;

            buildSegTree(2*idx+1, st, mid, nums);
            buildSegTree(2*idx+2, mid+1, end, nums);

            segTree[idx] = mergeNode(segTree[2*idx+1], segTree[2*idx+2]);
        }

        public Node querySegTree(int i, int st, int end, int l, int r) {
            if(st >= l && end <= r) return segTree[i];

            int mid = st + (end - st) / 2;

            if(r <= mid) return querySegTree(2*i+1, st, mid, l, r);
            else if(l > mid) return querySegTree(2*i+2, mid+1, end, l, r);

            Node left = querySegTree(2*i+1, st, mid, l, r);
            Node right = querySegTree(2*i+2, mid+1, end, l, r);

            return mergeNode(left, right);
        }

        public Node query(int l, int r) {
            return querySegTree(0, 0, n-1, l, r);
        }

    }

    public int[] resultArray(int[] nums, int k, int[][] queries) {
        int n = nums.length;
        int q = queries.length;

        SegmentTree segTree = new SegmentTree(nums, k);

        int[] result = new int[q];

        for(int i = 0; i < q; i++) {
            int idx = queries[i][0];
            int val = queries[i][1];
            int st = queries[i][2];
            int x = queries[i][3];

            segTree.update(idx, val);

            Node node = segTree.query(st, n-1);
            result[i] = node.count[x];
        }
        return result;
    }
}