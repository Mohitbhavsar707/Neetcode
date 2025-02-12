public /**
* Definition for a binary tree node.
* public class TreeNode {
*     int val;
*     TreeNode left;
*     TreeNode right;
*     TreeNode() {}
*     TreeNode(int val) { this.val = val; }
*     TreeNode(int val, TreeNode left, TreeNode right) {
*         this.val = val;
*         this.left = left;
*         this.right = right;
*     }
* }
*/
class Solution {

   // Stores the depth of the first node (x or y) found
   int depthRecorded = -1;  
   // Flag to indicate if x and y are cousins
   boolean cousinFound = false;  

   private boolean depthFirstSearch(TreeNode node, int depth, int x, int y) {
       if (node == null) {
           return false; // Base case: reached a null node
       }

       // If a node was already found, stop searching deeper if depth exceeds recorded depth
       if (this.depthRecorded != -1 && depth > this.depthRecorded) {
           return false;
       }

       // If the current node is either x or y
       if (node.val == x || node.val == y) {
           if (this.depthRecorded == -1) {
               this.depthRecorded = depth; // Record depth of the first node found
           }
           return this.depthRecorded == depth; // Return true if second node is at the same depth
       }

       // Recursively search left and right subtrees, increasing depth
       boolean left = depthFirstSearch(node.left, depth + 1, x, y);
       boolean right = depthFirstSearch(node.right, depth + 1, x, y);

       // If x and y are found in different subtrees and are not at the same depth level
       if (left && right && this.depthRecorded != depth + 1) {
           this.cousinFound = true; // Nodes are cousins
       }
       
       return left || right; // Return true if either left or right subtree contains x or y
   }

   public boolean isCousins(TreeNode root, int x, int y) {
       depthFirstSearch(root, 0, x, y); // Start DFS from root at depth 0
       return this.cousinFound; // Return whether x and y are cousins
   }
}

