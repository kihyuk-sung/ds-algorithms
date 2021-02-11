from typing import List

class Solution:
    def dailyTemperatures(self, T: List[int]) -> List[int]:
        stack = []
        result = [None] * len(T)
        for i in range(len(T)):
            while stack and T[stack[-1]] < T[i]:
                idx = stack.pop()
                result[idx] = i - idx

            stack.append(i)

        while stack:
            result[stack.pop()] = 0

        return result
