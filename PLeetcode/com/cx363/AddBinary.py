'''
Created on Oct 20, 2014

@author: xiaocunqi
'''
class Solution:
    # @param a, a string
    # @param b, a string
    # @return a string
    def addBinary(self, a, b):
        
        if a == None or len(a) == 0:
            return b
        if b == None or len(b) == 0:
            return a
        
        la = list(a)
        la.reverse()
        lb = list(b)
        lb.reverse()
        
        result = list()
        
        i = j = 0
        carry = 0;
        while i < len(la) and j < len(lb):
            digitSum = int(la[i]) + int(lb[j]) + carry
            
            carry = digitSum / 2
            
            digitSum %= 2
            
            result.append(digitSum)
            
            i += 1
            j += 1
        
        if i < len(la):
            while i < len(la):
                digitSum = int(la[i]) + carry
                
                carry = digitSum / 2
                digitSum %= 2
                result.append(digitSum)
                i += 1
        
        if j < len(lb):
            while j < len(lb):
                digitSum = int(lb[j]) + carry
                
                carry = digitSum / 2
                digitSum %= 2
                result.append(digitSum)
                j += 1
                
        if carry != 0:
            result.append(carry)
            
        result.reverse()
        
        return ''.join(str(e) for e in result)

solution = Solution()   
print(solution.addBinary("1", "111"))