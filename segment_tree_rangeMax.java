public class segment_tree_rangeMax {
    static class Segment_tree{
        
        // responding query
        public  long rangesum(int qs,int qe){
            return rangesumutil(0, n-1, qs, qe,0);
        }
        private long rangesumutil(int si,int ei,int qs,int qe,int idx){
            if(qe<si || qs>ei) return 0;  
            else if(si>=qs && ei<=qe) return seg_arr[idx];
            int mid = (si+ei)/2;
            long left =  rangesumutil(si, mid, qs, qe, 2*idx+1);
            long right = rangesumutil(mid+1, ei, qs, qe, 2*idx+2);
            return  Math.max(left, right);
        }
        
        // updating the query
        public void update(int idx,long val){
            //long diff = val-rangesum(idx,idx);
            updateutil(0,n-1,0,idx,val);
        }
        private void updateutil(int si,int ei,int idx,int ith,long val){
            if(ith<si || ith>ei) return;
            if(si == ei){
               seg_arr[idx] = val;
                return;
            }
            //seg_arr[idx] = Math.max(seg_arr[idx], val);  // this is wrong
            int mid = (si+ei)/2;
            updateutil(si, mid, 2*idx+1, ith, val);
            updateutil(mid+1, ei, 2*idx+2, ith, val);
            seg_arr[idx] = Math.max(seg_arr[2*idx+1],seg_arr[2*idx+2]);
        }
        long seg_arr[];
        int n;
        Segment_tree(long[] arr){
            n = arr.length;
            seg_arr = new long[4*n];
            bulid_seg(arr,0,n-1,0);
        }
        public  long bulid_seg(long[] arr, int si,int ei,int idx){ //O(n)
            if(si==ei){
                return seg_arr[idx] = arr[si];
            }
            int mid = (si+ei)/2;
            long left  = bulid_seg(arr, si, mid,2*idx+1);
            long right = bulid_seg(arr, mid+1,ei,2*idx+2);
            return seg_arr[idx] = Math.max(left, right);
        }
    }
    public static void main(String[] args) {
        long arr[] = {6,8,-1,2,17,1,3,2,4};
        Segment_tree sg1 = new Segment_tree(arr);  //O(n) this will construct the tree
        for(int i=0;i<sg1.seg_arr.length;i++) System.out.print(sg1.seg_arr[i]+" ");
        System.out.println();
        System.out.println(sg1.rangesum(2, 5));
        sg1.update(4,2);
        for(int i=0;i<sg1.seg_arr.length;i++) System.out.print(sg1.seg_arr[i]+" ");
        System.out.println();
        System.out.println(sg1.rangesum(2, 5));
    }    
}
