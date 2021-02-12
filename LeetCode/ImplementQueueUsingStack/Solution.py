class MyQueue:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.stack0 = []
        self.stack1 = []
        

    def push(self, x: int) -> None:
        """
        Push element x to the back of queue.
        """
        while self.stack0:
            self.stack1.append(self.stack0.pop())
        
        self.stack0.append(x)

        while self.stack1:
            self.stack0.append(self.stack1.pop())
        

    def pop(self) -> int:
        """
        Removes the element from in front of queue and returns that element.
        """
        return self.stack0.pop()

        

    def peek(self) -> int:
        """
        Get the front element.
        """
        return self.stack0[-1]
        

    def empty(self) -> bool:
        """
        Returns whether the queue is empty.
        """
        return not self.stack0


# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()