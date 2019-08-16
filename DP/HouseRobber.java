public class HouseRobber{
    public int rob(int[] nums) {
        int rob = 0;
        int notRob = 0;
        for(int num : nums){
            int curRob = notRob + num;
            notRob = Math.max(rob,notRob);
            rob = curRob;
        }
        return Math.max(rob, notRob);
    }
}
