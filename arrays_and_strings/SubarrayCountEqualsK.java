import java.util.*;

public class SubarrayCountEqualsK{
    //Time: O(n) Space: O(n)
    public int subarraySum(int[] nums, int k) {
        int count = 0;
        for(int i = 0; i<nums.length; i++){
            int sum = nums[i];
            if(sum == k) count++;
            for(int j = i+1; j<nums.length; j++){
                sum += nums[j];
                if(sum == k) count++;
            }
        }
        return count;
    }

    public int subarraySum2(int[] nums, int k){
        int count = 0;
        int sum = 0;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        map.put(0,1);
        for(int num : nums){
            sum += num;
            if(map.containsKey(sum - k)){
                count += map.get(sum - k);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }
}
