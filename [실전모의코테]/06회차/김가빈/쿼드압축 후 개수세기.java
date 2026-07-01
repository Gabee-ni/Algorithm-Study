import java.util.*;

class Solution {
    int[] answer;
    public int[] solution(int[][] arr) {
        answer = new int[2];

        quad(arr, 0, 0, arr.length);

        return answer;
    }

    public void quad(int[][] arr, int x, int y, int len){

        if (zip(arr, x, y, len)){
            answer[arr[x][y]]++;
            return;
        }

        int half = len/2;

        quad(arr, x, y, half);
        quad(arr, x, y+half, half);
        quad(arr, x+half, y, half);
        quad(arr, x+half, y+half, half);

        return;
    }

    public boolean zip(int[][] arr, int x, int y, int len){
        for (int i=x; i<x+len; i++){
            for (int j=y; j<y+len; j++){
                if(arr[x][y] != arr[i][j]) return false;
            }
        }
        return true;
    }
}