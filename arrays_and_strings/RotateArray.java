public class RotateArray{
    //solution 1: create a temporary array
    //Time: O(n) Space: O(n)
    public void rotate1(int[] nums, int k) {
        int[] result = new int[nums.length];
        for(int i = 0; i<nums.length;i++){
            result[(i+k)%nums.length] = nums[i];
        }
        for(int i = 0; i<nums.length;i++){
            nums[i] = result[i];
        }
    }

    //solution 2: cyclic array
    //Time: O(n) Space: O(1)
    public void rotate2(int[] nums, int k) {
        int count = 0;
        int len = nums.length;
        for(int start = 0; count < nums.length; start += 1){
            int pre = nums[start];
            int cur = start;
            do{
                cur = (cur+k)%len;
                int tmp = nums[cur];
                nums[cur] = pre;
                pre = tmp;
                count++;
            }while(cur != start);
        }
    }

    //solution 3: reverse the array
    //Time: O(n) Space: O(1)
    public void rotate3(int[] nums, int k) {
        k %= nums.length;
        reverse(nums, 0, nums.length-1);
        reverse(nums, 0, k-1);
        reverse(nums, k, nums.length-1);
    }

    public void reverse(int[] nums, int start, int end){
        while(end>start){
            int tmp = nums[start];
            nums[start] = nums[end];
            nums[end] = tmp;
            end--;
            start++;
        }
    }
}
