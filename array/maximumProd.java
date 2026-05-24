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

public int maxProduct(int[] nums) {
    int max1 = Integer.MIN_VALUE;
    int max2 = Integer.MIN_VALUE;
    int max3 = Integer.MIN_VALUE;

    int min1 = Integer.MAX_VALUE;
    int min2 = Integer.MAX_VALUE;

    for (int num : nums) {

        // Update maximum
        if (num > max1) {
            max3 = max2;
            max2 = max1;
            max1 = num;
        } else if (num > max2) {
            max3 = max2;
            max2 = num;
        } else if (num > max3) {
            max3 = num;
        }

        // Update minimum
        if (num < min1) {
            min2 = min1;
            min1 = num;
        } else if (num < min2) {
            min2 = num;
        }
    }

    return Math.max(max1 * max2 * max3, min1 * min2 * max1);
}

public void main(String[] arges){
    int[] nums = {1,2,3};
    int res = maximumProd(nums);
    System.out.println(res);
}