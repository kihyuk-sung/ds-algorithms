class Solution:
    def getSum(self, a: int, b: int) -> int:
        MASK_12BIT = 0xFFF
        MASK_BIT = 0b1
        INT_MAX = 0x7FF

        G = a & b
        P = a ^ b

        C = 0
        result = 0
        for i in range(12):
            g = G & MASK_BIT
            p = P & MASK_BIT

            result |= (p ^ C) << i
            C = g | (p & C)

            G >>= 1
            P >>= 1

        if result > INT_MAX:
            result = ~(result ^ MASK_12BIT)

        return result
        