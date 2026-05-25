public boolean validAnagram(String s, String t) {
    if(s.length() != t.length()){
        return false;
    }

    Map<Character, Integer> map = new HashMap<>();

    for(int i = 0; i < s.length(); i++){
        char ch = s.charAt(i);

        map.put(ch, map.getOrDefault(ch, 0)+1);
    }

    for(int i = 0; i < t.length(); i++){
        char ch = t.charAt(i);

        if(!map.containsKey(ch)){
            return false;
        }

        map.put(ch, map.get(ch)-1);

        if(map.get(ch) == 0){
            map.remove(ch);
        }
    }

    return map.isEmpty();
}

public boolean isAnagram(String s, String t){
    if(s.length() != t.length()){
        return false;
    }

    char[] a = s.toCharArray();
    char[] b = t.toCharArray();

    Arrays.sort(a);
    Arrays.sort(b);

    for(int i = 0; i < a.length; i++){
        if(a[i] != b[i]){
            return false;
        }
    }
    return true;
}
public void main(String[] args){
    String s  = "anagram";
    String t = "nagrama";

    boolean res = validAnagram(s, t);

    System.out.println(res);
}