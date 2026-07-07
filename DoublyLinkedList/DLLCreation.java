
class ListNode {
    int val;
    ListNode next;
    ListNode prev;
    ListNode(){}
    ListNode(int val){ this.val = val;}
}



public class DLLCreation {
    static void displayViaHead(ListNode head){
    while(head!=null){
        System.out.println(head.val);
        head=head.next;
    }
}

static void displayViaTail(ListNode tail){
    while(tail!=null){
        System.out.println(tail.val);
        tail =tail.prev;
    }
}
    public static void main(String[] args) {
    
    ListNode a  = new ListNode(10);
    ListNode b  = new ListNode(50);
    ListNode c  = new ListNode(100);
    a.next = b;
    b.prev = a;
    c.prev = b;
    b.next = c;
    displayViaHead(a);
    displayViaTail(c);

    }
}
