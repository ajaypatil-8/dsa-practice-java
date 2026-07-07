
class DoublyLL{
    ListNode head ;
    ListNode tail;
    int size;
    
    void displayViaHead(ListNode head){
    while(head!=null){
        System.out.print(head.val + " ");
        head=head.next;
    }
    System.out.println();
}
    void displayViaTail(ListNode tail){
    while(tail!=null){
        System.out.print(tail.val + " ");
        tail =tail.prev;
    }
    System.out.println();
}
    void addAtHead(int val){
        ListNode temp = new ListNode(val);
        if(head==null) head = tail = temp;
        else{
            temp.next = head ;
            head.prev = temp;
            head = temp;
        }
        size ++;
    }
    void addAtTail(int val){
        ListNode temp = new ListNode(val);
        if(head==null) head = tail = temp;
        else{
            tail.next = temp;
            temp.prev = tail;
            tail = temp;
        }
        size ++;
    }
    void rmAtHead(){
        if(head==null) return;
        if(size == 1){
            head = null;
            tail = null;
        }
        else{
            head = head.next;
            head.prev = null;
        }
        size--;
    }
    void rmAtTail(){
        if(head==null ) return ;
        if(size == 1){
            head = null;
            tail = null;
        }
        else{
            tail = tail.prev;
            tail.next =null;
        }
        size--;
    }
    void addAtIndex(int val , int idx){
        if(idx>size || idx<0){
            System.out.println("You have entered a negative index or index greater than size of LinkedList");
            return ;
        }
        if(idx == 0){
            addAtHead(val);
            return;
        }
        if(idx==size ){
             addAtTail(val);
              return ;
        }
        ListNode temp = head ;
        ListNode a = new ListNode(val);
        for(int i = 1 ; i<idx ; i++){
            temp = temp.next;
        }
        a.prev = temp;
        a.next = temp.next;
        temp.next = a;
        a.next.prev =  a;

        size++;
    }
    void rmAtIndex(int idx){
        if(idx==size-1){
             rmAtTail();
             return ;
        }
        if(idx==0){
             rmAtHead();
             return ;
        }
        ListNode temp = head ;
        for(int i = 0 ; i<idx ; i++){
            temp = temp.next;
        }
        temp.prev.next = temp.next;
        temp.next.prev = temp.prev;

        size--;

    }
}

public class DLLFunctions {
    public static void main(String[] args) {
        DoublyLL a = new DoublyLL();
        a.addAtIndex(0, 0);
        a.addAtIndex(1, 0);
        a.addAtHead(10);
        a.addAtHead(20);
        a.displayViaHead(a.head);
        a.rmAtIndex(2);
        a.rmAtIndex(2);
        a.rmAtIndex(0);
        a.rmAtIndex(0);
        a.displayViaHead(a.head);
        System.out.println(a.size);


        
    }
}
