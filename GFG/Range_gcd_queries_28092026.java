package GFG;

// tc - build - O(n), update & query - O(logn)
// tc - O(n) + O(q*logn)
// sc - O(n)
class Solution {
    class SegmentTree {
        int[] segTree;

        public SegmentTree(int[] arr) {
            int n = arr.length;
            segTree = new int[n * 4];

            build(0, 0, n-1, arr);
        }

        void build(int i, int l, int r, int[] arr) {
            if(l == r) {
                segTree[i] = arr[l];
                return;
            }

            int mid = l + (r - l) / 2;

            build(2*i+1, l, mid, arr);
            build(2*i+2, mid+1, r, arr);

            segTree[i] = gcd(segTree[2*i+1], segTree[2*i+2]);
        }

        int gcd(int a, int b) {
            if (b == 0) return a;
            if(a % b == 0) return b;

            return gcd(b, a%b);
        }

        int query(int i, int l, int r, int st, int end) {
            if(st <= l && end >= r) return segTree[i];
            if(end < l || r < st) return 0;

            int mid = l + (r - l) / 2;

            if(end <= mid) return query(2*i+1, l, mid, st, end);
            if(st > mid) return query(2*i+2, mid+1, r, st, end);

            int left = query(2*i+1, l, mid, st, end);
            int right = query(2*i+2, mid+1, r, st, end);

            return gcd(left, right);
        }

        int update(int i, int l, int r, int idx, int val) {
            if(idx < l || r < idx) return segTree[i];
            if(l == r) {
                segTree[i] = val;
                return val;
            }

            int mid = l + (r - l) / 2;

            if(idx <= mid) update(2*i+1, l, mid, idx, val);
            else update(2*i+2, mid+1, r, idx, val);

            return segTree[i] = gcd(segTree[2*i+1], segTree[2*i+2]);
        }
    }

    public ArrayList<Integer> processQueries(int[] arr, int[][] queries) {
        int n = arr.length;
        SegmentTree tree = new SegmentTree(arr);
        ArrayList<Integer> list = new ArrayList<>();

        for(int[] query : queries) {
            if(query[0] == 0) {
                list.add(tree.query(0, 0, n-1, query[1], query[2]));
            }
            else tree.update(0, 0, n-1, query[1], query[2]);
        }
        return list;
    }
}
