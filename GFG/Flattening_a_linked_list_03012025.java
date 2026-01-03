package GFG;

// tc - O(n*log(len)) where n is total number of nodes and len is length of linked list
// sc - O(len)
class Solution {
    public Node flatten(Node root) {
        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> {
            return a.data-b.data;
        });

        Node dummyHead = new Node(-1);
        Node temp = root;

        while(temp != null){
            pq.add(temp);
            temp = temp.next;
        }
        temp = dummyHead;

        while(!pq.isEmpty()){
            Node node = pq.remove();
            temp.bottom = node;
            node.next = null;
            if(node.bottom != null) pq.add(node.bottom);
            temp = temp.bottom;
        }

        return dummyHead.bottom;
    }
}

