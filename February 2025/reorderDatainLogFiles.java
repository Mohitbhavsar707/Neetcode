import java.util.Arrays;

class Solution {
    // Splits the log into two parts: identifier and content
    private String[] splitStr(String log) {
        return log.split(" ", 2); // Splits at the first space only
    }

    // Checks if a character is a digit (0-9)
    private boolean isNumber(char curChar) {
        return '0' <= curChar && curChar <= '9'; // Returns true if it's a number, otherwise false
    }

    public String[] reorderLogFiles(String[] logs) {
        // Sorting the logs using custom rules
        Arrays.sort(logs, (log1, log2) -> {
            // Split both logs into identifier and content
            String[] arr1 = splitStr(log1);
            String[] arr2 = splitStr(log2);

            // Check if the first character of the content is a number (indicating a digit log)
            boolean isNum1 = isNumber(arr1[1].charAt(0));
            boolean isNum2 = isNumber(arr2[1].charAt(0));

            // Case 1: Both logs are digit logs → Maintain original order
            if (isNum1 && isNum2) {
                return 0; // Digit logs remain in original order
            } 
            // Case 2: Only the first log is a digit log → Move it after letter logs
            else if (isNum1) {
                return 1; // Digit logs should be placed later
            } 
            // Case 3: Only the second log is a digit log → Move it after letter logs
            else if (isNum2) {
                return -1; // Letter logs should come first
            }

            // Case 4: Both logs are letter logs → Sort them lexicographically
            // First, compare by content
            int cmp = arr1[1].compareTo(arr2[1]);
            if (cmp == 0) {
                // If contents are the same, sort by identifier
                return arr1[0].compareTo(arr2[0]);
            }
            return cmp; // Otherwise, sort by content
        });

        return logs; // Return the sorted logs
    }
}
