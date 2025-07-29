class Solution:
    def arrangeCoins(self, n: int) -> int:
        row = 1
        while n >= row:
            n -= row  # Use 'row' coins for this row
            row += 1  # Move to next row
        return row - 1  # Last complete row
