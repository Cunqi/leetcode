class Solution:
    # @param triangle, a list of lists of integers
    # @return an integer
    def minimumTotal(self, triangle):
        level = len(triangle)

        memory = triangle[level - 1][:]

        level -= 2
        while level >= 0:
            for i in xrange(0, len(triangle[level])):
                memory[i] = min(memory[i] + triangle[level][i], memory[i+1] + triangle[level][i])
            level -= 1

        return memory[0]

solution = Solution()
data = [0] * 4
data[0] = [2]
data[1] = [3, 4]
data[2] = [6, 5, 7]
data[3] = [4, 1, 8, 3]
print(solution.minimumTotal(data))