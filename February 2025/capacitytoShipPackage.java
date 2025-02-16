class Solution {

    // Check whether the packages can be shipped within "days" days 
    // using a ship with capacity 'c'.
    Boolean feasible(int[] weights, int c, int days) {
        int daysNeeded = 1, currentLoad = 0;

        // Iterate through each package weight
        for (int weight : weights) {
            currentLoad += weight;

            // If adding this package exceeds capacity, start a new day
            if (currentLoad > c) {
                daysNeeded++;   // Increment the number of days needed
                currentLoad = weight; // Reset current load for the new day
            }
        }

        // Return true if we can ship within the given number of days
        return daysNeeded <= days;
    }

    public int shipWithinDays(int[] weights, int days) {
        int totalLoad = 0, maxLoad = 0;

        // Calculate the total weight and the heaviest package
        for (int weight : weights) {
            totalLoad += weight;       // Sum of all package weights
            maxLoad = Math.max(maxLoad, weight); // Heaviest package
        }

        // Define the search range: [maxLoad, totalLoad]
        int l = maxLoad, r = totalLoad;

        // Perform binary search to find the minimum required ship capacity
        while (l < r) {
            int mid = (l + r) / 2; // Find the midpoint (possible capacity)

            // If it's feasible to ship within "days" using "mid" capacity
            if (feasible(weights, mid, days)) {
                r = mid; // Try a smaller capacity
            } else {
                l = mid + 1; // Increase capacity
            }
        }

        // The smallest valid capacity found
        return l;
    }
}
