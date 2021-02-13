class MyCircularQueue:

    def __init__(self, k: int):
        self.queue = [None] * k
        self.maxlen = k
        self.front = 0
        self.rear = 0
        self.len = 0

    def enQueue(self, value: int) -> bool:
        if self.len == self.maxlen:
            return False

        self.queue[self.rear] = value
        self.rear = (self.rear + 1) % self.maxlen
        self.len += 1

        return True

    def deQueue(self) -> bool:
        if self.len == 0:
            return False

        self.front = (self.front + 1) % self.maxlen
        self.len -= 1

        return True

    def Front(self) -> int:
        if self.isEmpty():
            return -1
        
        return self.queue[self.front]
        

    def Rear(self) -> int:
        if self.isEmpty():
            return -1

        idx = None
        if self.rear == 0:
            idx = self.maxlen - 1
        else:
            idx = self.rear - 1

        return self.queue[idx]

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