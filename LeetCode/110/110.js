/**
 * Definition for a binary tree node.
 * function TreeNode(val, left, right) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.left = (left===undefined ? null : left)
 *     this.right = (right===undefined ? null : right)
 * }
 */

function TreeNode(val, left, right) {
  this.val = (val === undefined ? 0 : val);
  this.left = (left === undefined ? null : left);
  this.right = (right === undefined ? null : right);
}
/**
 * @param {TreeNode} root
 * @return {boolean}
 */
var isBalanced = function (root) {
  const height = (node) => {
    if (node === null) {
      return 0;
    }
    const leftHeight = height(node.left);
    const rightHeight = height(node.right);

    if (leftHeight === undefined || rightHeight === undefined) {
      return undefined;
    }

    const diff = Math.abs(leftHeight - rightHeight);

    if (diff > 1) {
      return undefined;
    }

    return Math.max(leftHeight, rightHeight) + 1;
  };

  if (!root) {
    return true;
  }

  return height(root) !== undefined;
};
