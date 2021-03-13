from typing import List
import heapq
class Solution:
    def findKthLargest(self, nums: List[int], k: int) -> int:
        heap = []
        for n in nums:
            heapq.heappush(heap, -n)
        
        for _ in range(k):
            heapq.heappop(heap)
        
        return -heapq.heappop(heap)
