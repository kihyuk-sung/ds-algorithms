from typing import List
from collections import Counter
import heapq

class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        counter = Counter(nums)
        result = []
        heap = []
        for key, v in counter.items():
            heapq.heappush(heap, (-v, key))
        
        for i in range(k):
            result.append(heapq.heappop(heap)[1])
        return result
