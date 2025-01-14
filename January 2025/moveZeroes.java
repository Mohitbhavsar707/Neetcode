class Solution {
    public void moveZeroes(int[] nums) {
        // 'left' pointer keeps track of where we should place the next non-zero element
        int left = 0;

        // 'right' pointer scans through the entire array looking for non-zero elements
        for(int right = 0; right < nums.length; right++){
            // When we find a non-zero element
            if (nums[right] != 0){
                // Swap the non-zero element with the element at 'left' position
                // This effectively moves non-zero elements to the front of the array
                int temp = nums[right];
                nums[right] = nums[left];
                nums[left] = temp;
                
                // Move 'left' pointer forward to prepare for the next non-zero element
                // This maintains the proper ordering of non-zero elements
                left++;
            }
            // If current element is zero, we skip it and continue scanning with 'right' pointer
        }
        // At the end, all non-zero elements will be at the front (in their original order)
        // and all zeros will be at the back of the array
    }
}