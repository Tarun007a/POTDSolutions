package GFG;

// tc & sc - O(n)

// We use a stack to store the path from the root to the current node.
// The variable 'root' represents the last ancestor whose right subtree
// we have entered.
//
// Once we move to the right subtree of a node, every future value must be
// greater than that node. Therefore, if we ever encounter a value smaller
// than 'root', the preorder sequence cannot represent a BST.
//
// Algorithm:
// 1. Initialize root = Integer.MIN_VALUE.
// 2. Traverse the preorder array.
// 3. If the current value < root, return false.
// 4. While the stack is not empty and the current value > stack.peek():
//      - Pop the stack.
//      - Update root to the popped value, indicating that we are now in
//        the right subtree of that node.
// 5. Push the current value onto the stack.
// 6. If the traversal finishes without violating the BST property,
//    return true.
class Solution {
    public boolean canRepresentBST(List<Integer> arr) {
        Stack<Integer> st = new Stack<>();
        int root = -1000000;

        for(int ele : arr) {
            if(ele < root) return false;

            while(!st.isEmpty() && ele > st.peek()) root = st.pop();

            st.push(ele);
        }
        return true;
    }
}
