class Solution {
    public int[] getConcatenation(int[] nums) {
        int [] arr = new int [2*nums.length];
        for(int i = 0; i < nums.length; i++){
            arr[i] = nums[i];
            arr[i+nums.length] = nums[i];
            //arr[(nums.length-1)-i] = nums[(nums.length-1)-i]
        }
        return arr;
    }
}