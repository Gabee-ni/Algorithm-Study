import java.util.*;

class Solution {
    public int[] solution(String[] operations) {

        TreeMap<Integer, Integer> map = new TreeMap<>();

        for (String op : operations) {

            String[] cmd = op.split(" ");
            String order = cmd[0];
            int num = Integer.parseInt(cmd[1]);

            // 삽입
            if (order.equals("I")) {
                map.put(num, map.getOrDefault(num, 0) + 1);
            }

            // 삭제
            else {

                if (map.isEmpty()) {
                    continue;
                }

                // 최댓값 삭제
                if (num == 1) {
                    remove(map, map.lastKey());
                }

                // 최솟값 삭제
                else {
                    remove(map, map.firstKey());
                }
            }
        }

        if (map.isEmpty()) {
            return new int[]{0, 0};
        }

        return new int[]{
                map.lastKey(),
                map.firstKey()
        };
    }

    private void remove(TreeMap<Integer, Integer> map, int key) {

        int count = map.get(key);

        if (count == 1) {
            map.remove(key);
        } else {
            map.put(key, count - 1);
        }
    }
}