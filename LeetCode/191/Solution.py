class Solution:
    def hammingWeight(self, n: int) -> int:
        MASK = 0b1
        result = 0
        for _ in range(32):
            if n & MASK == 1:
                result += 1
            n >>= 1
        return result 
