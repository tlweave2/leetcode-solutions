class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if(strs.length == 0) return new ArrayList<>();
if(strs.length == 1) return Arrays.asList(Arrays.asList(strs[0]));
      HashMap<String, List<String>> map = new HashMap<>();
for(String str : strs) {
    char[] chars = str.toCharArray();
    Arrays.sort(chars);
    String sortedKey = new String(chars);
    
  if(!map.containsKey(sortedKey)) {
    map.put(sortedKey, new ArrayList<>());
}
map.get(sortedKey).add(str);
}
return new ArrayList<>(map.values());
    }
}