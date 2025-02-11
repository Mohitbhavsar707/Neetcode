class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length;
        int left = 0, right = n - 1;

        // Find the index of the pivot element (smallest element)
        while ( left <= right){
            int mid = (left + right) / 2;
            if(nums[mid] > nums[n-1]){
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        // Binary Search over elements on the pivots left elements
        int answer = binarySearch(nums, 0, left - 1, target);
        if(answer != -1){
            return answer;
        }

        //Binary search over the pivot right elements
        return binarySearch(nums, left, n-1, target);   
    }

private int binarySearch(int[] nums, int leftBoundary, int rightBoundary, int target) {
    int left = leftBoundary, right = rightBoundary;
    
    while (left <= right) {  // Continue searching until left exceeds right
        int mid = left + (right - left) / 2;  // Avoids overflow compared to (left + right) / 2

        if (nums[mid] == target) {
            return mid;  // Target found
        } else if (nums[mid] > target) {
            right = mid - 1;  // Search left half
        } else {
            left = mid + 1;  // Search right half
        }
    }

    return -1;  // Target not found
}

}