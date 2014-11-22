class Solution:
    # @return a list of lists of length 3, [[val1,val2,val3]]
    def threeSum(self, num):
        length = len(num)
        sortedNum = sorted(num)

        result = []
        for i in xrange(length - 2):

            if i > 0 and sortedNum[i-1] == sortedNum[i]:
                continue;

            start = i + 1; end = length - 1
            while start < end:
                low = sortedNum[start]
                high = sortedNum[end]

                total = sortedNum[i] + low + high

                if total == 0:
                    result.append([sortedNum[i], low, high])
                    
                    while start < end:
                        start += 1
                        end -= 1
                        
                        if sortedNum[start] != low or sortedNum[end] != high:
                            break
                elif total > 0:
                    while start < end:
                        end -= 1
                        if sortedNum[end] != high:
                            break
                else:
                    while start < end:
                        start += 1
                        if sortedNum[start] != low:
                            break
        return result

solution = Solution()
print(solution.threeSum([0, 0, 0, 0]))