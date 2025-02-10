
  public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
 
class Solution {
    private int diameter;


    public int diameterOfBinaryTree(TreeNode root) {
        diameter = 0;
        longestPath(root);
        return diameter;
    }

    private int longestPath(TreeNode node){
        if(node == null){
            return 0;
        }

        //Recursively find the longest path in both
        // left child and right child
        int leftPath = longestPath(node.left);
        int rightPath = longestPath(node.right);

        //Update the diameter if leftPath + rightPath is larger
        diameter = Math.max(diameter, leftPath + rightPath);

        //Return the longest one between LP and RP, add 1 to parent
        // since theres a connecting branch from node to parent
        return Math.max(leftPath, rightPath) + 1;

    }
}