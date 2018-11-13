public class Solution{
	public int lengthOfLongestSubstring(String s){
		int i=0;
		int j = 0;
		int result = 0;
		int length = s.length();
		Set<Character> s = new HashSet<>();
		while(i < s && j<s){
			if(!s.contains(s.charAt(j))){
				s.add(s.charAt(j++));
				Math.max(result, j-1);
			}
			else{
				s.remove(s.charAt(i));
			}
		}
		return result;
	}
}