//package hashing;
import java.util.ArrayList;
import java.util.LinkedList;
public class hashmap_implemntation {
    static class HashMap<K,V>{ // K and V are genric  here
        private class Node{
            K key;
            V value;
            public Node (K key, V value){
                this.key = key;
                this.value = value;
            }
        }
        private int n; //n is total number of nodes we have
        private LinkedList<Node> buckets[];
        private int N; //N is length of bucket array(always = buckets.length)
        @SuppressWarnings("unchecked")
        public HashMap() {
            this.n = 0;
            this.buckets = new LinkedList[4];
            this.N = 4;
            for(int i=0;i<4;i++){
                this.buckets[i] = new LinkedList<>();
            }
        }

        private int hashFunction(K key){
            int hc = key.hashCode();
            return Math.abs(hc)%buckets.length;
        }

        private int SearchInLL(K key,int bi){
            LinkedList<Node> ll = buckets[bi];
            int di = 0;

            for(int i=0;i<ll.size();i++){
                Node node = ll.get(i);
                if(node.key == key) return di;
                di++;
            }
            return -1;
        }

        @SuppressWarnings("unchecked")
        private void rehash (){

            //storing old nodes in 'oldbuck' and reintializing the bucket
            LinkedList<Node> oldbuck[] = buckets;
            N = 2*N;
            n = 0;
            buckets = new LinkedList[N];
            for(int i=0;i<buckets.length;i++) buckets[i] = new LinkedList<>();

            //storing old data(nodes) in new intialized bucket
            for(int i=0;i<oldbuck.length;i++){
                LinkedList<Node> ll = oldbuck[i];
                for(int j=0;j<ll.size();j++){
                    Node node = ll.get(j);
                    put(node.key,node.value);
                }
            }
        }
        public void put (K key,V value){
            int bi = hashFunction(key);
            int di = SearchInLL(key,bi);
            if(di != -1) {
                Node node = buckets[bi].get(di);
                node.value = value;
            }
            else{
                buckets[bi].add(new Node(key,value));
                n++;
            }
            double lambda = (double)n/N;
            if(lambda >2.0){
                rehash();
            }
        }
        public boolean containsKey(K key){
            int bi = hashFunction(key);
            //LinkedList<Node> ll = buckets[bi];
            // for(int j=0;j<ll.size();j++){
            //     if(ll.get(j).key == key) return true;
            // }
            // return false;
            return SearchInLL(key, bi) != -1;  
        }
        public V get(K key){
            int bi = hashFunction(key);
            int di = SearchInLL(key, bi);

            if(di != -1) return buckets[bi].get(di).value;
            return null;
        }
        public V remove(K key){
            int bi = hashFunction(key);
            int di = SearchInLL(key, bi);
            if(di == -1) return null;

            LinkedList<Node> ll = buckets[bi];
            V value = ll.get(di).value;
            ll.remove(di); 
            n--;
            return value;
        }
        public ArrayList<K> keySet(){
            ArrayList<K> keys = new ArrayList<>();
            for(int i=0;i<buckets.length;i++){
                LinkedList<Node> ll = buckets[i];
                // for(int j=0;j<ll.size();j++){
                //     keys.add(ll.get(j).key);
                // }
                for(Node nd : ll){
                    keys.add(nd.key);
                }
            }
            return keys;
        }
        public  boolean isEmpty(){
            return n == 0;
        }
        public int size(){
            return n;
        }
    }
  public static void main(String[] args) {
        HashMap<String,Integer> hm = new HashMap<>();
        hm.put("india",120);
        hm.put("china",150);
        hm.put("nepal",50);
        hm.put("indo",120);
        hm.put("calicut",150);
        hm.put("newyork",50);
        hm.put("eng",120);
        hm.put("a",150);
        hm.put("b",50);
        //hm.put("c",120);
        //hm.put("d",150);
        //hm.put("e",50);
        ArrayList<String> keys = hm.keySet();
        System.out.println(keys);
        System.out.println(hm.n);
        System.out.println(hm.containsKey("india"));
        System.out.println(hm.get ("india"));
        System.out.println(hm.remove("india"));
  }  
}
