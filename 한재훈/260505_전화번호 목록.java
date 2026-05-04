import java.util.Arrays;

class Solution {
    public boolean solution(String[] phone_book) {

        Arrays.sort(phone_book);

        for (int i=0; i < phone_book.length -1; i++) {
            if (phone_book[i + 1].startsWith(phone_book[i])) {
                return false;
            }
        }
        return true;
    }
}

/**
 존재 확인? -> HashSet
 전화번호 hastSet에 저장
 앞부분 한개씩 꺼내서 set에 저장
 왜 hash문제인지 모르겠음
 Arrays.sort -> 앞 인덱스 비교
 **/