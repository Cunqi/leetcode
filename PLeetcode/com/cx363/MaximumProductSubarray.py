'''
Created on 2014.11.6

@author: xiaocunqi
'''
class Solution:
    # @param A, a list of integers
    # @return an integer
    def maxProduct(self, A):
        length = len(A)

        if length == 1:
            return A[0]
        
        Max = A[0]
        Min = A[0]
        maxProduct = A[0]
        
        for i in range(1, length):
            Max = Max * A[i]
            Min = Min * A[i]
            
            Max = max(max(Max, Min), A[i])
            Min = min(min(Max, Min), A[i])
            
            maxProduct = max(Max, maxProduct)
            
        return maxProduct
    
solution = Solution()
print(solution.maxProduct([-1, -2, -9, -6]))