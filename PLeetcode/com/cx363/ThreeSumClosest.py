class Solution:
    # @return an integer
    def threeSumClosest(self, num, target):
        length = len(num)
        sortedNum = sorted(num)

        gMin = None
        result = None

        for i in xrange(length - 2):

            if i > 0 and sortedNum[i-1] == sortedNum[i]:
                continue;

            start = i + 1; end = length - 1
            while start < end:
                low = sortedNum[start]
                high = sortedNum[end]

                tSum = sortedNum[i] + low + high
                total = tSum - target

                if total == 0:
                    return target
                elif total > 0:
                    if gMin == None:
                        gMin = abs(total)
                        result = tSum
                    else:
                        gMin = gMin if gMin < abs(total) else abs(total)
                        result = result if gMin < abs(total) else tSum

                    while start < end:
                        end -= 1
                        if sortedNum[end] != high:
                            break
                else:
                    if gMin == None:
                        gMin = abs(total)
                        result = tSum
                    else:
                        gMin = gMin if gMin < abs(total) else abs(total)
                        result = result if gMin < abs(total) else tSum

                    while start < end:
                        start += 1
                        if sortedNum[start] != low:
                            break
        return result
solution = Solution()
print(solution.threeSumClosest([-1, 2, 1, -4], 1))