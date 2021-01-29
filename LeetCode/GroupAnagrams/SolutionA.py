from typing import List
from collections import defaultdict

class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        anagrams = defaultdict(list)

        for word in strs:
            print(sorted(word))
            anagrams[''.join(sorted(word))].append(word)

        return anagrams.values()