class Solution {
    public int minimumCost(int[] nums) {
        int n = nums.length;
        int minCost = Integer.MAX_VALUE;
        for (int i = 0; i < n - 2; i++) {          // end of first subarray
            for (int j = i + 1; j < n - 1; j++) {  // end of second subarray

                int cost = nums[0] + nums[i+1] + nums[j+1];
                if(cost < minCost){
                    minCost = cost;
                }
            }
        }
        return minCost;
    }
}