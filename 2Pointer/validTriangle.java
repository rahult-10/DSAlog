public int triangleNumber(int[] nums) {
    Arrays.sort(nums);
    int n = nums.length;
    int count = 0;
    for(int i = 0; i < n; i++){
        for(int j = i+1; j < n; j++){
            for(int k = j+1; k < n; k++){
                int sum = nums[i] + nums[j];
                if(sum > nums[k]){
                    count++;
                }
            }
        }
    }
    return count;
}

public int validTriangle(int[] nums) {
    Arrays.sort(nums);
    int n = nums.length;
    int count = 0;

    for(int i = 0; i < n-2; i++){
        for(int j = i+1; j < n-1; j++){
            int left = j+1;
            int right = n-1;
            int idx = j;

            while(left <= right){
                int mid = left + (right-left)/2;
                if(nums[i] + nums[j] > nums[mid]){
                    idx = mid;
                    left = mid+1;
                }
                else {
                    right = mid-1;
                }
            }
            count += (idx -j);
        }
    }
    return count;
}

public void main(String[] args){
    int[] nums = {2,2,3,4};
    int res = triangleNumber(nums);
    int result = validTriangle(nums);
    System.out.println(res + "," + result);
}