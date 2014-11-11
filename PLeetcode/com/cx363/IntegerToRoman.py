'''
Created on 2014.11.11

@author: xiaocunqi
'''
class Solution:
    dic = {1 : 'I', 5 : 'V', 10 : 'X', 50 : 'L', 100 : 'C', 500 : 'D', 1000 : 'M'}
    # @return a string
    def intToRoman(self, num):
        numStr = str(num)
        length = len(numStr)
        
        numList = [int(i) for i in numStr]
        
        currentLevel = ""
        
        result = []
        level = length - 1
        
        for digit in numList:
            currentLevel = int(pow(10, level))
            self.addRoman(digit, result, currentLevel)
            
            level -= 1
            
        return "".join(result)

    def addRoman(self, digit, result, currentLevel):
        symbol = self.dic[currentLevel]
        
        if digit < 4:
            for i in range(0, digit):
                result.append(symbol)
        if digit == 4:
            result.append(symbol)
            result.append(self.dic[5 * currentLevel])
            
        if digit == 5:
            result.append(self.dic[5 * currentLevel])
            
        if digit > 5 and digit < 9:
            result.append(self.dic[5 * currentLevel])
            for i in range(0, digit - 5):
                result.append(symbol)
            
        if digit == 9:
            result.append(symbol)
            result.append(self.dic[10 * currentLevel])
            
solution = Solution()
print(solution.intToRoman(3999))