class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // Map to store sorted string -> list of anagrams
        Map<String, List<String>> map = new HashMap<>();
        
        for (String str : strs) {
            // Sort the string to use as key
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String sorted = new String(chars);
            
            // Add to the appropriate group
            if (!map.containsKey(sorted)) {
                map.put(sorted, new ArrayList<>());
            }
            map.get(sorted).add(str);
        }
        
        // Return all groups
        return new ArrayList<>(map.values());
    }
}