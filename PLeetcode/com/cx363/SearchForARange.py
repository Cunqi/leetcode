'''
Created on Oct 22, 2014

@author: xiaocunqi
'''
class Solution:
    # @param A, a list of integers
    # @param target, an integer to be searched
    # @return a list of length 2, [index1, index2]
    def searchRange(self, A, target):
        result = [-1, -1]
        if len(A) == 1:
            if A[0] == target:
                return [0, 0]
            else:
                return result
        else:
            low = 0
            high = len(A) - 1
            
            self.divideAndConqure(A, target, low, high, result)
            
            return result
    
    def divideAndConqure(self, A, target, low, high, result):
        
        #because the array is sorted, so in these cases,
        #target cannot be in the range of sub-array.
        if A[high] < target or A[low] > target:
            return
        
        if low == high:
            if A[low] == target:
                if result[0] == -1 and result[1] == -1:
                    result[0] = low
                    result[1] = high
                
                if low < result[0]:
                    result[0] = low
                
                if low > result[1]:
                    result[1] = low
                
        else:
            mid = (low + high) / 2
            
            self.divideAndConqure(A, target, low, mid, result)
            self.divideAndConqure(A, target, mid+1, high, result)
            
solution = Solution()
data = [5]
print(solution.searchRange(data, 0))
            
        