package GFG;

// tc - O(n), sc - O(1)
class Solution {
    private int getLength(Node temp){
        int size = 0;
        while(temp != null){
            temp = temp.next;
            size++;
        }
        return size;
    }

    public Node intersectPoint(Node head1, Node head2) {
        int len1 = getLength(head1);
        int len2 = getLength(head2);

        if(len2 > len1){
            int extra = len2 - len1;
            for(int i = 0; i < extra; i++) head2 = head2.next;
        }

        if(len1 > len2){
            int extra = len1 - len2;
            for(int i = 0; i < extra; i++) head1 = head1.next;
        }

        while(head1 != head2){
            head1 = head1.next;
            head2 = head2.next;
        }
        return head1;
    }
}
