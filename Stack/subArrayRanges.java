public long subArrayRanges(int[] nums) {
    int n = nums.length;
    long sum = 0;
    for(int i = 0; i < n; i++){
            int largest = nums[i] , smallest = nums[i];
        for(int j = i+1; j < n; j++){
            largest = Math.max(largest, nums[j]);
            smallest = Math.min(smallest, nums[j]);
            sum += (largest - smallest);
        }
    }
    return sum;
}

public long sumSubArrayRanges(int[] nums) {
    int n = nums.length;

    long sumofMin = 0;
    long sumofMax = 0;

    // Sum Of Min
    for (int i = 0; i < n; i++) {
        int countLeft = 1;
        for (int j = i - 1; j >= 0; j--) {
            if (nums[j] > nums[i]) countLeft++;
            else break;
        }

        int countRight = 1;
        for (int j = i + 1; j < n; j++) {
            if (nums[j] >= nums[i]) countRight++;
            else break;
        }

        sumofMin += (long) countLeft * countRight * nums[i];
    }

    // Sum of Max
    for (int i = 0; i < n; i++) {
        int countLeft = 1;
        for (int j = i - 1; j >= 0; j--) {
            if (nums[j] < nums[i]) countLeft++;
            else break;
        }

        int countRight = 1;
        for (int j = i + 1; j < n; j++) {
            if (nums[j] <= nums[i]) countRight++;
            else break;
        }

        sumofMax += (long) countLeft * countRight * nums[i];
    }

    return sumofMax - sumofMin;
}



public void main(String[] args) {
    int nums[] = {1,2,3};
    long res = subArrayRanges(nums);
    System.out.println(res);
}