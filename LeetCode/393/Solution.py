from typing import List

class Solution:
    def validUtf8(self, data: List[int]) -> bool:

        n = 0
        for d in data:
            if not n:
                if d < 0x80:
                    pass
                elif d < 0xE0:
                    n = 1
                elif d < 0xF0:
                    n = 2
                elif d < 0xF8:
                    n = 3
                else:
                    return False
            elif 0x80 <= d < 0xC0:
                n -= 1
            else:
                return False

        return not n
