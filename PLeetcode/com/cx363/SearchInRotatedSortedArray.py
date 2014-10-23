'''
Created on Oct 23, 2014

@author: xiaocunqi
'''
class Solution:
    # @param A, a list of integers
    # @param target, an integer to be searched
    # @return an integer
    def search(self, A, target):
        
        if len(A) == 1:
            if A[0] == target:
                return 0
            else:
                return -1
        
        low = 0
        high = len(A) - 1
        #STEP1 find the rotation point of array
        rPoint = -1
        
        for i in range(1, len(A)):
            if A[i-1] > A[i]:
                rPoint = i
                break
        
        #STEP2 using rPoint as mid if it isn't equal to -1
        if rPoint == -1:
            mid = (low + high) / 2
        else:
            mid = rPoint
        #STEP 3 binary search in both two sections
        
        if A[mid] == target:
            return mid
        
        result = self.binarySearch(A, target, low, mid - 1)
        
        if result == -1:
            result = self.binarySearch(A, target, mid + 1, high)
        
        return result
    
    def binarySearch(self, A, target, low, high):
        
        if low <= high:
            if low == high:
                if A[low] == target:
                    return low
                else:
                    return -1
            
            mid = (low + high) / 2 + 1
            
            if A[mid] == target:
                return mid
            elif A[mid] > target:
                return self.binarySearch(A, target, low, mid-1)
            else:
                return self.binarySearch(A, target, mid + 1, high)
        
        return -1
                
solution = Solution()
data = [1, 3]
print(solution.search(data, 1))