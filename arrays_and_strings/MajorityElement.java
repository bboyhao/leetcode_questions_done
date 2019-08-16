import java.util.HashMap;

public class MajorityElement{
    //Time Complexity: O(n) Space Complexity: O(n)
    public int majorityElement1(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int result = 0;
        for(int num : nums){
            int count = map.getOrDefault(num, 0);
            if(count + 1 > nums.length/2){
                result = num;
                break;
            }
            map.put(num, count+1);
        }
        return result;
    }

    //Time Complexity: O(nlg(n)) Space Complexity: O(1)
    public int majorityElement2(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length/2];
    }
}
