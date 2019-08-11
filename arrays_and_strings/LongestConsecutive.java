import java.util.*;

public class LongestConsecutive{
    public int longestConsecutive(int[] nums) {
        Set<Integer> hSet = new HashSet<>();
        for(int num : nums){
            hSet.add(num);
        }
        int LongestStreak = 0;
        for(int num : hSet){
            if(!hSet.contains(num-1)){
                int curNum = num;
                int streak = 1;
                while(hSet.contains(curNum+1)){
                    streak += 1;
                    curNum += 1;
                }
                LongestStreak = Math.max(streak, LongestStreak);
            }
        }
        return LongestStreak;
    }

}
