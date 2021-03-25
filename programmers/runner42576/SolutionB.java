import java.util.HashMap;
import java.util.Map;

class SolutionB {
    public String solution(String[] participant, String[] completion) {
        Map<String, Integer> hash = new HashMap<>();
        for (String c : completion) {
            hash.put(c, hash.getOrDefault(c, 0) + 1);
        }
        for (String p : participant) {
            int count = hash.getOrDefault(p, 0);
            if (count == 0) {
                return p;
            } else {
                hash.put(p, count - 1);
            }
        }
        return "";
    }
}