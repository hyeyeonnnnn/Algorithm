import java.util.HashMap;
class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        
         for(int i=0;i<nums.length;i++){
	            map.put(nums[i], 1);
	        }
		 if(map.size()>=nums.length/2) 
			 return nums.length/2;
		 else
			 return map.size();
    }
    
    
}