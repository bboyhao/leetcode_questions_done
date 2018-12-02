class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if(nums == null || nums.length<4) return result;
        int length = nums.length;
        Arrays.sort(nums);
        for(int i = 0; i<length-3; i+=1){
            if(i>0 && nums[i]==nums[i-1]) continue;
            for(int j = i+1; j<length-2; j+=1){
                if(nums[i]+nums[j]+nums[j+1]+nums[j+2]>target) break;
                if(nums[i]+nums[j]+nums[length-2]+nums[length-1]<target) continue;
                if(j-i>1 && nums[j]==nums[j-1]) continue;
                int low = j+1;
                int high = length-1;
                while(low<high){
                    int sum=nums[i] + nums[j] + nums[low] + nums[high];
                    if(sum==target){
                        result.add(Arrays.asList(nums[i], nums[j], nums[low], nums[high]));
                        while(low<high && nums[low] == nums[low+1])++low;
                        while(low<high && nums[high] == nums[high-1])--high;
                        ++low;
                        --high;
                    }
                    else if(sum<target) ++low;
                    else --high;
                }
            }
        }
        return result;
    }
}
