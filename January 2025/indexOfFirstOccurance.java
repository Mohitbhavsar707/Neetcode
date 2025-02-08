class Solution {
    public int strStr(String haystack, String needle) {
        if (needle.length() == 0){
            return 0;
        }

        int minIndex = Integer.MAX_VALUE;

        for(int i = 0; i <= haystack.length() - needle.length(); i++){
        // The loop iterates over the haystack string, starting from index 0 to 
        // the position where the remaining length of haystack is enough to fit needle.    
            if(haystack.substring(i, i + needle.length()).equals(needle)){
                minIndex = Math.min(minIndex, i);
                //ensures that minIndex always holds the smallest index where needle occurs.
            }
        }

        if (minIndex == Integer.MAX_VALUE){
            return - 1;
        } 

        return minIndex;
    }
}