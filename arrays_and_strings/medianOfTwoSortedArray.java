class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int total = nums1.length + nums2.length;
        if(total%2==1){
            return findKNumber(nums1, 0, nums2, 0, total/2+1);
        }
        else{
            return (findKNumber(nums1, 0, nums2, 0, total/2) + findKNumber(nums1, 0, nums2, 0, total/2+1))/2;
        }
    }
    
    public double findKNumber(int[] a, int m, int[] b, int n, int k){
        int half = k/2;
        int otherHalf = k-half;
        if(m>=a.length) return b[m-a.length+n+k-1];
        if(n>=b.length) return a[n-b.length+m+k-1];
        if(k==1) return Math.min(a[m],b[n]);
        int first = (m+half-1>=a.length) ? (Integer.MAX_VALUE) : (a[m+half-1]);
        int second = n+otherHalf-1>=b.length? Integer.MAX_VALUE: b[n+otherHalf-1];
        if(first<second)
            return findKNumber(a, m+half, b, n, otherHalf);
        else if(first == second){
            return first;
        }
        else
            return findKNumber(a, m, b, n+otherHalf, half);
    }
}
