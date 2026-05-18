
public int kthLargestElement(int[] nums, int k) {
    Arrays.sort(nums);
    return nums[nums.length - k];
}

public void main(String[] args) {
    int[] nums = {3,2,1,5,6,4};
    int k = 2;
    int res = kthLargestElement(nums, k);
    System.out.println(res);
}
