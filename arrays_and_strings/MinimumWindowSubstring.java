import java.util.*;

class MinimumWindowSubstring {
  public String minWindow(String s, String t) {
      if (s.length() == 0 || t.length() == 0){
          return "";
      }
      Map<Character, Integer> dict = new HashMap<>();
      for (int i = 0; i < t.length(); i+=1){
          int count = dict.getOrDefault(t.charAt(i), 0);
          dict.put(t.charAt(i), count+1);
      }
      int required = dict.size();
      int l = 0, r = 0;
      int formed = 0;
      int[] ans = {-1, 0, 0};

      HashMap<Character, Integer> window = new HashMap<>();

      while (r<s.length()){
          char c = s.charAt(r);
          int count = window.getOrDefault(c, 0);
          window.put(c, count + 1);
          if(dict.containsKey(c) && dict.get(c).intValue() == window.get(c).intValue()){
              formed += 1;
          }
          while(l<=r && formed == required){
              c = s.charAt(l);
              if(ans[0] == -1 || ans[0] > r-l+1){
                  ans[0] = r-l+1;
                  ans[1] = l;
                  ans[2] = r;
              }
              window.put(c, window.get(c) - 1);
              if(dict.containsKey(c) && dict.get(c).intValue() > window.get(c).intValue()){
                  formed -= 1;
              }
              l += 1;
          }
          r += 1;
      }
      return ans[0] == -1 ? "" : s.substring(ans[1], ans[2]+1);
  }
}

