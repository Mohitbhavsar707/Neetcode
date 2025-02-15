public class PostOrderTraversalCheck {
    public static boolean verifyPostOrder(int[] sequence) {
        if (sequence == null || sequence.length == 0) return false;
        return verify(sequence, 0, sequence.length - 1);
    }

    private static boolean verify(int[] sequence, int start, int end) {
        if (start >= end) return true; // Base case: single node or empty tree

        int root = sequence[end];

        // Find the division point between left and right subtrees
        int i = start;
        while (i < end && sequence[i] < root) {
            i++;
        }

        // Check if right subtree contains invalid elements
        int j = i;
        while (j < end) {
            if (sequence[j] < root) return false;
            j++;
        }

        // Recursively verify left and right subtrees
        return verify(sequence, start, i - 1) && verify(sequence, i, end - 1);
    }

    // Test the function
    public static void main(String[] args) {
        int[] seq1 = {5, 7, 6, 9, 11, 10, 8};
        int[] seq2 = {7, 4, 6, 5};

        System.out.println(verifyPostOrder(seq1)); // Output: true
        System.out.println(verifyPostOrder(seq2)); // Output: false
    }
}
