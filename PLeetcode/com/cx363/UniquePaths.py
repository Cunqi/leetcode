class Solution:
    # @return an integer
    def uniquePaths(self, m, n):
        dp = [[0 for col in range(n)] for row in range(m)]

        #set all elements in first row to be 1
        for row in range(m):
            dp[row][0] = 1
        #set all elements in first col to be 1
        for col in range(n):
            dp[0][col] = 1

        for  row in range(1, m):
            for col in range(1, n):
                dp[row][col] = dp[row - 1][col] + dp[row][col - 1]

        return dp[m-1][n-1]

solution = Solution()
print(solution.uniquePaths(2, 2))