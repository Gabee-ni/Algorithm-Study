import java.util.*;
class Solution {
    static int[] answer;
    public boolean zip(int[][] arr, int x, int y, int size) {
        int val = arr[x][y];
        for( int i=x; i<x+size; i++){
            for(int j=y; j<y+size; j++){
                if(arr[i][j]!=val)  return false;
            }
        }
        return true;
    }

    public void quad ( int[][] arr, int x, int y, int size){

        if (zip(arr, x, y, size)){
            answer[arr[x][y]]++ ;
            return;
        }

        int half = size/2;

        quad(arr,x,y,half);
        quad(arr,x,y+half, half);
        quad(arr,x+half,y,half);
        quad(arr,x+half,y+half, half);
    }


    public int[] solution(int[][] arr) {
        answer = new int[2];
        quad(arr,0,0,arr.length);

        return answer;
    }


}