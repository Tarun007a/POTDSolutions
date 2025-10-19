package GFG;



// time - O(n) sc -O(n)
// class Solution {
//     private void inOrder(Node root, ArrayList<Integer> list){
//         if(root == null) return;

//         inOrder(root.left, list);
//         list.add(root.data);
//         inOrder(root.right, list);
//     }

//     private int getDiff(int a, int b){
//         return Math.abs(a-b);
//     }

//     public ArrayList<Integer> getKClosest(Node root, int target, int k) {
//         ArrayList<Integer> list = new ArrayList<>();

//         inOrder(root, list);


//         int idx = 0;
//         int min = target-list.get(0);
//         int n = list.size();

//         for(int i = 0; i < n; i++){
//             if(getDiff(list.get(i), target) < min){
//                 idx = i;
//                 min = getDiff(list.get(i), target);
//             }
//         }

//         ArrayList<Integer> result = new ArrayList<>();
//         result.add(list.get(idx));
//         int left = idx-1;
//         int right = idx+1;
//         int ele = 1;

//         while(left >= 0 && right < n && ele < k){
//             if(getDiff(list.get(left), target) <= getDiff(list.get(right), target)){
//                 result.add(list.get(left));
//                 left--;
//             }
//             else{
//                 result.add(list.get(right));
//                 right++;
//             }
//             ele++;
//         }

//         while(ele < k && left >= 0){
//             result.add(list.get(left));
//             left--;
//             ele++;
//         }

//         while(ele < k && right < n){
//             result.add(list.get(right));
//             right++;
//             ele++;
//         }
//         return result;
//     }
// }



// Better one time - O(n) and space O(n)
class Solution {
    private void inOrder(Node root, int k, int target, Deque<Integer> dq){
        if(root == null) return;

        inOrder(root.left, k, target, dq);

        if(dq.size() < k) dq.add(root.data);
        else if(getDiff(dq.getFirst(), target) > getDiff(root.data, target)){
            dq.removeFirst();
            dq.add(root.data);
        }

        inOrder(root.right, k, target, dq);
    }

    private int getDiff(int a, int b){
        return Math.abs(a-b);
    }

    public ArrayList<Integer> getKClosest(Node root, int target, int k) {
        Deque<Integer> dq = new ArrayDeque<>();

        inOrder(root, k, target, dq);
        ArrayList<Integer> result = new ArrayList<>();
        while(!dq.isEmpty()){
            result.add(dq.removeFirst());
        }
        return result;
    }
}

