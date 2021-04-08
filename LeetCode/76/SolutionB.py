from collections import Counter

class Solution:
    def minWindow(self, s: str, t: str) -> str:
        t_count = Counter(t)
        current_count = Counter()

        start = -1
        end = 1000000
        left = 0
        for right, char in enumerate(s, 1):
            current_count[char] += 1
            while current_count & t_count == t_count:
                if right - left < end - start:
                    start, end = left, right
                current_count[s[left]] -= 1
                left += 1
            
        return s[start:end] if end - start <= len(s) else ''
