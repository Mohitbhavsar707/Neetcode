class Solution {
    public int lengthOfLongestSubstring(String s) {
        Integer[] chars = new Integer[128]; // Array to store the last seen index of characters
        
        int left = 0; // Left pointer of the sliding window
        int right = 0; // Right pointer of the sliding window
        int res = 0; // Variable to store the maximum length of substring found
        
        while (right < s.length()) { // Iterate through the string
            char r = s.charAt(right); // Get the current character at right pointer
            Integer index = chars[r]; // Retrieve last seen index of the character
            
            // If the character was seen before and is within the current window
            if (index != null && index >= left && index < right) {
                left = index + 1; // Move the left pointer past the last occurrence of the character
            }
            
            res = Math.max(res, right - left + 1); // Update max length found so far
            chars[r] = right; // Store/update the last seen index of the character
            right++; // Move the right pointer to process next character
        }
        return res; // Return the length of the longest substring without repeating characters
    }
}

// Time Complexity: O(n), where n is the length of the string. Each character is processed once.
// Space Complexity: O(1), since we use a fixed-size array (128 elements) for tracking character indices.
