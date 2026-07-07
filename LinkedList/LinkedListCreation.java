class Node{
    int val ;
    Node next;
    Node(int val){
        this.val = val;
    }
}

public class LinkedListCreation {

    static void  displayrecur(Node head){
            if (head == null) return ;
            System.out.print(head.val);
            displayrecur(head.next);
            
        }
            
    public static void main(String[] args) {

        
        Node a = new Node(1);
        Node b = new Node(2);
        Node c = new Node(3);
        Node d = new Node(4);
        Node e = new Node(5);
        Node f = new Node(6);
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        e.next = f;
        Node temp = a;
        // while(temp != null){
        //     System.out.print(temp.val + " ");
        //     temp = temp.next;
        // }
        displayrecur(a);
    }
}
