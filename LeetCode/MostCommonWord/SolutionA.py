import typing


from typing import DefaultDict, List
from collections import defaultdict
import re

class Solution:
    def mostCommonWord(self, paragraph: str, banned: List[str]) -> str:
        words = [word for word in re.sub('[^\w]', ' ', paragraph)
            .lower().split()
                if word not in banned]
        counts = defaultdict(int)
        for word in words:
            counts[word] += 1
        
        return max(counts, key=counts.get)
