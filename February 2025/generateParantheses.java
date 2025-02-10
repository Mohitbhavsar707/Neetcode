import java.util.ArrayList;
import java.util.List;


class Solution {
    public List<String> generateParenthesis(int n) {
        // List to store all valid combinations of parentheses
        List<String> answer = new ArrayList<>();
        
        // Start backtracking with an empty string, 0 open and close braces
        backTracking(answer, new StringBuilder(), 0, 0, n);
        
        // Return the final list of valid parentheses combinations
        return answer;
    }
    
    private void backTracking(List<String> answer, StringBuilder currentStr, int openBrace, int closeBrace, int n) {
        // Base case: If the current string reaches the target length (2*n), add it to the result list
        if (currentStr.length() == 2 * n) {
            answer.add(currentStr.toString()); // Store valid combination
            return;
        }
        
        // If the number of open parentheses used is less than 'n', we can add another '('
        if (openBrace < n) {
            currentStr.append("("); // Add '(' to the current string
            backTracking(answer, currentStr, openBrace + 1, closeBrace, n); // Recursive call
            currentStr.deleteCharAt(currentStr.length() - 1); // Backtrack: Remove the last added '('
        }
        
        // If the number of closing parentheses used is less than open ones, we can add a ')'
        if (openBrace > closeBrace) {
            currentStr.append(")"); // Add ')' to the current string
            backTracking(answer, currentStr, openBrace, closeBrace + 1, n); // Recursive call
            currentStr.deleteCharAt(currentStr.length() - 1); // Backtrack: Remove the last added ')'
        }
    }
}
