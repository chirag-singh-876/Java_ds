import java.util.*;
public class heap_for_priorityQueue {
    static class Heap{
        ArrayList<Integer> arr = new ArrayList<>();

        public  void add(int data){  //O(logn)
            //add at last idx
            arr.add(data);
            int child_idx = arr.size()-1;
            int parent_idx  = (child_idx-1)/2;

            while(arr.get(child_idx)<arr.get(parent_idx) ){  //O(logn)
                //swapping
                int temp = arr.get(child_idx);
                arr.set(child_idx,arr.get(parent_idx));
                arr.set(parent_idx,temp);

                // updating index
                child_idx = parent_idx;
                parent_idx = (child_idx-1)/2;
            }
        }
        public int peek(){
            return arr.get(0);
        }
        private void heapify(int i ){    //O(logn)
            int left = 2*i + 1;
            int right = 2*i + 2;
            int minidx = i;

            if(left < arr.size() && arr.get(left) < arr.get(minidx))  minidx = left;
            if(right < arr.size() && arr.get(right) < arr.get(minidx))  minidx = right;

            if(minidx != i){
                //swap
                int temp = arr.get(i);
                arr.set(i,arr.get(minidx));
                arr.set(minidx,temp);

                heapify(minidx);
            }
            else return;  // actually not required
        }
        public int remove(){
            int data = arr.get(0);
            
            //step-1 : swap 1st and last no.
            arr.set(0,arr.get(arr.size()-1));
            arr.set(arr.size()-1,data); // in actual no need to do this

            //step 2 : delete last element
            arr.remove(arr.size()-1);
            //step 3 : heapify
            heapify(0);
            return data;
        }
        public boolean isEmpty(){
            return arr.size() == 0;
        }
    }
    public static void main(String[] args) {
        Heap hp = new Heap();
        hp.arr.add(2);  // can hp.add(2) also
        hp.add(3);
        hp.add(4);
        hp.add(5);
        hp.add(10);
        for(int i=0;i<hp.arr.size();i++) System.out.print(hp.arr.get(i)+" ");
        hp.add(1);
        System.out.println();
        for(int i=0;i<hp.arr.size();i++) System.out.print(hp.arr.get(i)+" ");

        System.out.println();
        while(!hp.isEmpty()){
            System.out.println(hp.remove());
        }
    }
}
   