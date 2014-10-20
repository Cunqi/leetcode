'''
Created on Oct 7, 2014

@author: xiaocunqi
'''
class Solution:
    # @param num, a list of integer
    # @return a list of lists of integers
    def permute(self, num):
        
        if(len(num) == 1):
            return [num]
        result = []
        self.perm(result, num, 0, len(num))
        return result
    
    # @param a, a number waiting for swiping
    # @param b, a number waiting for swiping
    def swip(self, current, a, b):
        tmp = current[a]
        current[a] = current[b]
        current[b] = tmp
        
    def canSwip(self, current, a, b):
        for i in range(a, b):
            if current[i] == current[b]:
                return False
        return True
        
    def perm(self, result, current, head, tail):

        if head == tail:
            result.append(current[:])
        else:
            for i in range(head, tail):
                if(self.canSwip(current, head, i)):
                    self.swip(current, head, i)
                    self.perm(result, current, head + 1, tail)
                    self.swip(current, head, i)
    
solution = Solution()

print(solution.permute([2, 2, 2]))                
    