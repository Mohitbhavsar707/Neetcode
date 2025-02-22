package tree_questions;
// Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class Solution {

    // Helper function to validate if the tree is a BST within a given range
    public boolean validate(TreeNode root, Integer low, Integer high) {
        
        // Base case: If we reach a null node, it's a valid BST by default
        if (root == null) {
            return true;
        }

        // Check if the current node violates the BST property:
        // - If 'low' is not null and root.val is less than or equal to 'low', it's invalid
        // - If 'high' is not null and root.val is greater than or equal to 'high', it's invalid
        if ((low != null && root.val <= low) || (high != null && root.val >= high)) {
            return false;
        }

        // Recursively validate the right subtree:
        // - The right subtree should have values greater than the current node's value
        // - Therefore, we update 'low' to root.val (new lower bound)
        boolean isRightValid = validate(root.right, root.val, high);

        // Recursively validate the left subtree:
        // - The left subtree should have values less than the current node's value
        // - Therefore, we update 'high' to root.val (new upper bound)
        boolean isLeftValid = validate(root.left, low, root.val);

        // The tree is a valid BST only if both left and right subtrees are valid
        return isRightValid && isLeftValid;
    }

    // Main function to check if the given tree is a valid BST
    public boolean isValidBST(TreeNode root) {
        // Start validation with no initial min/max constraints
        return validate(root, null, null);
    }
}
// Time Complexity: O(n)
// Space Complexity: O(n)