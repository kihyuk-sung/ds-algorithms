from collections import deque

class MyStack:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.queue0 = deque()
        self.queue1 = deque()
        

    def push(self, x: int) -> None:
        """
        Push element x onto stack.
        """

        while self.queue0:
            self.queue1.append(self.queue0.popleft())
        
        self.queue0.append(x)

        while self.queue1:
            self.queue0.append(self.queue1.popleft())
        

        

    def pop(self) -> int:
        """
        Removes the element on top of the stack and returns that element.
        """
        return self.queue0.popleft()
        

    def top(self) -> int:
        """
        Get the top element.
        """

        if self.queue0:
            return self.queue0[0]
        

    def empty(self) -> bool:
        """
        Returns whether the stack is empty.
        """

        return not self.queue0
        


# Your MyStack object will be instantiated and called as such:
# obj = MyStack()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.top()
# param_4 = obj.empty()