import typing


from typing import DefaultDict, List
from collections import defaultdict
import re

class Solution:
    def mostCommonWord(self, paragraph: str, banned: List[str]) -> str:
        words = re.sub('[^\w]', ' ', paragraph).lower().split()
        counts = defaultdict(int)
        for word in words:
            if word not in banned:
                counts[word] += 1
        
        return max(counts, key=counts.get)
