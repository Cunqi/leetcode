'''
Created on Oct 9, 2014

@author: xiaocunqi
'''
class Solution:
    # @return a tuple, (index1, index2)
    def twoSum(self, num, target):
        length = len(num)
        
        map = {}
        
        for index in range(0, length):
            map[num[index]] = index
        
        for index in range(0, length):
            search = target - num[index]
            
            result = map.get(search, None)
            
            if result != None and result != index:
                return (index + 1, map[search] + 1)

solution = Solution()

print(solution.twoSum([1, 2, 11, 15], 3))
            