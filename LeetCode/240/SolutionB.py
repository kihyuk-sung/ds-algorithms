from typing import List

class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        row, col = 0, len(matrix[0]) - 1

        while row < len(matrix) and col > -1:
            val = matrix[row][col]
            if target == val:
                return True
            elif target > val:
                row += 1
            else:
                col -= 1
        
        return False
