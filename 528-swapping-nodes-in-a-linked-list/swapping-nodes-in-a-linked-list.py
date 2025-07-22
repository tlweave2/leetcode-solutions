# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def swapNodes(self, head: Optional[ListNode], k: int) -> Optional[ListNode]:
        first = head
        for _ in range(k-1):
            first = first.next
        end = head
        current = first
        while current.next:
            current = current.next
            end = end.next
        first.val , end.val = end.val , first.val
        return head
        

        

         

        