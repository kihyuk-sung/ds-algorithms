from typing import List
import heapq
class Solution:
    def findKthLargest(self, nums: List[int], k: int) -> int:
        heapq.heapify(nums)
        for _ in range(len(nums) - (k - 1)):
            heapq.heappop(nums)
        
        return heapq.heappop(nums)
