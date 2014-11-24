class Solution:
    # @param obstacleGrid, a list of lists of integers
    # @return an integer
    def uniquePathsWithObstacles(self, obstacleGrid):
        rowSize = len(obstacleGrid)
        colSize = len(obstacleGrid[0])

        dp = [[0 for col in range(colSize)] for row in range(rowSize)]

        #set all elements in first row to be 1
        noWay = False
        for row in range(rowSize):
            if noWay:
                break

            if obstacleGrid[row][0] == 1:
                noWay = True
            else:
                dp[row][0] = 1

        #set all elements in first col to be 1
        noWay = False
        for col in range(colSize):
            if noWay:
                break

            if obstacleGrid[0][col] == 1:
                noWay = True
            else:
                dp[0][col] = 1

        for row in range(1, rowSize):
            for col in range(1, colSize):
                if obstacleGrid[row][col] == 1:
                    continue

                dp[row][col] = dp[row][col - 1] + dp[row - 1][col]

        return dp[rowSize - 1][colSize - 1]

solution = Solution()
data = [[0, 0, 0], [0, 1, 0], [0, 0, 0]]
print(solution.uniquePathsWithObstacles(data))