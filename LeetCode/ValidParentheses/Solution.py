class Solution:
    def isValid(self, s: str) -> bool:
        stack = []

        table = {
            '}' : '{',
            ']' : '[',
            ')' : '('
        }

        for e in s:
            if e in table:
                if not stack or stack.pop() != table[e]:
                    return False
            else:
                stack.append(e)
    
        if len(stack) == 0:
            return True
        else:
            return False
            