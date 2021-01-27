from re import sub

class Solution:
    def isPalindrome(self, s: str) -> bool:
        s = s.lower()
        s = sub('[^a-z0-9]', '', s)

        return s == s[::-1]