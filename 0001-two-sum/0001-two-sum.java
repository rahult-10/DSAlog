class Solution {
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        int [][] arr = new int[n][2];

        // Value & Original Index
        for(int i=0; i<n; i++){
            arr[i][0] = nums[i];
            arr[i][1] = i;
        }

        //Sorting
        for(int i = 0; i < n-1; i++){
            int min = i;
            for(int j = i+1; j < n; j++){
                if(arr[j][0] < arr[min][0]){
                    min = j;
                }
            }

            //Swapping
            int[] temp = arr[i];
            arr[i] = arr[min];
            arr[min] = temp;
        }

        //2-Pointer
        int i = 0;
        int j = nums.length-1;
        while(i < j){
            int sum = arr[i][0] + arr[j][0];
            if(sum == target){
                return new int[]{arr[i][1], arr[j][1]};
            }
            else if (sum < target) {
                i++;
            } else {
                j--;
            }
            
        }
        return null;
        
    }
}