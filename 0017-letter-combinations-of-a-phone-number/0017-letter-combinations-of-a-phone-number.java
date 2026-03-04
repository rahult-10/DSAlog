class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        
        if (digits == null || digits.length() == 0)
            return result;
        
        String[] phone = {
            "", "", "abc", "def", "ghi",
            "jkl", "mno", "pqrs", "tuv", "wxyz"
        };
        
        revert(digits, 0, new StringBuilder(), phone, result);
        return result;
    }
    
    private void revert(String digits, int index,
                           StringBuilder current,
                           String[] phone,
                           List<String> result) {
        
        if (index == digits.length()) {
            result.add(current.toString());
            return;
        }
        String letters = phone[digits.charAt(index) - '0'];
        for (char letter : letters.toCharArray()) {
            current.append(letter);
            revert(digits, index + 1, current, phone, result);
            current.deleteCharAt(current.length() - 1);
        }
    }
}