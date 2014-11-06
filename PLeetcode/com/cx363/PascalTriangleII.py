'''
Created on 2014.11.5

@author: xiaocunqi
'''
class Solution:
    # @return a list of integers
    def getRow(self, rowIndex):
        start  = [1]
        result = []
        return self.reBuild(start, result, rowIndex)
    
    def reBuild(self, source, result, rowIndex):
        
        result.append(source[:])
        
        length = len(source)
        
        first  = source[0]
        second = 0
        for i in range(1, length):
            second = source[i]
            
            source[i] = first +second
            first = second
            
        source.append(1)
        
        if rowIndex == 0:
            return result
        else:
            return self.reBuild(source, result, rowIndex - 1)
        
solution = Solution()

print(solution.getRow(2))