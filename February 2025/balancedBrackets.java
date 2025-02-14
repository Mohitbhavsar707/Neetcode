import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {

    /*
     * Complete the 'isBalanced' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */

    public static String isBalanced(String s) {
        // Stack of characters - Follows LIFO
        // If you see opening brace, put it on the stack, when we see closing brace - check with the top of the stack - if it matches
        // Pop it off and keep going, if not, return null and done
        Stack<Character> stack = new Stack<>();
        
        for (int i = 0; i < s.length(); i++){
            if( s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[') {
                stack.push(s.charAt(i));
            }else {
                if (stack.isEmpty()){
                    return "NO";
                } else {
                    char current_value_to_check = stack.pop();
                    if (s.charAt(i) == ')' && current_value_to_check != '('){
                        return "NO";
                    } else if (s.charAt(i) == ']' && current_value_to_check != '['){
                        return "NO";
                    } else if (s.charAt(i) == '}' && current_value_to_check != '{'){
                        return "NO";
                    }
                }
            }
        }
        
        if(stack.isEmpty()){
            return "YES";
        }else {
            return "NO";
        }

    }

}

 class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        for (int tItr = 0; tItr < t; tItr++) {
            String s = bufferedReader.readLine();

            String result = Result.isBalanced(s);

            bufferedWriter.write(result);
            bufferedWriter.newLine();
        }

        bufferedReader.close();
        bufferedWriter.close();
    }
}
