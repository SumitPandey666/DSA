package HashMap;

import java.util.HashMap;

public class LongestSubString {
    public static void main(String[] args) {
        String str = "abcabcbb";
        int len = findLengthOfLongestSubstring(str);
        System.out.println("Maximum length substring is of length: " + len);
    }

    public static int findLengthOfLongestSubstring(String str) {
        if (str == null || str.isEmpty()) return 0;

        int left = 0, maxLen = 0;
        HashMap<Character, Integer> map = new HashMap<>();

        for (int right = 0; right < str.length(); right++) {
            char c = str.charAt(right);

            if (map.containsKey(c)) {
                left = Math.max(left, map.get(c) + 1);
            }

            map.put(c, right);
            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }
}
