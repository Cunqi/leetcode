'''
Created on 2014.10.27

@author: xiaocunqi
'''
class Solution:
    # @param    A       a list of integers
    # @param    elem    an integer, value need to be removed
    # @return an integer
    def removeElement(self, A, elem):
        if A == None or len(A) < 1:
            return 0
        
        left  = 0
        right = len(A) - 1
        
        while left <= right:
            if A[left] == elem:
                if A[right] == elem:
                    left -= 1
                else:
                    self.swipe(A, left, right)
                
                right -= 1
            
            left += 1
        
        return left
            
            
    def swipe(self, A, source, target):
        tmp = A[source]
        A[source] = A[target]
        A[target] = tmp
        
solution = Solution()

data = [2]

print(solution.removeElement(data, 3))