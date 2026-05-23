public int maximumProd(int[] nums) {
    int n = nums.length;
    int maxProd = Integer.MIN_VALUE;
    for(int i = 0; i < n; i++){
        for(int j = i+1; j < n; j++){
            for(int k = j+1; k < n; k++){
                int prod = nums[i]*nums[j]*nums[k];
                maxProd = Math.max(maxProd, prod);
            }
        }
    }
    return maxProd;
}

public void main(String[] arges){
    int[] nums = {1,2,3};
    int res = maximumProd(nums);
    System.out.println(res);
}