'''
Created on Oct 9, 2014

@author: xiaocunqi
'''
class Solution:
    # @return a boolean
    def isPalindrome(self, x):
        divisor = 1
        
        if x < 0:
            return False
        
        while x / divisor >= 10:
            divisor *= 10
            
        while divisor >= 10:
            if x / divisor != x % 10:
                return False
            x = x % divisor / 10;
            divisor /=100
        return True

solution = Solution()

print(solution.isPalindrome(1234566754321))