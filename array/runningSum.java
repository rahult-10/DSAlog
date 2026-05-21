public int[] runningSum(int[] nums){
    int n = nums.length;
    for(int i = 1; i < n; i++){
        nums[i] = nums[i]+nums[i-1];
    }
    return nums;
}

public void main(String[] args) {
    int[] nums= {1,2,3,4};
    int[] sum = runningSum(nums);
    System.out.println(Arrays.toString(sum));
}