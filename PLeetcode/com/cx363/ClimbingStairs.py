'''
Created on Nov 14, 2014

@author: xiaocunqi
'''
class Solution:
    # @param n, an integer
    # @return an integer
    def climbStairs(self, n):
        if n <= 1:
            return n
            
        stairs = [0] * (n+1)
        
        stairs[0] = 1
        stairs[1] = 1
        
        for i in range(2, n+1):
            stairs[i] = stairs[i-1] + stairs[i-2]
            
        
        return stairs[n]