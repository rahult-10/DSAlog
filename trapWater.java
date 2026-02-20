
class trapWater {
    public static int trappedWater(int height[]){
        
        //Left 
        int leftMax[] = new int[height.length];
        leftMax[0] = height[0];
        for(int i = 1; i< height.length;i++){
            leftMax[i] = Math.max(height[i], leftMax[i-1]);
        }

        //Right
        int rightMax[] = new int[height.length];
        rightMax[height.length-1] = height[height.length-1];
        for(int i = height.length - 2; i>=0; i--){
            rightMax[i] = Math.max(height[i], rightMax[i+1]); //since we started from end (reverse)
        }

        int trappedWater = 0;
        //Loop
        for(int i = 0; i<height.length ; i++){
            // calculate water level
            int waterlevel = Math.min(leftMax[i], rightMax[i]);

            //trapped water
            trappedWater += waterlevel - height[i];
        }

        return trappedWater;
        
    }

    public static void main(String[] args) {
        // int height[] = {4,2,0,6,3,2,5};
        int height[] = {1,8,6,2,5,4,8,3,7};
         // Record start time
        long startTime = System.currentTimeMillis();

        int tp = trappedWater(height);

        // Record end time
        long endTime = System.currentTimeMillis();

        // Calculate elapsed time
        long duration = endTime - startTime;

        System.out.println("Total trapped water is: " + tp);
        // System.out.println("Execution time: " + duration + " nanoseconds");
        System.out.println("Execution time: " + duration + " milliseconds");

    }
}