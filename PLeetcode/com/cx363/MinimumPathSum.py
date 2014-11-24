class Solution:
    # @param grid, a list of lists of integers
    # @return an integer
    def minPathSum(self, grid):
        rowSize = len(grid)
        colSize = len(grid[0])

        #accumulator first row
        for row in range(1, rowSize):
            grid[row][0] = grid[row][0] + grid[row - 1][0]

        #accumulator first col
        for col in range(1, colSize):
            grid[0][col] = grid[0][col] + grid[0][col - 1]

        for row in range(1, rowSize):
            for col in range(1, colSize):
                grid[row][col] = grid[row][col] + min(grid[row][col-1], 
                    grid[row-1][col])

        return grid[rowSize-1][colSize-1]

solution = Solution()
data = [[1, 3, 1], [2, 5, 9], [4, 8, 9]]
print(solution.minPathSum(data))