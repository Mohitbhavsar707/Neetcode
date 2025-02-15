class BinaryTreeNode {
    int value;
    BinaryTreeNode left, right;

    public BinaryTreeNode(int value) {
        this.value = value;
        this.left = this.right = null;
    }
}

public class BSTtoDoublyLinkedList{
    private BinaryTreeNode lastNodeInList = null;

    public BinaryTreeNode convert(BinaryTreeNode root){
        if(root == null){
            return null;
        }

        //Convert BST to doubly linked list
        convertNode(root);

        BinaryTreeNode head = lastNodeInList;
        while(head != null && head.left != null){
            head = head.left;
        }
        return head;
    }

    private void convertNode(BinaryTreeNode node) {
        if(node == null) return;

        //Convert left subtree
        if(node.left != null){
            convertNode(node.left);
        }

        // Link the current node with the previous node in DLL
        node.left = lastNodeInList;
        if(lastNodeInList != null){
            lastNodeInList.right = node;
        }

        //Move the last processed node to the current node
        lastNodeInList = node;

        if(node.right != null){
            convertNode(node.right);
        }
    }

    public void printList(BinaryTreeNode head){
        BinaryTreeNode current = head;

        while(current != null){
            System.out.print(current.value + " ");
            current = current.right;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        BinaryTreeNode root = new BinaryTreeNode(10);
        root.left = new BinaryTreeNode(6);
        root.right = new BinaryTreeNode(14);
        root.left.left = new BinaryTreeNode(4);
        root.left.right = new BinaryTreeNode(8);
        root.right.left = new BinaryTreeNode(12);
        root.right.right = new BinaryTreeNode(16);

        BSTtoDoublyLinkedList converter = new BSTtoDoublyLinkedList();
        BinaryTreeNode head = converter.convert(root);

        // Print the converted Doubly Linked List
        converter.printList(head);
    }
}