public class SearchForRange{
    public int[] searchRange(int[] nums, int target){
        if(nums == null || nums.length == 0){
            return new int[]{-1,-1};
        }
        int mid = binarySearch(nums, 0, nums.length-1, target);
        if(mid == -1){
            return new int[]{-1,-1};
        }
        int left = binarySearchLeft(nums, 0, mid-1, target);
        int right = binarySearchRight(nums, mid+1, nums.length-1, target);
        left = (left==-1)?mid:left;
        right = (right==-1)?mid:right;
        return new int[]{left, right};
    }

    private int binarySearch(int[] nums, int l, int r, int target){
        while(l<r){
            int mid = l+(r-l)/2;
            if(nums[mid] == target){
                return mid;
            }else if(nums[mid] < target){
                l = mid+1;
            }else{
                r = mid-1;
            }
        }
        return -1;
    }

    private int binarySearchRight(int[] nums, int l, int r, int target){
        int right = -1;
        while(l<r){
            int mid = l+(r-l)/2;
            if(nums[mid] == target){
                right = mid;
                l = mid + 1;
            }else if(nums[mid] < target){
                l = mid+1;
            }else{
                r = mid-1;
            }
        }
        return right;
    }

    private int binarySearchLeft(int[] nums, int l, int r, int target){
        int left = -1;
        while(l<r){
            int mid = l+(r-l)/2;
            if(nums[mid] == target){
                left = mid;
                r = mid - 1;
            }else if(nums[mid] < target){
                l = mid+1;
            }else{
                r = mid-1;
            }
        }
        return left;
    }
}
