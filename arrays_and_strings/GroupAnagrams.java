import java.util.*;

public class GroupAnagrams{
    public List<List<String>> groupAnagrams(String[] strs) {
        if(strs== null|| strs.length == 0){
            return new ArrayList<>();
        }
        HashMap<String, List<String>> map = new HashMap<>();
        for (int i = 0; i<strs.length; i+=1){
            String tmp = strs[i].toLowerCase();
            char[] array = tmp.toCharArray();
            Arrays.sort(array);
            tmp = new String(array);
            if(!map.containsKey(tmp)){
                map.put(tmp, new ArrayList<String>());
            }
            map.get(tmp).add(strs[i]);
        }
        return new ArrayList<>(map.values());
    }
}
