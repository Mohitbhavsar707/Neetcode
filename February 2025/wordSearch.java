class Solution {

    private char[][] board;  // The board where we search for the word.
    private int rows;        // Number of rows in the board.
    private int cols;        // Number of columns in the board.
    
    public boolean exist(char[][] board, String word) {
        this.board = board;        // Assign the input board to the instance variable.
        this.rows = board.length;  // Get the number of rows in the board.
        this.cols = board[0].length;  // Get the number of columns in the first row of the board.

        // Iterate through each cell in the board to find the starting point.
        for(int row = 0; row < this.rows; ++row) {  // Loop through rows.
            for(int col = 0; col < this.cols; ++col) {  // Loop through columns.
                // If we find a matching start letter and can find the word from here, return true.
                if(this.backTrack(row, col, word, 0)) {
                    return true;
                }
            }
        }
        
        return false;  // If no starting point for the word is found, return false.
    }

    public boolean backTrack(int row, int col, String word, int index) {
        // If the index reaches the length of the word, we have found the word.
        if(index >= word.length()) {
            return true;
        }

        // Check the boundaries and if the current cell matches the character at the current index.
        if(
            row < 0 ||  // Check if the row is out of bounds.
            row == this.rows ||  // Check if the row is beyond the last row.
            col < 0 ||  // Check if the column is out of bounds.
            col == this.cols ||  // Check if the column is beyond the last column.
            this.board[row][col] != word.charAt(index)  // Check if the current cell matches the word character.
        ){
            return false;  // If any condition is violated, return false.
        }

        // Mark the current cell as visited by temporarily changing it.
        boolean pathFound = false;  // Variable to track if we can find the path.
        this.board[row][col] = '#';  // Mark the cell to avoid revisiting.

        // Directions for moving to adjacent cells (right, down, left, up).
        int[] rowOffsets = { 0, 1, 0, -1 };  // Row direction offsets (right, down, left, up).
        int[] colOffsets = { 1, 0, -1, 0 };  // Column direction offsets (right, down, left, up).
        
        // Try all four directions.
        for(int i = 0; i < 4; i++) {  // Loop through all four directions.
            // Recursively try moving in the current direction (right, down, left, up).
            pathFound = this.backTrack(
                    row + rowOffsets[i],  // Move in the current direction (row offset).
                    col + colOffsets[i],  // Move in the current direction (column offset).
                    word,
                    index + 1  // Move to the next character in the word.
            );
            // If a valid path is found, break out of the loop.
            if(pathFound) {
                break;
            }
        }

        // Restore the cell to its original value.
        this.board[row][col] = word.charAt(index);  // Unmark the cell after exploration.

        // Return whether the word can be formed starting from this position.
        return pathFound;
    }
}
