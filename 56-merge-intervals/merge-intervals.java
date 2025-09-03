class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> Integer.compare(a[0],b[0]));
        List<int[]> merged = new ArrayList<>();
        merged.add(intervals[0]);
        for(int i = 1; i < intervals.length; i++){
            int[] current = intervals[i];
            int[] lastMerged = merged.get(merged.size()-1);

           if (current[0] <= lastMerged[1]) {
                // Overlapping: merge by extending end time
                lastMerged[1] = Math.max(lastMerged[1], current[1]);
            } else {
                // No overlap: add current interval as new
                merged.add(current);
            }
        }
        
        // Step 5: Convert List back to array
        return merged.toArray(new int[merged.size()][]);
    }
    
}