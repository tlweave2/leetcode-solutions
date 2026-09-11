class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
        count = Counter(s)
        for i in t:
            if i not in count:
                return False
            if  count[i] > 1:
                count[i] -= 1
            else:
                del count[i]
        return not count
