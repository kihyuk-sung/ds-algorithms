class Solution:
    def getSum(self, a: int, b: int) -> int:
        MASK = 0xFFF
        INT_MAX = 0x7FF

        while b != 0:
            a, b = (a ^ b) & MASK, ((a & b) << 1) & MASK

        if a > INT_MAX:
            a = ~(a ^ MASK)
        
        return a
