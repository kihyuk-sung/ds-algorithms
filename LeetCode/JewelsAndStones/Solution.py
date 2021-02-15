from collections import defaultdict

class Solution:
    def numJewelsInStones(self, jewels: str, stones: str) -> int:
        stone_count = defaultdict(int)

        for e in stones:
            stone_count[e] += 1
        
        result = 0

        for e in jewels:
            result += stone_count[e]

        return result
