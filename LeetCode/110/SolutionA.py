# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
class Solution:
    def isBalanced(self, root: TreeNode) -> bool:
        def balance_check(node: TreeNode):
            if not node:
                return 0
            left_height  = balance_check(node.left)
            right_height = balance_check(node.right)

            if left_height == -1 or right_height == -1 or abs(left_height - right_height) > 1:
                return -1
            
            return max(left_height, right_height) + 1

        return balance_check(root) != -1
