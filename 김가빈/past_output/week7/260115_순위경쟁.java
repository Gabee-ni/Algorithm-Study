import java.util.*;

class Solution {
    //여기에 각 조합을 키로 저장하고, 조합의 각 점수들을 리스트로 저장
    HashMap<String, ArrayList<Integer>> map = new HashMap<>();
    
    public int[] solution(String[] info, String[] query) {
        // 모든 지원자의 정보 저장 
        for (String inf : info) {
            String[] data = inf.split(" ");
            String lang = data[0];      // 언어
            String job = data[1];       // 직군
            String career = data[2];    // 경력
            String food = data[3];      // 소울푸드
            int score = Integer.parseInt(data[4]);  // 점수
            
            // 재귀로 모든 조합 생성
            makeCombinations(lang, job, career, food, score, 0, "");
        }
        
        //각 조합별 점수 리스트를 정렬
        for (String key : map.keySet()) {
            Collections.sort(map.get(key));
        }
        
        //쿼리에 맞는 지원자 수 정답 배열에 넣기 
        int[] answer = new int[query.length];
        for (int i = 0; i < query.length; i++) {
            answer[i] = countMatches(query[i]);
        }
        
        return answer;
    }
    
    // 모든 조합 생성
    // depth: 현재 선택 중인 조건 (0:언어, 1:직군, 2:경력, 3:소울푸드)
    void makeCombinations(String lang, String job, String career, 
                         String food, int score, int depth, String key) {
        if (depth == 4) {
            // 4개 조건을 모두 처리했으면 HashMap에 추가
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(score);
            return;
        }
        
        // 각 단계에서 2가지 선택: 조건 포함 vs "-"
        String[] conditions = {lang, job, career, food};
        
        // 선택1: 실제 조건 추가
        makeCombinations(lang, job, career, food, score, depth + 1, 
                        key + conditions[depth]);
        
        // 선택2: "-" 추가 (해당 조건 무시)
        makeCombinations(lang, job, career, food, score, depth + 1, 
                        key + "-");
    }
    
    // 쿼리에 맞는 지원자 수 세기
    int countMatches(String query) {
        String[] tokens = query.split(" and | ");  // " and " 또는 공백으로 분리
        
        String key = tokens[0] + tokens[1] + tokens[2] + tokens[3];
        int targetScore = Integer.parseInt(tokens[4]);
        
        // 해당 조합이 없으면 0 반환
        if (!map.containsKey(key)) {
            return 0;
        }
        
        // 이분 탐색으로 targetScore 이상인 첫 인덱스 찾기
        ArrayList<Integer> scores = map.get(key);
        int left = 0;
        int right = scores.size();
        
        while (left < right) {
            int mid = (left + right) / 2;
            if (scores.get(mid) < targetScore) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        
        // targetScore 이상인 사람 수 = 전체 - left 인덱스
        return scores.size() - left;
    }
}