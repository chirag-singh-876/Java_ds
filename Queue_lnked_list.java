
public class Queue_lnked_list {
    static class Node{
        int data;
        Node next;
        Node(int data){
            this.data = data;
            this.next = null;
        }
    }
    static class QueLL{
        static Node head = null;
        static Node tail = null;
        public static boolean isEmpty(){
            return head == null;
        }
        public static void add(int data){
            Node newnode = new Node(data);
            if(isEmpty()) head = tail = newnode;
            else{
                tail.next = newnode;
                tail = newnode;
            }
        }
        public static int remove(){
            if(isEmpty()){
                System.out.println("Queue is empty");
                return -1;
            }
            int data = head.data;
            if(head==tail) head = tail = null; //if single element is there
            else head = head.next;
            return data;
        }
        public static int peek(){
            if(isEmpty()){
                System.out.println("Queue is empty");
                return -1;
            }
            return head.data;
        }
    }
    public static void main(String[] args) {
        QueLL q = new QueLL();
        q.add(1);
        q.add(2);
        q.add(3);
        System.out.println(q.remove());
        q.add(4);
        System.out.println(q.remove());
        q.add((5));
        while(!q.isEmpty()){
            System.out.println(q.remove());
        }
    }
}
    
