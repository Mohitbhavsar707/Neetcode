import java.util.ArrayList;
import java.util.List;
import java.util.Map;


class Solution {

    // List to store all possible letter combinations
    private List<String> combinations = new ArrayList<>();

    // Mapping of digits to corresponding letters (like on a phone keypad)
    private Map<Character, String> letters = Map.of(
        '2', "abc",
        '3', "def",
        '4', "ghi",
        '5', "jkl",
        '6', "mno",
        '7', "pqrs",
        '8', "tuv",
        '9', "wxyz"
    );

    // Variable to store the input digits for reference during recursion
    private String phoneDigits;

    public List<String> letterCombinations(String digits) {
        // If input is empty, return an empty list
        if (digits.length() == 0) {
            return combinations;
        }

        // Store the input digits for use in recursion
        phoneDigits = digits; 

        // Start the backtracking process from index 0 with an empty path
        backTrack(0, new StringBuilder());

        // Return the final list of letter combinations
        return combinations;
    }

    public void backTrack(int index, StringBuilder path) {
        // Base case: If the current path length equals the number of digits, 
        // we have a complete combination, so add it to the list
        if (path.length() == phoneDigits.length()) {
            combinations.add(path.toString()); // Store the valid combination
            return; // Backtrack
        }

        // Get the possible letters for the current digit
        String possibleLetters = letters.get(phoneDigits.charAt(index));

        // Loop through each letter mapped to the current digit
        for (char letter : possibleLetters.toCharArray()) {
            // Append the letter to the current combination
            path.append(letter);

            // Move to the next digit
            backTrack(index + 1, path);

            // Remove the last letter to explore other possibilities (backtracking)
            path.deleteCharAt(path.length() - 1);
        }
    }
}
