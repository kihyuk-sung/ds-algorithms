from typing import List
from collections import Counter
from re import sub

class Solution:
    def mostCommonWord(self, paragraph: str, banned: List[str]) -> str:
        words = [word for word in sub('[^\w]', ' ', paragraph)
            .lower().split()
                if word not in banned]
        
        counts = Counter(words)
        
        return counts.most_common(1)[0][0]
