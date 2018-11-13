class Solution {
    public int minSteps(int n) {
    	int result = 0;
    	int d = 2;
    	while(n>1){
    		while(n%d == 0){
    			result+=d;
    			n/=d;
    		}
    		d++;
    	}
    	return result;
    }
}