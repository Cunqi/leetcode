'''
Created on 2014.10.30

@author: xiaocunqi
'''
class Solution:
    # @param height, a list of integer
    # @return an integer
    def largestRectangleArea(self, height):
        
        if len(height) == 1:
            return height[0]
        
        curMinH = height[0]
        maxArea = height[0]
        count = 1
        
        components = []
        components.append(height[0])
        
        for i in range(1, len(height)):
            curMinH = min(curMinH, height[i])
            
            if (count + 1) * curMinH >= maxArea:
                count += 1
                maxArea = count * curMinH
            
                
                
            else:
                count = 1
                maxArea = height[i]
                
        
            