'''
Created on Nov 14, 2014

@author: xiaocunqi
'''
class Solution:
    dic = {'I' : 1, 'V' : 5, 'X' : 10, 'L' : 50, 'C' : 100, 'D' : 500, 'M' : 1000}
    
    # @return an integer
    def romanToInt(self, s):
        alpha = list(s)
        
        total = 0
        part = self.dic[alpha[0]]
        
        for i in range(1, len(alpha)):
            if self.dic[alpha[i]] > self.dic[alpha[i - 1]]:
                total += self.dic[alpha[i]] - part
                part = 0
            elif self.dic[alpha[i]] < self.dic[alpha[i - 1]]:
                total += part
                part = self.dic[alpha[i]]
            else:
                part += self.dic[alpha[i]]
        
        total += part
                
        return total
    
solution = Solution()

print(solution.romanToInt('LXXXIIV'))