class Solution {
    public int firstUniqChar(String s) {
        int freq[] = new int[26]; // 'a' - 'z'
        Queue<Integer>q = new LinkedList<>();
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            freq[ch-'a']++;
            q.add(i);

            while(!q.isEmpty() && freq[s.charAt(q.peek())-'a']>1){
                q.poll();
            }
        }
        return q.isEmpty() ? -1 : q.peek();
    }
}