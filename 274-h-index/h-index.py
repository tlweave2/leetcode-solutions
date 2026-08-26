class Solution:
    def hIndex(self, citations: List[int]) -> int:
        n = len(citations)
        best = 0

        for h in range(n + 1):
            count = 0
            for c in citations:
                if c >= h:
                    count += 1
            if count >= h:
                best = h

        return best