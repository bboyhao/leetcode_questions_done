import java.util.*;

public class TopKFrequent{
    //use heap
    //Time: O(nlog(k)) Space: O(n)
    public List<Integer> topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int num : nums){
            map.put(num, map.getOrDefault(num, 0)+1);
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>((n1, n2) -> map.get(n1) - map.get(n2));
        for(int key : map.keySet()){
            pq.add(key);
            if(pq.size()>k) {
                pq.poll();
            }
        }
        LinkedList<Integer> result = new LinkedList<>();
        while(!pq.isEmpty()){
            result.add(pq.poll());
        }
        return result;
    }

    //use bucketSort
    //Time: O(n) Space: O(n)
    public List<Integer> topKFrequent2(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int num : nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        List<Integer>[] buckets = new List[nums.length+1];
        for(Integer key : map.keySet()){
            int freq = map.get(key);
            if(buckets[freq]==null){
                buckets[freq] = new ArrayList<>();
            }
            buckets[freq].add(key);
        }
        List<Integer> result = new ArrayList<>();
        for(int i= buckets.length-1;i>=0;i--){
            if(buckets[i]==null) continue;
            else{
                List<Integer> keyList =buckets[i];
                for(int j=0;j<keyList.size()&&result.size()<k;j++){
                    result.add(keyList.get(j));
                }
                if(result.size()==k) break;
            }
        }
        return result;
    }
}
