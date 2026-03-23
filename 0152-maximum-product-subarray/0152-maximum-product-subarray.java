class Solution {
    public int maxProduct(int[] nums) {
        int maxProduct = nums[0];
        int minProduct = nums[0];
        int result = nums[0];
        for(int i = 1; i < nums.length; i++){
            int current = nums[i];
            if(current < 0){
                int temp = maxProduct;
                maxProduct = minProduct;
                minProduct = temp;
            }

            maxProduct = Math.max(maxProduct * current, current);
            minProduct = Math.min(minProduct * current, current);

            result = Math.max(maxProduct, result);
        }
        return result;
    }
}