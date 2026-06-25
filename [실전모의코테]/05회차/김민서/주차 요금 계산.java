import java.util.*;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        
        Map<String, List<String>> times = new HashMap<>();
        
        for (String re : records) {
            String[] rec = re.split(" ");
            
            times.putIfAbsent(rec[1], new ArrayList<>());
            times.get(rec[1]).add(rec[0]);  
        }
        
        List<String> cars = new ArrayList<>(times.keySet());
        Collections.sort(cars);
        
        List<Integer> cost = new ArrayList<>();
        
        for (String c : cars) {
            
            int minutes = 0;
            
            for (int j = 0; j < times.get(c).size(); j++) {

                String[] t = times.get(c).get(j).split(":");
                int time = Integer.parseInt(t[0]) * 60 + Integer.parseInt(t[1]);
                
                if (j % 2 == 0) {
                    if (j == times.get(c).size() - 1) {
                        int min = (23 * 60 + 59) - time;
                        minutes += min;
                    } 
                } else {
                    String[] pre = times.get(c).get(j - 1).split(":");
                    int inTime = Integer.parseInt(pre[0]) * 60 + Integer.parseInt(pre[1]);
                    
                    int min = time - inTime;
                    minutes += min;
                }
            }
            
            System.out.println(minutes);
            if (minutes <= fees[0]) {
                cost.add(fees[1]);
            } else {
                int co = fees[1] + (int)Math.ceil((double)(minutes - fees[0]) / fees[2]) * fees[3];

                cost.add(co);
            }
        }
        
        int[] answer = new int[cost.size()];
        
        for (int i = 0; i < cost.size(); i++) {
            answer[i] = cost.get(i);
        }
        
        return answer;
    }
}