package HashMap;

import java.util.HashMap;
import java.util.Map;

public class WordPattern {
    public static void main(String[] args){
        String pattern = "abba";
        String s = "dog cat cat what";
        System.out.println(isWordPattern(pattern,s));
    }
    public static boolean isWordPattern(String pattern,String s){
        String[] words = s.split(" ");
        if(pattern.length() != words.length) return false;

        Map<Character,String> mapcs = new HashMap<>();
        Map<String,Character> mapsc = new HashMap<>();

        for(int i = 0; i < pattern.length(); i++){
            char c = pattern.charAt(i);
            String word = words[i];

            if(mapcs.containsKey(c)){
                if(!mapcs.get(c).equals(word)) return false;
            } else {
                mapcs.put(c, word);
            }

            if(mapsc.containsKey(word)){
                if(mapsc.get(word) != c) return false;
            } else {
                mapsc.put(word, c);
            }
        }
        return true;
    }
}
