class Solution {
    public boolean isAnagram(String s, String t) {
        HashMap<Character , Integer> map = new HashMap<>();
        for(char i : s.toCharArray()){
        map.put(i, map.getOrDefault(i, 0) + 1);
        }
        for(char f : t.toCharArray()){
       if(!map.containsKey(f) || map.get(f) <= 0) {
    return false;
} else {
             map.put(f, map.getOrDefault(f, 0) - 1);

        }
        
        }
        
       for(int count : map.values()) {
    if(count != 0) {
        return false;
    }
}
return true;
    }
}