class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length;

        int closestSum = nums[0] + nums[1] + nums[2];
        int minDiff = closestSum - target;

        for (int i = 0; i < n - 2; i++) {
            int x = nums[i];
            int minSum = x + nums[i + 1] + nums[i + 2];

            if (minSum - target > Math.abs(minDiff)){
                break;
            }


            int maxSum = x + nums[n - 1] + nums[n - 2];
            if (target - maxSum > Math.abs(minDiff)){
                continue;
            } 
                

            int left = i + 1, right = n - 1;
            while (left < right) {
                int sum = x + nums[left] + nums[right];
                int diff = sum - target;

                if (diff == 0) return target;

                if (Math.abs(diff) < Math.abs(minDiff)) {
                    minDiff = diff;
                    closestSum = sum;
                }

                if (diff < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        return closestSum;
    }
}