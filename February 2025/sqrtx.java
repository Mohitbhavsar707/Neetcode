class Solution {
    public int mySqrt(int x) {
        if (x < 0) return -1; // Square root of negative number is undefined in int
        
        if (x == 0 || x == 1) return x; // sqrt(0) = 0, sqrt(1) = 1
        
        int left = 1, right = x, ans = 0;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            if (mid <= x / mid) { // Avoid overflow by using division instead of multiplication
                ans = mid; // Store the potential answer
                left = mid + 1; // Try to find a larger integer sqrt
            } else {
                right = mid - 1; // Reduce search space
            }
        }
        
        return ans;
    }
}
