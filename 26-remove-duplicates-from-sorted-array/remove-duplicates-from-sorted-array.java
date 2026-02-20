class Solution {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        int low = 0;
        int result = 1;
        int high = 1;
        while(high < n){
            if(nums[high] == nums[high-1]){
                high++;
                continue;
            }
            nums[low+1] = nums[high];
            low++;
            result++;
            high++;
        }
        return result;
    }
}