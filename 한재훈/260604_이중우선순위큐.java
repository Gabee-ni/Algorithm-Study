import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        TreeMap<Integer, Integer> map = new TreeMap<>();

        for (String operation : operations) {
            String[] parts = operation.split(" ");
            String command = parts[0];
            int number = Integer.parseInt(parts[1]);

            if (command.equals("I")) {
                map.merge(number, 1, Integer::sum);
            } else {
                if (map.isEmpty()) {
                    continue;
                }

                int targetKey = (number == 1) ? map.lastKey() : map.firstKey();


                int count = map.get(targetKey);
                if (count == 1) {
                    map.remove(targetKey);
                } else {
                    map.put(targetKey, count - 1);
                }
            }
        }

        if (map.isEmpty()) {
            return new int[]{0, 0};
        }
        return new int[]{map.lastKey(), map.firstKey()};


    }
}