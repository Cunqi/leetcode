'''
Created on Sep 30, 2014

@author: xiaocunqi
'''
class Solution:
    # @param A, a list of integers
    # @return an integer
    def maxSubArray(self, A):
        
        dp = [0] * len(A)
        dp[0] = (A[0])
        
        maxSum = dp[0]
        for index in range(1, len(A)):
            if dp[index-1] < 0:
                dp[index] = A[index]
            else:
                dp[index] = dp[index - 1] + A[index]
                
            if dp[index] > maxSum:
                maxSum = dp[index]
        
        return maxSum
    
solution = Solution()

print(solution.maxSubArray([-2,1,-3,4,-1,2,1,-5,4]))