import java.util.*;

class MergeIntervals {
    public int[][] merge(int[][] intervals) {
        if (intervals==null || intervals.length == 1) return intervals;
        sort(intervals);
        int cur = 1;
        int last = 0;
        while(cur < intervals.length) {
            if(overlap(intervals[last], intervals[cur])) {
                int[] merged = mergeInterval(intervals[last], intervals[cur]);
                intervals[last] = merged;
            } else{
                intervals[++last] = intervals[cur];
            }
            cur++;
        }
        return Arrays.copyOf(intervals, last+1);
    }

    private static boolean overlap(int[] a, int[] b){
        if (Math.max(a[0], b[0])<=Math.min(a[1], b[1])) return true;
        return false;
    }

    private int[] mergeInterval(int[] a, int[] b) {
        return new int[]{Math.min(a[0],b[0]), Math.max(a[1], b[1])};
    }

    private void sort(int[][] intervals) {
        if(intervals == null || intervals.length <=1) return;
        int size = intervals.length;
        quicksort(intervals, 0, size-1);
    }

    private void quicksort(int[][] intervals, int left, int right){
        if (left >= right) return;
        int pivot = partition(intervals, left, right);
        quicksort(intervals, left, pivot-1);
        quicksort(intervals, pivot+1, right);
    }

    private int partition(int[][] intervals, int left, int right) {
        int lastsmall = left;
        for(int i = left+1;i<=right;i++) {
            if(intervals[i][0]<intervals[left][0]) {
                swap(intervals, i, ++lastsmall);
            }
        }
        swap(intervals, left, lastsmall);
        return lastsmall;
    }

    private void swap(int[][] intervals, int i, int j) {
        int[] tmp = intervals[i];
        intervals[i] = intervals[j];
        intervals[j] = tmp;
    }
}
