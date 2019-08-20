import java.util.*;

public class FindDuplicateNumber{
    //sort the array and then find the duplicate
    public int findDuplicate1(int[] nums) {
        Arrays.sort(nums);
        int result = 0;
        for(int i = 0; i<nums.length-1;i++){
            if(nums[i] == nums[i+1]){
                result = nums[i];
                break;
            }
        }
        return result;
    }

    //use set to store the number
    public int findDuplicate2(int[] nums){
        Set<Integer> s = new HashSet<>();
        int result = 0;
        for(int num : nums){
            if(s.contains(num)){
                result = num;
                break;
            }
            s.add(num);
        }
        return result;
    }

    //Floyd's Tortoise and Hare (Cycle Detection) 
    public int findDuplicate3(int[] nums){
        // Find the intersection point of the two runners.
        int tortoise = nums[0];
        int hare = nums[0];
        do {
            tortoise = nums[tortoise];
            hare = nums[nums[hare]];
        } while (tortoise != hare);

        // Find the "entrance" to the cycle.
        int ptr1 = nums[0];
        int ptr2 = tortoise;
        while (ptr1 != ptr2) {
            ptr1 = nums[ptr1];
            ptr2 = nums[ptr2];
        }

        return ptr1;
    }
}
