class Solution {
    public int solution(String skill, String[] skill_trees) {
        boolean[] skill_hash = new boolean[26];
        
        for (int i = 0; i < skill.length(); i++) {
            int index = skill.charAt(i) - 'A';
            skill_hash[index] = true;
        }
        int answer = 0;
        for (String s : skill_trees) {
            if (availableSkill(skill_hash, skill, s)) {
                answer++;
            }
        }
        return answer;
    }
    
    private boolean availableSkill(boolean[] skill_hash, String skill, String s) {
        int skillTreeCurser = 0;
        for (int i = 0; i < s.length(); i++) {
            int index = s.charAt(i) - 'A';
            if (skill_hash[index]) {
                if (skill.charAt(skillTreeCurser) != s.charAt(i)) {
                    return false;
                } else {
                    skillTreeCurser++;
                }
            }
        }
        return true;
    }
}
