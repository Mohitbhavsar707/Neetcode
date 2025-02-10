class Solution {
    public int numIslands(char[][] grid) {
        int count = 0;
        int row = grid.length;
        int col = grid[0].length;

        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(grid[i][j] == '1'){
                    count++; // Found an island
                    depthFirstSearch(grid, i,j, row, col); //repeat the process of checking/finding 
                }
            }
        }
        return count;
    }

    public void depthFirstSearch(char[][] grid, int i, int j, int row, int col){
        // Edge case index out of bounds
        if (i < 0 || i >= row || j < 0 || j >= col || grid[i][j] == '0'){
            return;
        }
        grid[i][j] = '0'; // change counted value to a 0 so we dont double count it

        // Going up, down, left, right search (no particular order)
        depthFirstSearch(grid,i + 1, j, row, col);
        depthFirstSearch(grid,i - 1, j, row, col);
        depthFirstSearch(grid,i , j + 1, row, col);
        depthFirstSearch(grid,i , j - 1, row, col);
    }
}