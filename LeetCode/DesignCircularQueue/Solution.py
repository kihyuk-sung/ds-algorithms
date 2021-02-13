from collections import deque

class MyCircularQueue:

    def __init__(self, k: int):
        self.queue = deque(maxlen=k)
        self.len = 0
        self.maxlen = k

    def enQueue(self, value: int) -> bool:
        if self.len == self.maxlen:
            return False

        self.queue.append(value)
        self.len += 1

        return True

    def deQueue(self) -> bool:
        if self.len == 0:
            return False
        self.queue.popleft()
        self.len -= 1
        
        return True

    def Front(self) -> int:
        if self.isEmpty():
            return -1
        
        return self.queue[0]
        

    def Rear(self) -> int:
        if self.isEmpty():
            return -1

        return self.queue[self.len - 1]

    def isEmpty(self) -> bool:
        return self.len == 0

    def isFull(self) -> bool:
        return self.len == self.maxlen
        

# Your MyCircularQueue object will be instantiated and called as such:
# obj = MyCircularQueue(k)
# param_1 = obj.enQueue(value)
# param_2 = obj.deQueue()
# param_3 = obj.Front()
# param_4 = obj.Rear()
# param_5 = obj.isEmpty()
# param_6 = obj.isFull()