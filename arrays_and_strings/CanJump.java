public class CanJump{
    int[] can;
    public boolean canJump(int[] nums){
        can = new int[nums.length];
        can[can.length-1] = 1;
        return canJumpToPlace(nums, 0);
    }

    public boolean canJumpToPlace(int[] nums, int cur){
        for(int i = nums.length-2;i>=0;i-=1){
            for(int j = 1; j<=nums[i];j+=1){
                if(can[i+j] == 1){
                    can[i] = 1;
                    break;
                }
            }
        }
        return can[0] == 1;
    }

    public boolean canJump2(int[] nums) {
        int lastPos = nums.length - 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (i + nums[i] >= lastPos) {
                lastPos = i;
            }
        }
        return lastPos == 0;
    }
}
