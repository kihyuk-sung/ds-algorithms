class Solution:
    def isPalindrome(self, s: str) -> bool:
        strs: Deque = collections.deque()

        for char in s:
            if char.isalnum():
                strs.append(char.lower())
        
        for i in range(len(strs) // 2):
            if strs.popleft() != strs.pop():
                return False
        return True
