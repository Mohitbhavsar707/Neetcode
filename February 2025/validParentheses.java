import java.util.Map;
import java.util.Stack;

class Solution {
    private static final Map<Character, Character> map = Map.of(
    '(', ')', 
    '{', '}', 
    '[', ']'
);

    //Time: O(n)
    //Space: Stack declared for extra memory, O(n)
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for( char c: s.toCharArray()){
            if (map.containsKey(c)){
                stack.push(c);
            } else {
                if(stack.isEmpty()){
                    return false;
                }
                char open = stack.pop();
                if (map.get(open) != c){
                    return false;
                }
            }
        }
        return stack.isEmpty();
        
    }
}
