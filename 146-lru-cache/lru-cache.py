class Node:
    def __init__(self, key, val):
        self.key = key
        self.value = val
        self.prev = self.next = None

class LRUCache:
    def __init__(self, capacity: int):
        self.cap = capacity
        self.cache = {}  # key -> Node mapping
        
        # Create dummy head and tail nodes
        self.left = Node(0, 0)   # dummy head (oldest/left side)
        self.right = Node(0, 0)  # dummy tail (newest/right side)
        
        # Fix: Connect left and right properly
        self.left.next = self.right
        self.right.prev = self.left  # This was wrong in your code

    def get(self, key: int) -> int:
        if key in self.cache:
            node = self.cache[key]  # Get the actual node, not just the value
            # Move this node to the right (mark as most recently used)
            self.remove(node)
            self.insert(node)
            return node.value
        return -1

    def put(self, key: int, value: int) -> None:
        if key in self.cache:
            # Update existing key
            node = self.cache[key]
            node.value = value
            # Move to most recent position
            self.remove(node)
            self.insert(node)
        else:
            # Add new key
            if len(self.cache) >= self.cap:
                # Remove least recently used (leftmost real node)
                lru = self.left.next
                self.remove(lru)
                del self.cache[lru.key]
            
            # Insert new node
            new_node = Node(key, value)
            self.cache[key] = new_node
            self.insert(new_node)

    def remove(self, node):
        """Remove node from the linked list"""
        prev_node = node.prev
        next_node = node.next
        prev_node.next = next_node
        next_node.prev = prev_node

    def insert(self, node):
        """Insert node at the right (most recent position)"""
        prev_node = self.right.prev
        next_node = self.right
        
        prev_node.next = node
        next_node.prev = node
        node.prev = prev_node
        node.next = next_node
