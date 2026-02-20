class Solution {
    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        List<Integer> neg = new ArrayList<>();
        List<Integer> pos = new ArrayList<>();

        for(int num : nums){
            if(num > 0){
                pos.add(num);
            } else {
                neg.add(num);
            }
        }

        if(neg.size() == 0){
            for(int i = 0; i < pos.size(); i++)
                pos.set(i, pos.get(i)*pos.get(i));
            return pos.stream().mapToInt(Integer::intValue).toArray();
        }

        if(pos.size() == 0){
            for(int i = 0; i < neg.size(); i++)
                neg.set(i, neg.get(i)*neg.get(i));
            Collections.reverse(neg);
            return neg.stream().mapToInt(Integer::intValue).toArray();
        }

        int i=0, j=0, idx=0;
        int n1 = neg.size();
        int n2 = pos.size();
        int [] result = new int[n1+n2];

        for( i = 0; i < n1; i++){
            neg.set(i, neg.get(i)*neg.get(i));
        }
        Collections.reverse(neg);

        for( i = 0; i < n2; i++)
            pos.set(i, pos.get(i)*pos.get(i));

        //Merging 2 sorted array
        i=0; 
        j=0;
        while(i < n1 && j < n2){
            if(neg.get(i) <= pos.get(j)){
                result[idx++] = neg.get(i++);
            } 
            else{
                result[idx++] = pos.get(j++);
            }
        }
        while(i<n1){
            result[idx++] = neg.get(i++);
        }
        while(j<n2){
            result[idx++] = pos.get(j++);
        }

        return result;

    }
}