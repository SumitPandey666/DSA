package HashMap;

import java.util.*;

public class GroupAnagrams {
    public static void main(String[] args){
        String[] strs = {"eat","tea","tan","ate","nat","bat"};
        System.out.println(groupAnagram(strs));
        System.out.println(groupAnagramForLongStrings(strs));

    }
    public static List<List<String>> groupAnagram(String[] strs){
        Map<String, List<String>> map = new HashMap<>();

        for(String s : strs){
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String sortedKey = new String(chars);

            if(!map.containsKey(sortedKey)){
                map.put(sortedKey, new ArrayList<>());
            }

            map.get(sortedKey).add(s);
        }
        return new ArrayList<>(map.values());
    }

    public static List<List<String>> groupAnagramForLongStrings(String[] strs) {
        if (strs == null || strs.length == 0) return new ArrayList<>();

        Map<String, List<String>> map = new HashMap<>();

        for (String s : strs) {
            int[] count = new int[26];
            for (char c : s.toCharArray()) {
                count[c - 'a']++;
            }

            StringBuilder sb = new StringBuilder();
            for (int i : count) {
                sb.append('#');
                sb.append(i);
            }

            String key = sb.toString();
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(s);
        }
        return new ArrayList<>(map.values());
    }
}
