from typing import List
import sys

class Solution:
    def maxProfit(self, prices: List[int]) -> int:

        profit = 0
        min = sys.maxsize

        for n in prices:
            if n < min:
                min = n
            if n - min > profit:
                profit = n - min

        return profit
        