public class MoveZeroes{
    public void moveZeroes(int[] nums) {
        int right = nums.length-1;
        for(int i = nums.length-2;i>=0;i--){
            if(nums[i] == 0){
                for(int j = i; j<right;j++){
                    swap(nums, j+1, j);
                }
                right--;
            }
        }
    }

    public void moveZeroes2(int[] nums) {
        int index = 0;

        for(int i = 0; i < nums.length; i++){
            if(nums[i] != 0){
                swap(nums, i, index);
                index++;
            }
        }
    }

    private void swap(int[] nums, int a, int b){
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }
}
