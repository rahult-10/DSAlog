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

public void main(String[] args){
    int[] nums = {2,2,3,4};
    int res = triangleNumber(nums);
    System.out.println(res);
}