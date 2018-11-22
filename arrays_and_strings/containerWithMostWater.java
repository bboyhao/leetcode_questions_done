class Solution {
    //time complexity is O(n^2)
    public int maxArea(int[] height) {
        if(height==null||height.length==0||height.length==1)return 0;
        int max = 0;
        int area= 0;
        for(int i = 0;i<height.length;i++){
            for(int j = i+1;j<height.length;j++){
                area = Math.min(height[i],height[j])*(j-i);
                if(area>max) max=area;
            }
        }
        return max;
    }
    //time complexity is O(n)
    public int maxArea2(int[] height){
        if(height.length<2) return 0;
        int i=0, j=height.length-1, max=0;
        while(i<j){
            max = Math.max(Math.min(height[i],height[j])*(j-i), max);
            if(height[i]<height[j]){
                i++;
            }
            else{
                j--;
            }
        }
        return max;
    }
}
