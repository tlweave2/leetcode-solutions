class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
      Map<String , List<String>> map = new HashMap<>();
      for(String s : strs){
        
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        String key = new String(chars);
        if(!map.containsKey(key)){
            map.put(key , new ArrayList<String>());
        }
        map.get(key).add(s);


      }
        List<List<String>> result = new ArrayList<>();
        for(List<String> res: map.values()){
            result.add(res);
        }
        return result;
}
}