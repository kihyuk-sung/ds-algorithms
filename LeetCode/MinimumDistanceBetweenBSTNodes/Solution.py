import sys
# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
class Solution:
    def minDiffInBST(self, root: TreeNode) -> int:
        
        self.prev = -sys.maxsize
        self.now = -sys.maxsize
        self.min = sys.maxsize
        def inorder(node: TreeNode):
            if not node:
                return
            inorder(node.left)
            self.prev, self.now = self.now, node.val
            self.min = min(self.min, self.now - self.prev)
            inorder(node.right)

        inorder(root)

        return self.min

            