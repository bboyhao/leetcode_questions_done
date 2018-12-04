class Solution {
    public int removeElement(int[] nums, int val) {
    	if(nums.length == 0) return 0;
    	int result = 0;
    	int length = nums.length;
    	for(int i=0; i<length; i++){
    		if(nums[i]==val)continue;
    		nums[result++] = nums[i]; 
    	}
    	return result;
    }
}