'''
Created on 2014.11.4

@author: xiaocunqi
'''
class Solution:
    # @param s, a string
    # @return a boolean
    def isPalindrome(self, s):
        if None == s and len(s) == 0:
            return True
        
        if " " == s:
            return True
        
        left  = 0
        right = len(s) - 1
        
        s = s.lower()
        
        while left < right:
            while left < right and self.isLetter(s[left]) == False:
                left +=1
                
            while right > left and self.isLetter(s[right]) == False:
                right -=1
                
            if s[left] != s[right]:
                break;
            else:
                left  += 1
                right -= 1
        
        if left >= right:
            return True
        else:
            return False
                
    def isLetter(self, a):
        
        if a >= 'a' and a<= 'z':
            return True
        elif a >= '0' and a <= '9':
            return True
        
        return False
    
solution = Solution()
print(solution.isPalindrome("."))