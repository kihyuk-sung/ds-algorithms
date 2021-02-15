from collections import Counter

class Solution:
    def numJewelsInStones(self, jewels: str, stones: str) -> int:
        freqs = Counter(stones)
        count = 0

        for char in jewels:
            count += freqs[char]

        return count
