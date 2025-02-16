class Solution {
    // Pointers to track the current index in both arrays
    private int p1 = 0, p2 = 0;

    // Function to get the smaller value between nums1[p1] and nums2[p2], advancing the pointer accordingly
    private int getMin(int[] nums1, int[] nums2) {
        if (p1 < nums1.length && p2 < nums2.length) {
            // Compare values and increment the pointer of the selected array
            return nums1[p1] < nums2[p2] ? nums1[p1++] : nums2[p2++];
        } else if (p1 < nums1.length) {
            // If nums2 is exhausted, take from nums1
            return nums1[p1++];
        } else if (p2 < nums2.length) {
            // If nums1 is exhausted, take from nums2
            return nums2[p2++];
        }
        return -1; // This case should never be reached if inputs are valid
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        
        // If the total number of elements is even
        if ((m + n) % 2 == 0) {
            // Move to the middle element (ignoring the first half)
            for (int i = 0; i < (m + n) / 2 - 1; ++i) {
                int tmp = getMin(nums1, nums2);
            }
            // The median is the average of the next two smallest numbers
            return (double) (getMin(nums1, nums2) + getMin(nums1, nums2)) / 2;
        } else {
            // If the total number of elements is odd, find the middle element directly
            for (int i = 0; i < (m + n) / 2; ++i) {
                int tmp = getMin(nums1, nums2);
            }
            return getMin(nums1, nums2); // Return the middle element
        }
    }
}
