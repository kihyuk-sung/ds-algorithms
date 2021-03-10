# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
class Solution:
    def rangeSumBST(self, root: TreeNode, low: int, high: int) -> int:
        self.sum = 0

        def recursive(node: TreeNode):
            if not node:
                return
            
            if node.val < low:
                recursive(node.right)
            elif low <= node.val <= high:
                self.sum += node.val
                recursive(node.left)
                recursive(node.right)
            else:
                recursive(node.left)
            
        recursive(root)
        return self.sum
