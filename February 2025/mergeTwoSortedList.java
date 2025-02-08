
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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

//  When you reach the end of one list, return the rest of the other list
        if(list1 == null){
            return list2;
        }

        if(list2 == null){
            return list1;
        }

        // Compare the heads of l1 and l2

        ListNode head; // the node to return
         if(list1.val < list2.val){
            head = list1;
            list1 = list1.next; // move to next node

         } else {
            head = list2; 
            list2 = list2.next;
         }

        head.next = mergeTwoLists(list1,list2); // returns two list merged in ascending order
        return head;

    }
}

//TS: O(m+n) num nodes first list + num nodes second list since we go through all
//SC: O(m+n) calling recursive function for every nodes