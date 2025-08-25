class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        col=0
        row=0
        while row < len(matrix):
            first = matrix[row][0]
            second = matrix[row][-1]
            if target >= first and target <= second:
                for val in matrix[row]:
                    if val == target:
                        return True



            
               
            row +=1 

        return False