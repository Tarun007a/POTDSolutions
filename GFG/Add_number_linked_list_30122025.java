package GFG;

// tc - O(n), sc - O(1)
class Solution {
    static Node reverse(Node head){
        Node prev = null;
        Node curr = head;
        Node next = head;

        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    static Node removeZeros(Node head){
        while(head != null && head.data == 0)head = head.next;
        return head;
    }

    static Node addTwoLists(Node num1, Node num2) {
        Node head1 = removeZeros(num1);
        Node head2 = removeZeros(num2);

        Node result = new Node(0);
        Node temp = result;

        int carry = 0;
        head1 = reverse(head1);
        head2 = reverse(head2);

        while(head1 != null || head2 != null || carry != 0){
            int sum = 0;
            if(head1 != null && head2 != null){
                sum = head1.data + head2.data + carry;
                Node next = new Node(sum%10);
                carry = sum/10;
                temp.next = next;
                temp = next;
                head1 = head1.next;
                head2 = head2.next;
            }
            else if(head2 != null){
                sum = head2.data + carry;
                Node next = new Node(sum%10);
                carry = sum/10;
                temp.next = next;
                temp = next;
                head2 = head2.next;
            }
            else if(head1 != null){
                sum = head1.data + carry;
                Node next = new Node(sum%10);
                carry = sum/10;
                temp.next = next;
                temp = next;
                head1 = head1.next;
            }
            else{
                temp.next = new Node(carry);
                carry = 0;
            }
        }
        return reverse(result.next);
    }
}



