class Solution:
    # @return an integer
    def maxArea(self, height):

        if len(height) <= 1:
            return 0

        low = 0
        high = len(height) - 1
        maxArea = (high - low) * min(height[low], height[high])
        while low < high:
            if height[low] <= height[high]:
                low += 1
            else:
                high -= 1

            area = (high - low) * min(height[low], height[high])

            if area > maxArea:
                maxArea = area

        return maxArea

solution = Solution()
print(solution.maxArea([1, 2, 4, 3]))