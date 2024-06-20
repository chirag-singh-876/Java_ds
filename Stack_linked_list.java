public class Stack_linked_list {
    static class Node{
        int data;
        Node next;
        Node(int data){
            this.data = data;
            this.next = null;
        }
    }
    
    static class Stack{
        static Node head = null;

        public static boolean isEmpty(){
            return head == null;
        }
        //push
        public static void push(int data){
            Node newHead = new Node(data);
            if(isEmpty()){
                head = newHead;
                return;
            }
            newHead.next = head;
            head = newHead;
        }
        //pop
        public static int pop(){
            if(isEmpty()) return -1;
            int value = head.data;
            head = head.next;
            return value;
        }
        //peek
        public static int peek(){
            if(isEmpty()) return -1;
            return head.data;
        }
    }
    public static void main(String[] args) {
        Stack lls = new Stack();
        lls.push(1);
        lls.push(2);
        lls.push(3);
        //3->2->1->null
        while(!lls.isEmpty()){
            System.out.println(lls.peek());
            lls.pop();
        }
    }
}
