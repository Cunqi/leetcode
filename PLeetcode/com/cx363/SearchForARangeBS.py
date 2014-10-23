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
            
            while low <= high:
                mid = (low + high) / 2
                
                if A[mid] < target:
                    low = mid + 1
                else:
                    high = mid - 1
            
            left = low
            
            low = 0
            high = len(A) - 1
            
            while low <= high:
                mid = (low + high) / 2
                
                if A[mid] <= target:
                    low = mid + 1
                else:
                    high = mid - 1
            
            right = high
            
            if left <= right:
                result[0] = left
                result[1] = right
            
            return result
        
solution = Solution()
data = [2, 2]
print(solution.searchRange(data, 1))