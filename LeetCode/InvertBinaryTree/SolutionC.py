from collections import deque

class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
class Solution:
    def invertTree(self, root: TreeNode) -> TreeNode:
      stack = deque([root])

      while stack:
        node = stack.pop()
        if not node:
          continue
        node.left, node.right = node.right, node.left
        stack.append(node.left)
        stack.append(node.right)
      
      return root
