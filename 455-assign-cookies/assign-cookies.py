class Solution:
    def findContentChildren(self, g: List[int], s: List[int]) -> int:
        g.sort()
        s.sort()
        child = 0
        cookie =0
        content =0
        while child < len(g) and cookie < len(s):
            if s[cookie] >= g[child]:
                child += 1
                content += 1
            cookie +=1
        return content
