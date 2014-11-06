'''
Created on 2014.11.4

@author: xiaocunqi
'''
class Solution:   
    # @return a string
    def getPermutation(self, n, k):
        num = range(1, n + 1)
        
        result = self.permute(num, k)
        
        return str(result)
        
    def permute(self, num, k):
        
        if(len(num) == 1):
            return str(num)
        result = []
        self.perm(result, num, 0, len(num))
        
        return result[k - 1]
    
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

print(solution.getPermutation(3, 3))