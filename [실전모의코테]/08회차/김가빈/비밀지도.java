import java.util.*;

class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        String[] str1 = new String[n];
        String[] str2 = new String[n];

        for(int i=0; i<n; i++){
            str1[i] = makeNum(Integer.toString(arr1[i],2), "", n);
            str2[i] = makeNum(Integer.toString(arr2[i],2), "", n);
        }

        for(int i=0; i<n; i++){
            StringBuilder sb = new StringBuilder();
            for(int j=0; j<n; j++){
                if (str1[i].charAt(j)=='1' || str2[i].charAt(j)=='1') sb.append("#");
                else if (str1[i].charAt(j)=='0' && str2[i].charAt(j)=='0') sb.append(" ");
            }
            answer[i] = sb.toString();
        }

        return answer;
    }

    public String makeNum (String s, String zero, int n){
        if (s.length() < n) {
            for (int i=0; i<n-s.length(); i++) zero += "0";
        }
        return zero + s;
    }
}