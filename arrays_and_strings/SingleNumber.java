import java.util.*;

public class SingleNumber{
    //Math solution: 2*(a+b+c)-(a+a+b+b+c) = c
    public int singleNumber1(int[] nums){
        Set<Integer> s = new HashSet<>();
        int sum = 0;
        for(int num : nums){
            sum += num;
            s.add(num);
        }
        int setSum = 0;
        for(int num : s){
            setSum += num;
        }
        return 2*setSum - sum;
    }

    //bit manipulation
    public int singleNumber2(int[] nums){
        int result = 0;
        for(int num : nums){
            result ^= num;
        }
        return result;
    }
}
