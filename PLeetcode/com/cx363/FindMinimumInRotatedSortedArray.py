'''
Created on 2014.10.26.

@author: xiaocunqi
'''
class Solution:
    # @param num, a list of integer
    # @return an integer
    def findMin(self, num):
        
        if len(num) == 1:
            return num[0]
        
        if len(num) == 2:
            if num[0] > num[1]:
                return num[1]
            else:
                return num[0]
        
        #when len(num) > 3
        low = 0
        high = len(num) - 1
        
        return self.binarySearch(num, low, high)
        
    def binarySearch(self, num, low, high):
        if low >= high:
            return num[low]
        
        mid = (low + high) / 2
        
        if num[low] > num[high]:
            if num[mid] < num[low]:
                return self.binarySearch(num, low, mid)
            else:
                return self.binarySearch(num, mid + 1, high)
        else:
            return num[low]
        
        
            
solution = Solution()
data = [4, 5, 6, 7, 8, 2]

print(solution.findMin(data))