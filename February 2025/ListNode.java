
public class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

// Iterative Solution
class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode prevNode = null; // Start of the list
        ListNode currNode = head; // Begin point

        while (currNode != null) {
            ListNode nextNode = currNode.next; // Save node at next to local var
            currNode.next = prevNode; // Point to the next node
            prevNode = currNode; // reassign prev node
            currNode = nextNode; // reassign curr node to next node
            // At the end of the list, currNode will be null so exit loop
        }
        return prevNode; // Last node of the list so it is the head
    }
    // Time Complexity: O(n)
    // Space Complexity: O(1)
}

/*
 * Recursive Solution
 * 
 * class Solution {
 * public ListNode reverseList(ListNode head) {
 * 
 * if (head == null || head.next == null){
 * return head;
 * }
 * 
 * ListNode reversedSubList = reverseList(head.next);
 * head.next.next = head; // append node to the end
 * head.next = null; // Last node
 * 
 * return reversedSubList;
 * }
 * TS: O(n)
 * SC: O(n)
 * 
 * 
 * {}
 * 
 */