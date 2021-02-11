from typing import List

class Solution:
    def dailyTemperatures(self, T: List[int]) -> List[int]:
        stack = []
        result = [0] * len(T)
        for i, cur in enumerate(T):
            while stack and T[stack[-1]] < cur:
                idx = stack.pop()
                result[idx] = i - idx

            stack.append(i)

        return result
