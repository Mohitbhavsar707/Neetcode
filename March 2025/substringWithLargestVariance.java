class Solution {
    public int largestVariance(String s) {
        int[] counter = new int[26]; // we know s contains only 26 diff letters so we can set the size
        for(char ch : s.toCharArray()){
            counter[(int)(ch - 'a')]++; // keeps track of how many times each letter from a-z appears in string and stores that count
            // e.g string abc, 'a' - 'a' = 0, maps a to index 0
            // 'c' - 'a' = 2, maps c to index 2
            // We want to use an array counter where each index corresponds to a letter from 'a' to 'z'. To update the frequency of a letter, we need to map the letter to the correct index in the array:
        }

        int globalMax = 0;

        for(int i = 0; i < 26; i++){
            for(int j = 0; j < 26; j++){
                // Maor and minor cannot be same, and both must appear in s

                if (i == j || counter[i] == 0 || counter[j] == 0){
                    continue;
                }

                // Find the maximum variance by doing major - minor (freq(ch1) - freq(ch2))

                char major = (char)('a' + i); // convert index i to the major letter
                char minor = (char)('a' + j); // convert index j to the minor letter

                // set up counts for major and minor in current substring
                int majorCount = 0;
                int minorCount = 0;

                // set up the number of remaining minor letters in the rest of the string
                int restMinor = counter[j];

                // Loop through, calculate variance for each substring
                for(char ch : s.toCharArray()){
                    if(ch == major){
                        majorCount++;
                    }

                    if(ch == minor){
                        minorCount++;
                        restMinor--; // total left decreases
                    }

                    // Only update globalMax is we see at least one minor letter
                    if(minorCount > 0){
                        globalMax = Math.max(globalMax, majorCount - minorCount);
                    }

                    // If majorCount < minorCount and there are more minor chars left, reset to 0
                    if(majorCount < minorCount && restMinor > 0){
                       majorCount = 0;
                       minorCount = 0;
                    }
                }
            }
        }
        return globalMax;
    }
}