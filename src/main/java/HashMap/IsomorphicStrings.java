package HashMap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class IsomorphicStrings {
    public static void main(String[] args) {
        String s = "badc";
        String t = "baba";
        System.out.println(isIsomorphicStrings(s,t));
    }
    public static boolean isIsomorphicStrings(String s, String t) {
        if (s.length() != t.length()) return false;

        HashMap<Character, Character> sMapTot = new HashMap<>();
        HashSet<Character> usedInT = new HashSet<>();

        for (int i = 0; i < s.length(); i++) {
            char charS = s.charAt(i);
            char charT = t.charAt(i);

            if (sMapTot.containsKey(charS)) {
                if (sMapTot.get(charS) != charT) return false;
            } else {
                if (usedInT.contains(charT)) return false;
                sMapTot.put(charS, charT);
                usedInT.add(charT);
            }
        }
        return true;
    }
    public static boolean isIsomorphicStringsArrayBased(String s, String t) {
        int[] m1 = new int[256];
        int[] m2 = new int[256];
        int n = s.length();

        for (int i = 0; i < n; i++) {
            char charS = s.charAt(i);
            char charT = t.charAt(i);

            if (m1[charS] != m2[charT]) {
                return false;
            }

            m1[charS] = i + 1;
            m2[charT] = i + 1;
        }

        return true;
    }
}
