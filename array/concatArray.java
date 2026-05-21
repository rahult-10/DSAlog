public int[] concatArray(int[] nums) {
    int [] arr = new int [2*nums.length];
    for(int i = 0; i < nums.length; i++){
        arr[i] = nums[i];
        arr[i+nums.length] = nums[i];
    }
    return arr;
}

public void main(String[] args){
    int[] nums = {1,2,1};
    int[] concat = concatArray(nums);
    System.out.println(Arrays.toString(concat));
}