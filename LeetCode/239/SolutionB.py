from typing import List
from collections import deque

class Solution:
    def maxSlidingWindow(self, nums: List[int], k: int) -> List[int]:
        MIN = -100000
        result = []
        window = deque()
        current_max = MIN
        for i, v in enumerate(nums):
            window.append(v)
            if i < k - 1:
                continue
            if current_max == MIN:
                current_max = max(window)
            elif v > current_max:
                current_max = v
            result.append(current_max)

            if current_max == window.popleft():
                current_max = MIN
        return result
