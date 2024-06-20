import java.util.*;
public class dubly_linked_list{
    public class Node{
        int data;
        Node next;
        Node prev;
        public Node(int data){
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }
    public static Node head;
    public static Node tail;

    public void addfirst(int data){
        Node newHead = new Node(data);
        if(head == null){
            head = tail = newHead;
            return;
        }
        newHead.next = head;
        head.prev = newHead;
        newHead.prev = null;
        head = newHead;
    }
    public void removefirst(){
        if(head == null) return;
        if(head.next == null) head = null;
        head = head.next;
        head.prev = null;
    }

    public Node reverse(Node head){
        if(head == null || head.next == null) return head;
        Node prev = head;
        Node curr = head.next;
        Node nxt = curr;
        head.next = null;
        while(curr != null){
            nxt = curr.next;
            curr.next = prev;
            prev.prev = curr;
            prev = curr;
            curr = nxt;
        }
        return prev;
    }
    public static void printLL(Node head){
            Node temp = head;
            while(temp != null){
                System.out.print(temp.data+"->");
                temp = temp.next;
            }
            System.out.println("null");
    }
    public static void main(String[] args) {
        dublyLL dll = new dublyLL();
        dll.addfirst(3);
        dll.addfirst(2);
        dll.addfirst(1);
        dll.removefirst();
        dublyLL.printLL(head);
        head =  dll.reverse(dll.head);
        printLL(dublyLL.head);
    }

}
