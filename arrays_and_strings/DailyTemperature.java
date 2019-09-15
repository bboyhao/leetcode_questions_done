import java.util.*;

public class DailyTemperature{
    //traverse the whole array
    //Time: O(n^2) Space: O(1)
    public int[] dailyTemperatures(int[] T) {
        int[] result = new int[T.length];
        for(int i = 0; i<T.length; i++){
            int index = i+1;
            while(index<T.length){
                if(T[index] > T[i]){
                    result[i] = index-i;
                    break;
                }
                index++;
            }
            if(index == T.length){
                result[i] = 0;
            }
        }
        return result;
    }

    public int[] dailyTemperatures2(int[] T){
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[T.length];
        for(int i = T.length-1; i>=0;i--){
            while(!stack.isEmpty() && T[i] >= T[stack.peek()]) stack.pop();
            result[i] = stack.isEmpty()?0:stack.peek()-i;
            stack.push(i);
        }
        return result;
    }
}
