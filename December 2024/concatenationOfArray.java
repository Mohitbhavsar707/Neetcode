class Solution {
    public int[] getConcatenation(int[] nums) {
        // Create an array 'ans' with twice the length of 'nums'.
        int[] ans = new int[2 * nums.length];

        // Loop through each element in 'nums'.
        for (int i = 0; i < nums.length; i++) {
            // Assign the current element to both halves of 'ans'.
            ans[i] += nums[i];
            ans[i + nums.length] += nums[i];
        }

        // Return the concatenated array.
        return ans;
    }
}


//Time Complexity: O(n), as the loop runs once for the length of the array.
//Space Complexity: O(n), since a new array of size 2 * nums.length is created.
