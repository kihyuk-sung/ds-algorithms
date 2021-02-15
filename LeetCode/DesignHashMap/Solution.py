class MyHashMap:

    class Node:
        def __init__(self, key, value, next=None) -> None:
            self.key = key
            self.value = value
            self.next = next

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.size = 10000
        self.table = [self.Node(None, None)] * self.size

    def put(self, key: int, value: int) -> None:
        """
        value will always be non-negative.
        """
        prev = self.table[key % self.size]
        ptr = prev.next
        while ptr:
            if ptr.key == key:
                ptr.value = value
                return
            prev = ptr
            ptr = ptr.next
        
        prev.next = self.Node(key, value)
        
    def get(self, key: int) -> int:
        """
        Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key
        """
        ptr = self.table[key % self.size].next
        while ptr:
            if ptr.key == key:
                return ptr.value
            ptr = ptr.next
        
        return -1        

    def remove(self, key: int) -> None:
        """
        Removes the mapping of the specified value key if this map contains a mapping for the key
        """
        prev = self.table[key % self.size]
        ptr = prev.next
        while ptr:
            if ptr.key == key:
                prev.next = ptr.next
                ptr.next = None
                return
            prev = ptr
            ptr = ptr.next

# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)