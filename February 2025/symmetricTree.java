/**
 * Definition for a binary tree node.
 */
class Solution {
    
    // Checks if a binary tree is symmetric around its center.
    public boolean isSymmetric(TreeNode root) {
        return checkMirror(root, root);  // Check if the tree is a mirror of itself
    }

    // Recursively checks if two trees are mirror images of each other.
    public boolean checkMirror(TreeNode t1, TreeNode t2) {
        // If both nodes are null, they are mirrors.
        if (t1 == null && t2 == null) {
            return true;
        }

        // If only one of them is null, they are not symmetric.
        if (t1 == null || t2 == null) {
            return false;
        }

        // Nodes must have the same value, and their subtrees should be mirror images.
        return (t1.val == t2.val) 
            && checkMirror(t1.right, t2.left) 
            && checkMirror(t1.left, t2.right);
    }
}
