import collections
from typing import List
from collections import Counter
import heapq

class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        freq = Counter(nums)
        freq_heap = []
        for key, value in freq.items():
            heapq.heappush(freq_heap, (-value, key))
        top_k = []
        for _ in range(k):
            top_k.append(heapq.heappop(freq_heap)[1])
        return top_k
