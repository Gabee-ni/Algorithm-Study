class Solution {
    public String solution(String new_id) {
        // 1. 소문자로 치환
        new_id = new_id.toLowerCase();

        // 2. 예외 문자 제거
        new_id = new_id.replaceAll("[^a-z0-9-_.]", "");

        // 3. 2개 이상의 '.' 하나로 치환
        new_id = new_id.replaceAll("\\.{2,}", ".");

        // 4. 처음과 끝에 위치한 '.' 제거
        new_id = new_id.replaceAll("^\\.|\\.$", "");

        // 5. 빈 문자열은 a로 치환
        if (new_id.equals(""))
            new_id = "a";

        // 6. 15자로 축소
        if (new_id.length() >= 16) {
            new_id = new_id.substring(0, 15);
            new_id = new_id.replaceAll("\\.$", "");
        }

        // 7. 2자 이하라면 마지막 문자를 반복 (최소 3자);
        while (new_id.length() <= 2) {
            char lastChar = new_id.charAt(new_id.length() - 1);
            new_id += lastChar;
        }

        return new_id;
    }
}
