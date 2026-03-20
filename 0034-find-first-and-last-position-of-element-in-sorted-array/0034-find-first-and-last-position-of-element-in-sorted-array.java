class Solution {
    public int[] searchRange(int[] nums, int target) {
        int first = firstIndex(nums, target);
        int last = lastIndex(nums, target);
        return new int[]{first, last};
    }

    private int firstIndex(int[] nums, int target){
        int left = 0;
        int right = nums.length-1;
        int index = -1;
        while(left <= right){
            int mid = left + (right-left) / 2;
            if(nums[mid] >= target){
                right = mid-1;
            } else {
                left = mid + 1;
            }

            if(nums[mid] == target){
                index = mid;
            }
        }
        return index;
    }

    private int lastIndex(int[] nums, int target){
        int left = 0;
        int right = nums.length-1;
        int index = -1;
        while(left <= right){
            int mid = left + (right-left) / 2;
            if(nums[mid] <= target){
                left = mid+1;
            } else {
                right = mid-1;
            }

            if(nums[mid] == target){
                index = mid;
            }
        }
        return index;
    }
}