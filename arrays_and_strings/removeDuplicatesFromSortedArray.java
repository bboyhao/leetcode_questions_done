class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums.length==0) return 0;
        int result = 0;
        int length = nums.length;
        for(int i=0;i<length;i+=1){
            if(i!=0 && nums[i] == nums[i-1]) continue;
            nums[result++]=nums[i];
         }
        return result;
    }
}
