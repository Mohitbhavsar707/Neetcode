import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        // Dictionary created to hold combinations of words that can be formed
        // from any given word by changing one letter at a time
        Map<String, List<String>> allComboDict = new HashMap<>();

        int L = beginWord.length(); // Define L to use later for substring indexing

        // Preprocess word list to create the allComboDict
        wordList.forEach(word -> {
            for (int i = 0; i < L; i++) {
                // Key is the generic word with one letter replaced by '*'
                // Value is the list of words that match this intermediate pattern
                String newWord = word.substring(0, i) + "*" + word.substring(i + 1, L);

                // Retrieve the list of words that match this transformation pattern, or create a new empty list if not found
                List<String> transformations = allComboDict.getOrDefault(newWord, new ArrayList<>());
                transformations.add(word); // Add the current word to the list of transformations
                allComboDict.put(newWord, transformations); // Update the dictionary with the new transformation list
            }
        });

        // Queue for BFS
        // Initialize a queue to perform BFS (Breadth-First Search)
        Queue<Pair<String, Integer>> Q = new LinkedList<>();
        // Add the starting word to the queue with level 1
        Q.add(new Pair<>(beginWord, 1));

        // HashMap to track visited words to prevent cycles
        Map<String, Boolean> visited = new HashMap<>();
        visited.put(beginWord, true);  // Mark the beginning word as visited to avoid reprocessing

        // BFS traversal
        while (!Q.isEmpty()) {
            // Remove the front node from the queue
            Pair<String, Integer> node = Q.remove();
            String word = node.getKey();
            int level = node.getValue();

            for (int i = 0; i < L; i++) {
                // Create an intermediate word pattern by replacing the i-th character with '*'
                String newWord = word.substring(0, i) + "*" + word.substring(i + 1, L);

                // Retrieve all words that match this intermediate state
                for (String adjacentWord : allComboDict.getOrDefault(newWord, new ArrayList<>())) {
                    // If we find the endWord, return the transformation count
                    if (adjacentWord.equals(endWord)) {
                        return level + 1;
                    }

                    // If the adjacent word has not been visited, add it to the queue and mark it as visited
                    if (!visited.containsKey(adjacentWord)) {
                        visited.put(adjacentWord, true);
                        Q.add(new Pair<>(adjacentWord, level + 1)); // Fixed syntax (missing <>)
                    }
                }
            }
        }

        return 0; // If no transformation sequence is found, return 0
    }
}
