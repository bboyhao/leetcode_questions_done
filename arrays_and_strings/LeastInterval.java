import java.util.*;

public class LeastInterval{
    public int leastInterval(char[] tasks, int n) {
        int[] map = new int[26];
        for(char c : tasks){
            map[c-'A']++;
        }
        int maxInterval = map[25] -1;
        int idolSlots = maxInterval * n;
        for(int i = 24; i>=0 && map[i] >0; i--){
            idolSlots -= Math.min(maxInterval, map[i]);
        }
        return idolSlots > 0?idolSlots + tasks.length:tasks.length;
    }
}
