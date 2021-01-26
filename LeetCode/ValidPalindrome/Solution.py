class Solution:
    def isPalindrome(self, s: str) -> bool:
        strs = []
        for char in s:
            if char.isalnum():
                strs.append(char.lower())
        
        for i in range(len(strs) // 2):
            if strs[i] != strs[len(strs) - 1 - i]:
                return False
        return True
