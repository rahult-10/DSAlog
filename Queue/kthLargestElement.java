
public int kthLargestElement(int[] nums, int k) {
    Arrays.sort(nums);
    return nums[nums.length - k];
}

public int findKthLargest(int[] nums, int k) {
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    for(int num : nums){

        if(minHeap.size() < k){
            minHeap.add(num);
        }
        else {
            if(num > minHeap.peek()){
                minHeap.poll();
                minHeap.add(num);
            }
        }
    }
    return minHeap.peek();
}

public void main(String[] args) {
    int[] nums = {3,2,1,5,6,4};
    int k = 2;
    int res = kthLargestElement(nums, k);
    System.out.println(res);
}
