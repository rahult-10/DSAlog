public int[] concatArray(int[] nums) {
    int [] arr = new int [2*nums.length];
    for(int i = 0; i < nums.length; i++){
        arr[i] = nums[i];
        arr[i+nums.length] = nums[i];
    }
    return arr;
}

public int[] getConcatenation(int[] nums) {
    int n = nums.length;
    int [] arr = new int[2*n];
    System.arraycopy(nums,0,arr,0,n);
    System.arraycopy(nums,0,arr,n,n);
    return arr;
}

public int[] concatenation(int[] nums) {
    int [] arr = new int [2*nums.length];
    for(int i = 0; i < nums.length; i++){
        arr[i] = nums[i];
        arr[(arr.length-1)-i] = nums[(nums.length-1)-i];
    }
    return arr;
}

public void main(String[] args){
    int[] nums = {1,2,1};
    int[] concat = concatArray(nums);
    System.out.println(Arrays.toString(concat));
}