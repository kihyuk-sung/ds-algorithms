from typing import List

class Solution:
    def reorderLogFiles(self, logs: List[str]) -> List[str]:
        dig, let = [], []
        for log in logs:
            if log.split()[1].isdigit():
                dig.append(log)
            else:
                let.append(log)

        let.sort(key=lambda s: (s.split(" ",maxsplit=1)[1], s.split()[0]))

        return let + dig
