import java.util.*;
class Solution {
    public int solution(int m, int n, String[] board) {
        String[][] bd = new String[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                bd[i][j] = String.valueOf(board[i].charAt(j));
            }
        }
        int answer = 0;
        boolean end = false;
        int bcnt = 0;
        while(!end){
            bd = findblock(m, n, bd);  
            bd = update(m, n, bd);
            int pcnt = cnt(m,n,bd);
            if(bcnt == pcnt){
                end = true;
            } else {
                bcnt = pcnt;
            }
            // for (String[] b : bd) {
            //     System.out.println(Arrays.toString(b));
            // }
            // System.out.println();
        }
        return bcnt;
    }

    String[][] findblock(int m, int n, String[][] bd){
        boolean [][] tf = new boolean[m][n];
        for(int i=0; i< m-1; i++){
            for(int j=0; j<n-1; j++){
                if(bd[i][j].equals(bd[i+1][j]) && bd[i][j].equals(bd[i][j+1]) && bd[i][j].equals(bd[i+1][j+1])){
                    tf[i][j] = true;
                    tf[i+1][j] = true;
                    tf[i][j+1] = true;
                    tf[i+1][j+1] = true;
                }
            }
        }
        for(int a=0; a<n; a++){
            for(int b=0; b<m; b++){
                if(tf[b][a]){
                    bd[b][a] = "";
                }
            }
        }
        return bd;
    }
    int cnt(int m, int n, String[][] bd){
        int cnt = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if("".equals(bd[j][i])){
                    cnt++;
                }
            }
        }
        return cnt;
    }

    String[][] update(int m, int n, String[][] bd){
        for(int i=0; i<n; i++){
            for(int j=m-1; j>=0; j--){
                if("".equals(bd[j][i])){
                    for(int a= j-1; a>=0; a--){
                        if(!"".equals(bd[a][i])){
                            bd[j][i] = bd[a][i];
                            bd[a][i] = "";
                            break;
                        }
                    }         
                }
            }
        }
        return bd;
    }
}