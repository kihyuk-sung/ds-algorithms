from typing import List
from collections import defaultdict

class Solution:
    def arrayPairSum(self, nums: List[int]) -> int:
        arr = defaultdict(int)
        lim = 10000

        for n in nums:
            arr[n + lim] += 1

        d, sum = 0, 0

        for i in range(-10000, 10001, 1):
            sum += (arr[i + lim] + 1 - d) // 2 * i
            d = (2 + arr[i + lim] - d) % 2
        
        return sum
