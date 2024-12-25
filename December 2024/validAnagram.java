import java.util.HashMap;

class Solution {
    public boolean isAnagram(String s, String t) {
        //HashMap: Uses Key and Value.
        // E.g. Word is Book
        // {b,1}{o,2}{k,1}, key value pairs, 
        // Need to check if String t follows same value for same keys
        //Compare counts for the keys are the same then return true
        //Iterate through one string, then make sure count is same in next string
        //Check if the length is same initially for both

        //Check Length
        if (s.length() != t.length()){
            return false;
        }

        HashMap<Character, Integer> countS = new HashMap<>();
        HashMap<Character, Integer> countT = new HashMap<>();

        for(int i = 0; i < s.length(); i++){
            //Count each occurance - if the key doesnt exist, default value it will return is 0
            countS.put(s.charAt(i), countS.getOrDefault(s.charAt(i), 0) + 1);
            countT.put(t.charAt(i), countT.getOrDefault(t.charAt(i), 0) + 1);
        }
        return countS.equals(countT); // will return true or false
      
    }
}

