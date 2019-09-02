import java.util.*;

public class QueueReconstructionByHeight{
    public int[][] reconstructQueue(int[][] people) {
        int len = people.length;
        int[][] rst = new int[len][2];
        if( len == 0 )return rst;
        PriorityQueue<int[]> heap = new PriorityQueue<>( len, new Comparator<int[]>(){
            public int compare( int[] a, int[] b ){
                if( a[0] == b[0] ){
                    return a[1] - b[1];
                }else{
                    return b[0] - a[0];
                }
            }
        });

        for( int[] person : people ){
            heap.offer( person );
        }
        // int idx = 0;
        List<int[]> list = new ArrayList<>();
        while( !heap.isEmpty() ){
            int[] tmp = heap.poll();
            list.add( tmp[1], new int[] { tmp[0], tmp[1] } );
        }
        for( int i = 0; i < len; i++ ){
            rst[i] = list.get(i);
        }
        return rst;
    }
}
