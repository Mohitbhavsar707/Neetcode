class Solution {
    public int maxSubArray(int[] nums) {
        //Initialize our variable using the first element
        int currentSubarray = nums[0];
        int maxSubarray = nums[0];

        // Start with the 2nd element since we already used the first one

        for(int i = 1; i < nums.length; i++){
            int num  = nums[i];

            // if current subarray is negative, discard. else, keep adding
            currentSubarray = Math.max(num, currentSubarray + num);
            maxSubarray = Math.max(maxSubarray, currentSubarray);
        }
        
        return maxSubarray;
    }
}