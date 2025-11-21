class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        int n = s.length();

        // Length must be between 4 and 12 for any valid IP
        if (n < 4 || n > 12) {
            return result;
        }

        // i, j, k are the end indices (exclusive) of the first 3 segments
        for (int i = 1; i <= 3 && i < n - 2; i++) {
            String p1 = s.substring(0, i);
            if (!isValidPart(p1)) continue;

            for (int j = i + 1; j <= i + 3 && j < n - 1; j++) {
                String p2 = s.substring(i, j);
                if (!isValidPart(p2)) continue;

                for (int k = j + 1; k <= j + 3 && k < n; k++) {
                    String p3 = s.substring(j, k);
                    String p4 = s.substring(k);

                    if (!isValidPart(p3) || !isValidPart(p4)) continue;

                    result.add(p1 + "." + p2 + "." + p3 + "." + p4);
                }
            }
        }

        return result;
    }

    // Check if a segment is a valid IP part
    private boolean isValidPart(String part) {
        // Empty or too long
        if (part.length() == 0 || part.length() > 3) return false;

        // Leading zero is only allowed for "0"
        if (part.length() > 1 && part.charAt(0) == '0') return false;

        int value = Integer.parseInt(part);
        return value >= 0 && value <= 255;
    }
}