import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Definition for a binary tree node.
 */
 class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    // Constructors for TreeNode
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        // If the tree is empty, return an empty list
        if (root == null) {
            return new ArrayList<List<Integer>>();
        }

        // Final list to store the zigzag level order traversal
        List<List<Integer>> results = new ArrayList<List<Integer>>();

        // Queue for BFS traversal, initialized with the root node and a null marker for levels
        LinkedList<TreeNode> traversalQueue = new LinkedList<TreeNode>();
        traversalQueue.addLast(root);
        traversalQueue.addLast(null); // Marker to indicate the end of a level

        // LinkedList to store node values of the current level
        LinkedList<Integer> currentLevelValuesList = new LinkedList<Integer>();

        // Boolean flag to track zigzag direction (true = left to right, false = right to left)
        boolean isLeftToRight = true;

        // Standard BFS loop
        while (traversalQueue.size() > 0) {
            // Remove the first element from the queue
            TreeNode currentNode = traversalQueue.pollFirst();

            if (currentNode != null) {
                // Add node value to the current level's list based on traversal direction
                if (isLeftToRight) {
                    currentLevelValuesList.addLast(currentNode.val);  // Append at the end (FIFO)
                } else {
                    currentLevelValuesList.addFirst(currentNode.val); // Insert at the front (LIFO)
                }

                // Add left child to queue if exists
                if (currentNode.left != null) {
                    traversalQueue.addLast(currentNode.left);
                }

                // Add right child to queue if exists
                if (currentNode.right != null) {
                    traversalQueue.addLast(currentNode.right);
                }
            } else {
                // End of a level reached, add current level values to the results list
                results.add(currentLevelValuesList);
                currentLevelValuesList = new LinkedList<Integer>(); // Reset list for next level

                // If more nodes exist, add a new null marker to separate levels
                if (traversalQueue.size() > 0) {
                    traversalQueue.addLast(null);
                    isLeftToRight = !isLeftToRight; // Toggle direction for next level
                }
            }
        }

        return results; // Return the final zigzag level order traversal
    }
}
