class Solution {
    public int[] fairCandySwap(int[] aliceSizes, int[] bobSizes) {
        int n = aliceSizes.length;
        int m = bobSizes.length;
        int sumA = 0;
        int sumB = 0;
        for(int a : aliceSizes)
            sumA += a;
        for(int b : bobSizes)
            sumB += b;
        int diff = (sumA - sumB) / 2;
        HashSet<Integer> setA = new HashSet<>();
        for(int a : aliceSizes)
            setA.add(a);
        for(int b : bobSizes){
            int a = b + diff;
            if(setA.contains(a)){
                return new int[]{a,b};
            }
        }
        return new int[]{-1,-1};

    }
}