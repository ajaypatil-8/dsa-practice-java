class LL{
    Node head ;
    Node tail;
    int size ;

    void addAtTail( int val){
        Node temp = new Node(val);
        if(head==null) head = tail = temp ;
        else{
            tail.next = temp;
            tail = temp ;
        }
        size++;
    }
    
    void addAtHead(int val ){
        
        Node temp = new Node(val);
        if(head == null) head = tail = temp   ;
        else {
        temp.next = head ;
        head = temp ;
        }
        size++;
    }
    
    void rmAtHead(){
        if (head==null){
            System.out.println("list is empty ");
            return;
        }
        head = head.next;
        if(head==null) tail = null ;
        size--;
    }

    void displayll(){
        if(head==null) return;
        Node temp = head ;
        while(temp!= null){
            System.out.print(temp.val + " ");
            temp=temp.next;
        }
        System.out.println();
    }

    int search (int val ){
        if(head==null) return -1;
        Node temp = head ;
        int idx = 0 ;
        while(temp!=null){
            if(temp.val == val)  return idx;
            temp = temp.next;
            idx++;
        }
        return -1;
    }

    void insert (int val  , int idx ){
        if( ( head == null && idx<size ) || idx ==0 ){
            addAtHead(val);
            return;
        }
        else if (idx==size){
            addAtTail(val); 
        }
         else if (idx > size || idx < 0){
         System.out.println("idx is greater than size of linkedlist or it is negative "); 
        }
        else {
        Node a = new Node(val);
        Node temp = head ;
        for(int  i  = 1 ; i<idx ; i++){
            temp = temp.next;
        }
        a.next = temp.next;
        temp.next = a ;
        size++;
        }
    }

    void rmAtIdx(int idx ){
        if(idx==0) rmAtHead();
        else if(!(idx<size) || idx < 0 ) System.out.println("You have given Negative or a larger index than size of linkedlist");
        else {
            Node temp = head ;
            for(int i = 1 ; i<idx ; i++){
                temp = temp.next;
            }
            temp.next = temp.next.next;
            if(idx==size-1) tail = temp;
        }
        
        size--;
    }
}



public class LinkedListfunctions {
    
    public static void main(String[] args) {
        LL l1 = new LL();
        l1.insert(0, 0);
        l1.insert(1, 1);
        l1.addAtTail(2);
        l1.addAtTail(3);
        l1.addAtTail(4);
        l1.addAtTail(5);
        l1.displayll();
        l1.rmAtIdx(5);
        l1.rmAtIdx(4);
        l1.rmAtIdx(0);
        l1.displayll();

        
         
        
        
    }
}
//  10 20 30 