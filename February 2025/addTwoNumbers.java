
class ListNode {
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

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode resultHead = new ListNode();  // To hold the result of the addition
        ListNode current = resultHead;  // To keep track of the current node in the result list
        int sum = 0, carryOver = 0;  // sum holds the total value, carryOver stores any carry during addition

        while (l1 != null || l2 != null || carryOver != 0) {
            sum = carryOver;  // Start with the carry from the previous step

            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;  // Move to the next node in l1
            }
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;  // Move to the next node in l2
            }

            int digit = sum % 10;  // The single digit to store in the result list
            carryOver = sum / 10;  // The carry to propagate to the next addition

            current.next = new ListNode(digit);  // Create a new node with the digit
            current = current.next;  // Move to the newly added node
        }

        return resultHead.next;  // Return the result list, skipping the dummy head
    }
}

/*
Complexity
Time complexity: O(n)
n is number of nodes in longer list l1 or l2.

Space complexity:O(n) or O(1)
If we count new list we create, that is O(n). If we don't count, that is O(1)
*/