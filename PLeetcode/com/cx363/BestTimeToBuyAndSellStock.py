'''
Created on Nov 17, 2014

@author: xiaocunqi
'''
class Solution:
    # @param prices, a list of integer
    # @return an integer
    def maxProfit(self, prices):
        
        if len(prices) <= 1:
            return 0
        
        profit = [0] * (len(prices)-1)
        
        for i in range(1, len(prices)):
            profit[i-1] = prices[i] - prices[i-1]
        
        total = 0
        tMax = profit[0]
        for i in range(0, len(profit)):
            total += profit[i]
            
            if total < 0:
                total = 0
            
            if total > tMax:
                tMax = total
        
        return tMax
    
solution = Solution()
print(solution.maxProfit([1, 2]))