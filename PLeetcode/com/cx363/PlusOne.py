'''
Created on Oct 19, 2014

@author: xiaocunqi
'''
class Solution:
    # @param digits, a list of integer digits
    # @return a list of integer digits
    def plusOne(self, digits):
        
        carry = (digits[len(digits) - 1] + 1) / 10
        
        digits[len(digits) - 1] = (digits[len(digits) - 1] + 1) % 10
        
        if carry == 0:
            return digits
        
        for i in range(len(digits) - 2, -1, -1):
            sum = digits[i] + carry
            if sum < 10:
                digits[i] = sum
                return digits
            else:
                digits[i] = sum % 10
                carry = sum / 10
                
        if carry == 1:
            digits.insert(0, 1)
        
        return digits
    
solution = Solution()

num = [0]
print(solution.plusOne(num));
            