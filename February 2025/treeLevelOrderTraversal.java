import java.util.*;
import java.io.*;

class Node {
    Node left;
    Node right;
    int data;
    
    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

class Solution {

	/* 
    
    class Node 
    	int data;
    	Node left;
    	Node right;
	*/
	public static void levelOrder(Node root) {
        if(root == null){
            return;
        }
        
        // Need to go left first then right
        LinkedList<Node> list = new LinkedList<>();
        list.add(root);
        while(list.isEmpty()){
            Node currentNode = list.poll(); // gets the front of the list in a queue format - FIrst in first out
            System.out.print(currentNode.data + " ");
            
            if(currentNode.left != null){ // Print left node
                list.add(currentNode.left);
            }
            if(currentNode.right != null){ // Print right node
                list.add(currentNode.right);
            }
        }
      
    }

	public static Node insert(Node root, int data) {
        if(root == null) {
            return new Node(data);
        } else {
            Node cur;
            if(data <= root.data) {
                cur = insert(root.left, data);
                root.left = cur;
            } else {
                cur = insert(root.right, data);
                root.right = cur;
            }
            return root;
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        Node root = null;
        while(t-- > 0) {
            int data = scan.nextInt();
            root = insert(root, data);
        }
        scan.close();
        levelOrder(root);
    }	
}