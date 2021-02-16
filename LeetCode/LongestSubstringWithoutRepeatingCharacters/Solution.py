from collections import defaultdict

class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:        
        if not s:
            return 0
        
        lengthList = []
        count = 0
        for i in range(len(s)):
            count = 0
            defdic = defaultdict(bool)
            for j in range(i, len(s)):
                if not defdic[s[j]]:
                    defdic[s[j]] = True
                    count += 1
                else:
                    break
            lengthList.append(count)

        return max(lengthList)
