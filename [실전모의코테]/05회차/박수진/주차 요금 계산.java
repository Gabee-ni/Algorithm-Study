import java.util.*;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        Map<Integer, String> inMap = new HashMap<>();
        Map<Integer, Integer> totalTime = new HashMap<>();
        
        int basic_time = fees[0];  // 기본 시간
        int basic_fee = fees[1];   // 기본 요금
        int exceed_time = fees[2]; // 단위 시간
        int exceed_fee = fees[3];  // 단위 요금
        
        for (int i = 0; i < records.length; i++) {
            String[] record = records[i].split(" ");
            
            int num = Integer.parseInt(record[1]);
            
            if (record[2].equals("IN")) {
                inMap.put(num, record[0]);
            } else {
                String in = inMap.get(num);
                int in_h = Integer.parseInt(in.substring(0, 2));
                int out_h = Integer.parseInt(record[0].substring(0, 2));
                int in_m = Integer.parseInt(in.substring(3));
                int out_m = Integer.parseInt(record[0].substring(3));
                                            
                in_m += in_h * 60;
                out_m += out_h * 60;
                
                int total_time = out_m - in_m;
                
                totalTime.put(num, totalTime.getOrDefault(num, 0) + total_time);
                inMap.remove(num);
            }
        }
        
        if (!inMap.isEmpty()) {
            int[] key = inMap.keySet().stream().mapToInt(i->i).toArray();
            for (int i = 0; i < key.length; i++) {
                String val = inMap.get(key[i]);

                int inTime =
                    Integer.parseInt(val.substring(0, 2)) * 60
                    + Integer.parseInt(val.substring(3));

                int total_time = 1439 - inTime;
                
                totalTime.put(key[i], totalTime.getOrDefault(key[i], 0) + total_time);
                inMap.remove(key[i]);
            }
        }
        
        int[] keySet = totalTime.keySet().stream().mapToInt(i->i).toArray();
        Arrays.sort(keySet);
        
        int[] answer = new int[keySet.length];
        for (int i = 0; i < keySet.length; i++) {
            int t = totalTime.get(keySet[i]);
            int total_fee = 0;
                
            total_fee += basic_fee;
            t -= basic_time;
                
            if (t > 0) {
                total_fee +=
                    (int)Math.ceil((double)t / exceed_time) * exceed_fee;
            }
                
            answer[i] = total_fee;
        }
        
        return answer;
    }
}