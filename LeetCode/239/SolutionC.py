from typing import List
from collections import deque

class Solution:
    def maxSlidingWindow(self, nums: List[int], k: int) -> List[int]:
        result = []
        window = deque()
        for i in range(len(nums)):
            if window and window[0] == i - k:
                window.popleft()

            val = nums[i]
            while window and nums[window[-1]] <= val:
                window.pop()
            
            window.append(i)

            if i + 1 >= k:
                result.append(nums[window[0]])
        return result
