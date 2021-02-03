from typing import List
import sys

class Solution:
    def maxProfit(self, prices: List[int]) -> int:

        profit = 0
        min_price = sys.maxsize

        for n in prices:
            min_price = min(min_price, n)
            profit = max(profit, n - min_price)

        return profit
        