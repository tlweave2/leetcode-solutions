class Solution {
    public List<String> restoreIpAddresses(String s) {
            List<String> result = new ArrayList<>();
        backtrack(s, 0, 0, new StringBuilder(), result);
        return result;
    }

    private void backtrack(String s, int index, int partCount, StringBuilder current, List<String> result) {
        // If we've placed 4 parts and used all characters, it's a valid IP
        if (partCount == 4 && index == s.length()) {
            result.add(current.toString());
            return;
        }

        // If we've placed 4 parts but still have characters left, or not enough chars to fill remaining parts
        if (partCount == 4 || index == s.length()) {
            return;
        }

        // Try segments of length 1 to 3
        for (int len = 1; len <= 3; len++) {
            // If we don't have enough characters left for this segment, break
            if (index + len > s.length()) break;

            String segment = s.substring(index, index + len);

            // Leading zero check: if length > 1 and starts with '0', invalid
            if (segment.length() > 1 && segment.charAt(0) == '0') break;

            int value = Integer.parseInt(segment);
            if (value > 255) break; // since longer segments will only be larger

            int beforeAppendLength = current.length();

            // Append segment (and dot if it's not the first segment)
            if (partCount > 0) {
                current.append('.');
            }
            current.append(segment);

            backtrack(s, index + len, partCount + 1, current, result);

            // Backtrack (remove the added segment and optional dot)
            current.setLength(beforeAppendLength);
        }
    }
}