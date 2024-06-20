import java.util.*;
public class LinkedList{
    public static class Node{
        int data;
        Node next;
        public Node(int data){
            this.data = data;
            this.next = null;
        }
    }

    public static Node head;
    public static Node tail;
    public static int size;

    public void addfirst(int data){ //O(1)
        size++;
        Node newhead = new Node(data);
        if(head==null){
            head = tail = newhead;
            return;
        }
        newhead.next = head; //new head point to previous head
        head = newhead; //assigning newhead the head
    }
    public void addlast(int data){ //O(1)
        size++;
        Node newtail = new Node(data);
        if(head==null){
            head = tail = newtail;
            return;
        }
        tail.next = newtail;
        tail = newtail;
    }
     public void addMiddle(int index,int data){
        if(index == 0){
            addfirst(data);
            return;
        }
        size++;
        Node temp = head;
        Node newnode = new Node(data);
        for(int i =0;i<index-1;i++) temp = temp.next; //after completion of lope temp is at previous index 
        //temp is prev.
        newnode.next = temp.next;
        temp.next = newnode;
    }
    public int removefirst(){ //O(1)
        if(size==0){
            System.out.println("LL is empty");
            return Integer.MIN_VALUE;
        } else if(size==1){
            size--;
            int val = head.data;
            head = tail= null;
            return val;
        }
        size--;
        int val = head.data;
        head = head.next;
        return val;
    }
    public int removelast(){
        if(size==0){
            System.out.println("LL is empty");
            return Integer.MIN_VALUE;
        } else if(size==1){
            size--;
            int val = head.data;
            head = tail= null;
            return val;
        }
        Node temp = head;
        for(int i=0;i<size-2;i++) temp = temp.next; //tmep is at size-2 index
        int val = temp.next.data; //stores last tail value
        temp.next  = null;
        tail = temp;
        size--;
        return val;
    }
    public int itr_search(int key){ //O(n)
        Node temp = head;
        int index = 0;
        while(temp != null){
            if(temp.data == key) return index;
            index++;
            temp = temp.next;
        }
        return -1; //key not found
    }
    public int rec_search(int key){
        return helper(head,key,0);
    }
    public int helper(Node head,int key,int idx){ //O(n)
        if(head==null) return -1;
        if(head.data==key){
            return idx;
        }
        return helper(head.next, key,idx+1);
    }
    public void revrse_ll(){  //O(n)
        if(head==null||head.next==null) return;
        Node prev = head;
        Node curr = head.next;
        Node nxt = curr;
        head.next = null;
        while(curr!=null){
            nxt = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nxt;
        }
        tail = head;
        head = prev;
    }
   
    public void print_linklist(Node head){ //O(n)
        if(head==null){
            System.out.println("Linked List is empty");
            return;
        }
        Node temp_node = head;
        while(temp_node!=null){
            System.out.print(temp_node.data+"-> ");
            temp_node = temp_node.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        LinkedList_1 l1 = new LinkedList_1();
        l1.addfirst(0);
        //addfirst:-
        l1.addfirst(-1);
        //addlast:-
        l1.addlast(1);
        l1.print_linklist(l1.head);
        //add in middle:-
        l1.addMiddle(1, 2);
        l1.print_linklist(l1.head);
        System.out.println(l1.size);
        //removefirst
        l1.removefirst();
        l1.print_linklist(head);
        System.out.println(l1.size);

        //removelast
        l1.removelast();
        l1.print_linklist(head);
        System.out.println(size);

        l1.addfirst(-4);
        l1.addfirst(-5);
        l1.addlast(7);
        //search:-
        l1.print_linklist(l1.head);
        System.out.println(l1.itr_search(0));
        System.out.println(l1.itr_search(6));
        System.out.println(l1.rec_search(0));
        System.out.println(l1.rec_search(6));

        //revesing LL:-
        System.out.println("before reverse");
        l1.print_linklist(head);
        l1.revrse_ll();
        System.out.println("after reverse");
        l1.print_linklist(head);
    }
}
