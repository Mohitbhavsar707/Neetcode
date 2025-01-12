class Solution {
    public boolean isPalindrome(String s) {
        int l = 0; // Pointer 1 Set to the start
        int r = s.length() - 1; // Pointer 2 set to the end of String

        while ( l < r) { // While the pointers are not at same spot
            while (l < r && !alphaNum(s.charAt(l))) { // While pointers not together and the current char is a valid char
                l++; //move right to next valid character in String
            }
            while (r > l && !alphaNum(s.charAt(r))){ // While pointers not together, and current char is valid
                r--; //move left to next valid character
            }
            if (Character.toLowerCase(s.charAt(l)) != Character.toLowerCase(s.charAt(r))){ // check to see if both are same
                return false;
            }
            l++; // next index
            r--; // next index
        }
        return true;
    }

    public boolean alphaNum(char c){
        return (c >= 'A' && c<= 'Z' || c >= 'a' && c <= 'z' || c >= '0' && c<= '9');
    }
}
