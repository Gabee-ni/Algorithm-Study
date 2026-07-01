import java.util.*;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        Map<String, String> record = new HashMap<>();
        Map<String, Integer> times = new HashMap<>();

        for(int i=0; i<records.length; i++){
            String[] str = records[i].split(" ");
            if ("IN".equals(str[2])){
                record.put(str[1], str[0]);

            } else if ("OUT".equals(str[2])) {
                String[] outT = str[0].split(":");

                int outH = Integer.parseInt(outT[0]) * 60;
                int outM = Integer.parseInt(outT[1]) + outH;

                String[] inT = record.get(str[1]).split(":");

                int inH = Integer.parseInt(inT[0]) * 60;
                int inM = Integer.parseInt(inT[1]) + inH;

                times.put(str[1], times.getOrDefault(str[1], 0) + (outM - inM));
                record.remove(str[1]);
            }
        }

        if (record.size() > 0 ){

            for (String key : record.keySet()){
                String[] inT = record.get(key).split(":");

                int inH = Integer.parseInt(inT[0]) * 60;
                int inM = Integer.parseInt(inT[1]) + inH;

                int outM = 23 * 60 + 59;

                times.put(key, times.getOrDefault(key, 0) + (outM - inM));
            }
        }

        List<int[]> list = new ArrayList<>();
        int[] answer = new int[times.size()];

        for (String key : times.keySet()){

            if(times.get(key) <= fees[0]){
                list.add(new int[]{Integer.parseInt(key), fees[1]});
            } else {
                list.add(
                        new int[]{Integer.parseInt(key),
                                fees[1] + (int)(Math.ceil((times.get(key) - fees[0]) / (double)fees[2]) * fees[3])}
                );
            }
        }

        Collections.sort(list, (a,b)-> a[0] - b[0]);

        int idx = 0;
        for (int[] tArr : list){
            answer[idx++] = tArr[1];
        }

        return answer;
    }
}