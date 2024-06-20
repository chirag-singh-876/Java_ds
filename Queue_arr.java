public class que_1 {
    static class Queue_arr{
        static int arr[];
        static int size;
        static int rear;
        Queue(int n){
            arr = new int[n];
            size = n;
            rear = -1;
        }
        public static boolean isEmpty(){
            return rear == -1;
        }
        public static void add(int data){
            if(rear == size-1){
                System.out.println("queue is full");
                return;
            }
            rear += 1;
            arr[rear] = data;
        }
        public static int remove(){
            if(isEmpty()){
                System.out.println("Queue is empty");
                return -1;
            }
            int a = arr[0];
            for(int i=0;i<rear;i++) arr[i] = arr[i+1];
            rear -= 1;
            return a;

        }
        public static int peek(){
            if(isEmpty()){
                System.out.println("Queue is empty");
                return -1;
            }
            return arr[0];
        }
    } 
    static class Circular_qu{
        static int arr[];
        static int size;
        static int front;
        static int rear;
        Circular_qu(int n){
            arr = new int[n];
            size = n;
            front = -1;
            rear =  -1;
        }
        public static boolean isEmpty(){
           return rear == -1 && front ==-1;
        }
        public static boolean isFull(){
            return (rear+1)%size == front;
        }
        public static void add(int data){
            if(isFull()){
                System.out.println("Queue is full");
                return;
            }
            if(front==-1) front = 0;
            rear =(rear+1)%size;
            arr[rear] = data;
        }
        public static int remove(){
            if(isEmpty()){
                System.out.println("Queue is empty");
                return -1;
            }
            int data = arr[front];
            if(front==rear) front = rear = -1;
            else front = (front+1)%size;
            return data;
        }
        public static int peek(){
            if(isEmpty()){
                System.out.println("Queue is empty");
                return -1;
            }
            return arr[front];
        }
    }
    public static void main(String[] args) {
        Circular_qu q = new Circular_qu(3);
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
