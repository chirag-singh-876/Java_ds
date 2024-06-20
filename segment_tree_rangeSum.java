public class segment_tree_rangeSum {
    static class Segment_tree{
        public  long bulid_seg(long[] seg_arr, long[] arr, int si,int ei,int idx){ //O(n)
            if(si==ei){
                return seg_arr[idx] = arr[si];
            }
            int mid = (si+ei)/2;
            long left  = bulid_seg(seg_arr, arr, si, mid,2*idx+1);
            long right = bulid_seg(seg_arr, arr, mid+1,ei,2*idx+2);
            return seg_arr[idx] = left+right;
        }

        // responding query
        public  long rangesum(int qs,int qe){
            return rangesumutil(0, n-1, qs, qe,0);
        }
        private long rangesumutil(int si,int ei,int qs,int qe,int idx){
            if(qe<si || qs>ei) return 0;                    // no overlap
            else if(si>=qs && ei<=qe) return seg_arr[idx];  // complete overlap
            int mid = (si+ei)/2;                            // partial overlap
            long left =  rangesumutil(si, mid, qs, qe, 2*idx+1);
            long right = rangesumutil(mid+1, ei, qs, qe, 2*idx+2);
            return left + right;
        }

        // updating the query
        public void update(int idx,long val){
            long diff = val-rangesum(idx,idx);
            updateutil(0,n-1,0,idx,diff);
        }
        private void updateutil(int si,int ei,int idx,int ith,long diff){
            if(ith<si || ith>ei) return;
            seg_arr[idx] += diff;
            if(si == ei) return;
            int mid = (si+ei)/2;
            updateutil(si, mid, 2*idx+1, ith, diff);
            updateutil(mid+1, ei, 2*idx+2, ith, diff);
        }
        long seg_arr[];
        int n;
        Segment_tree(long[] arr){
            n = arr.length;
            seg_arr = new long[4*n];
            bulid_seg(seg_arr,arr,0,n-1,0);
        }
    }
    public static void main(String[] args) {
        long arr[] = new long[8];
        for(int i=0;i<arr.length;i++) arr[i] = i+1;
        Segment_tree sg1 = new Segment_tree(arr);  //O(n) this will construct the tree
        for(int i=0;i<sg1.seg_arr.length;i++) System.out.print(sg1.seg_arr[i]+" ");
        System.out.println();
        System.out.println(sg1.rangesum(1, 3));
        sg1.update(2,2);
        for(int i=0;i<sg1.seg_arr.length;i++) System.out.print(sg1.seg_arr[i]+" ");
        System.out.println();
        System.out.println(sg1.rangesum(1, 3));
    }    
}
