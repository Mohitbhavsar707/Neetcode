import java.util.Arrays;


class Solution {
    public int[][] kClosest(int[][] points, int k) {

        // Sort the arrray with custom lambda comparator fn
        Arrays.sort(points, (a,b) -> squaredDistance(a) - squaredDistance(b));

        return Arrays.copyOf(points, k); // return the first k elements of the sorted array
        
    }

    private int squaredDistance(int[] point){
        return point[0] * point[0] + point[1] * point[1]; // Calculate and return squared Euclidean distance
    }
}