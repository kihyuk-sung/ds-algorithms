import java.util.*;

class Solution {
    
    private Map<String, Integer> profits = new LinkedHashMap<>();
    private Map<String, String> reversedTree = new LinkedHashMap<>();
    
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        
        initMaps(enroll, referral);
        
        for (int i = 0; i < seller.length; i++) {
            String s = seller[i];
            int a = amount[i];
            calculateProfit(s, a * 100);
        }
        
        int[] result = new int[enroll.length];
        
        for (int i = 0; i < enroll.length; i++) {
            result[i] = profits.get(enroll[i]);
        }
        
        return result;
    }
    
    private void initMaps(String[] enroll, String[] referral) {        
        for (int i = 0; i < enroll.length; i++) {
            reversedTree.put(enroll[i], referral[i]);
            profits.put(enroll[i], 0);
        }
    }
    
    private void calculateProfit(String seller, int profit) {
        while (!"-".equals(seller)) {
            Integer currentProfit = profits.get(seller);

            int addedProfit = profit;
            if (profit >= 10) {
                addedProfit -= profit / 10;    
            } 

            profits.put(seller, currentProfit + addedProfit);

            if (profit < 10) {
                break;
            }

            seller = reversedTree.get(seller);
            profit = profit / 10;
        }
    }
}
