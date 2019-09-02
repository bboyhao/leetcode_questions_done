import java.util.*;

public class FindAnagrams{
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new LinkedList<>();
        if(p.length() > s.length()) return result;
        HashMap<Character, Integer> map = new HashMap<>();
        for(char c : p.toCharArray()){
            map.put(c, map.getOrDefault(c, 0)+1);
        }
        for(int i = 0; i<p.length(); i++){
            char cur = s.charAt(i);
            if(map.containsKey(cur)){
                map.put(cur, map.get(cur) - 1);
            }
        }
        int zeroChars = 0;
        for(int v : map.values()){
            if(v == 0) zeroChars +=1;
        }
        if(zeroChars == map.size()) result.add(0);
        for(int i = 1; i<=s.length()-p.length(); i++){
            char pre = s.charAt(i -1);
            if(map.containsKey(pre)){
                if(map.get(pre) == 0) zeroChars -= 1;
                map.put(pre, map.get(pre) + 1);
                if(map.get(pre) == 0) zeroChars += 1;

            }
            char cur = s.charAt(i+p.length()-1);
            if(map.containsKey(cur)){
                if(map.get(cur) == 0) zeroChars -= 1;
                map.put(cur, map.get(cur) - 1);
                if(map.get(cur) == 0) zeroChars += 1;
            }
            if(zeroChars == map.size()){
                result.add(i);
            }
        }
        return result;
    }
}
