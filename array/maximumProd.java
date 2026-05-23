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


public int maximumProduct(int[] nums) {
    int n = nums.length;
    Arrays.sort(nums);
    int prod1 = nums[n-1]*nums[n-2]*nums[n-3];
    int prod2 = nums[0]*nums[1]*nums[n-1];

    int maxProd = Math.max(prod1, prod2);
    return maxProd;
}


public void main(String[] arges){
    int[] nums = {1,2,3};
    int res = maximumProd(nums);
    System.out.println(res);
}