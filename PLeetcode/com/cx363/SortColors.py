'''
Created on 2014.10.26

@author: xiaocunqi
'''
class Solution:
    # @param A a list of integers
    # @return nothing, sort in place
    def sortColors(self, A):
        if len(A) <= 1:
            pass
        elif len(A) == 2:
            if A[0] > A[1]:
                tmp = A[0]
                A[0] = A[1]
                A[1] = tmp
        else:
            red = 0
            white = 0
            
            for i in range(0, len(A)):
                if A[i] == 0:
                    red += 1
                elif A[i] == 1:
                    white += 1
            
            for i in range(0, len(A)):
                if i < red:
                    A[i] = 0
                elif i < red + white:
                    A[i] = 1
                else:
                    A[i] = 2
            
solution = Solution()
A = [0, 2, 1, 2, 0, 2, 1, 1, 2, 0]
print(A)
print("\n")

solution.sortColors(A)

print(A)