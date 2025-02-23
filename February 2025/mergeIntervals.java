import java.util.Arrays;
import java.util.LinkedList;

class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> Integer.compare(a[0], b[0]));
        LinkedList<int[]> merged = new LinkedList<>();
        for(int[] interval : intervals){
            // If the list of merged intervals is empty or if the 
            // current interval does not overalp with the previous, just append it
            if(merged.isEmpty() || merged.getLast()[1] < interval[0]){
                merged.add(interval);
            }

            // If there is overlap, merge the current and previous intervals
            else {
                merged.getLast()[1] = Math.max(
                    merged.getLast()[1],
                    interval[1]
                );
            }
        }
        return merged.toArray(new int[merged.size()][]);
    }
}