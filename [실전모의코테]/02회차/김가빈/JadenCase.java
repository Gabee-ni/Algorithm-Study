class Solution {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();

        boolean isFirst = true;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            System.out.println("i = " + i + ", ch = [" + ch + "], isFirst = " + isFirst);

            if (ch == ' ') {
                sb.append(ch);
                isFirst = true;
            } else {
                if (isFirst) {
                    sb.append(Character.toUpperCase(ch));
                    isFirst = false;
                } else {
                    sb.append(Character.toLowerCase(ch));
                }
            }

            System.out.println("현재 결과 = [" + sb.toString() + "]");
        }

        return sb.toString();
    }
}