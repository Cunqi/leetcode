'''
Created on Oct 20, 2014

@author: xiaocunqi
'''
class Solution:
    EPS = 0.00000001
    # @param x, an integer
    # @return an integer
    def sqrt(self, x):
        if x < 2:
            return x
        else:
            result = self.calc(x * 1.0, x/2.0)
            return result
        
    def calc(self, x, p):
        q = (p + x / p) / 2
        if abs(q - p) < self.EPS:
            print(q)
            result = int(q)
            if result * result > x:
                result -= 1
            return result
        else:
            return self.calc(x, q)
            
solution = Solution()
print(solution.sqrt(5))