class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;  // Get the number of rows in the matrix
        if (m == 0) return false;  // If the matrix is empty, return false
        int n = matrix[0].length;  // Get the number of columns in the matrix

        // Perform binary search on the entire matrix, treating it as a flattened array
        int left = 0, right = m * n - 1;  // Define search boundaries
        int pivotIndex, pivotElement;

        while (left <= right) {  // Standard binary search condition
            pivotIndex = (left + right) / 2;  // Find the middle index
            // Convert 1D index to 2D matrix index (row = index / n, col = index % n)
            pivotElement = matrix[pivotIndex / n][pivotIndex % n];

            if (target == pivotElement) return true;  // Target found
            else {
                if (target < pivotElement) {  
                    // If target is smaller, search the left half
                    right = pivotIndex - 1;
                } else {
                    // If target is larger, search the right half
                    left = pivotIndex + 1;
                }
            }
        }
        return false;  // Target not found
    }
}
