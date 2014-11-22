'''
Created on Nov 14, 2014

@author: xiaocunqi
'''
class Solution:
    # @return a list of integers
    def grayCode(self, n):
        if n == 0:
            return [0]
        tmp = self.grayCode(n-1)
        
        addNumber = 1 << (n-1)
        
        result = tmp[:]
        
        for i in range(len(tmp)-1, -1, -1):
            result.append(addNumber + tmp[i])
            
        return result
        
solution = Solution()
print(solution.grayCode(3))