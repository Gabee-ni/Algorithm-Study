import java.util.*;

class Solution {
    public int solution(String[][] clothes) {

        HashMap<String, Integer> map = new HashMap<>();

        for (String[] c : clothes) {
            String type = c[1];
            map.put(type, map.getOrDefault(type, 0) +1);
        }

        int answer = 1;
        for (int count : map.values()) {
            answer *= (count+1);
        }

        return answer -1;

    }
}

/**
 안경, 선글라스 ,안 씀
 파란티 안입음
 청바지 안입음
 긴코트 안입음
 24 - 1 23
 옷 종류 개수 확인 -> HashMap
 종류 넣고 +1
 value 꺼내서 곱하고 -1
 **/