'''
Created on Nov 14, 2014

@author: xiaocunqi
'''
class Solution:
    # @param prices, a list of integer
    # @return an integer
    def maxProfit(self, prices):
        profit = []
        
        for i in range(1, len(prices)):
            profit.append(prices[i] - prices[i - 1])
        
        total = 0;
        
        for i in range(0, len(profit)):
            if profit[i] > 0:
                total += profit[i]
        
        return total