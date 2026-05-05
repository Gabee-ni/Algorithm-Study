package task;

import java.util.*;
import java.io.*;

public class Main {

	//상하좌우 우상향, 좌상향, 우하향, 좌하향 대각선 좌표 
	static int[] dx = {0,0,-1,1,1,-1,1,-1};
	static int[] dy = {-1,1,0,0,-1,-1,1,1}; 
	static int answer = 0; 
	//퀸 놓는 자리 업데이트하는 배열 
	static int[][] queen;
	//놓여진 퀸들에 의해 공격 받는 범위를 지정할 배열 
	static int[][] visited; 
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		queen  = new int[N][N];
		visited = new int[N][N];
		
		dfs(N, 0);
		System.out.println(answer);
	}

	public static void dfs(int n, int curRow) {
		//종료 조건 : 현 dfs가 탐색하는 row가 N이면 끝까지 탐색 
		if(curRow == n) {
			answer++; 
			return;
		}
		
		
		for(int j=0; j<n ; j++) {
			if(visited[curRow][j] > 0 ) continue; //현재 위치는 공격 받는 자리니까 넘김 
			//공격 X인 자리 
			queen[curRow][j] = 1; 
			//놓았으니까 공격범위 지정 -> if로 다음칸만 범위 확인하면 당장 다음 칸만 확인하니까 8칸 밖에 못함. while로 하고 좌표를 현재 + 다음을 누적해야 함. visited도 =1로 하면 다른 퀸의 공격은  표시흘 못함.
			for(int d=0; d<8; d++) {
				int nx = curRow ;
				int ny = j ;
				while(true) {
					nx += dx[d];
					ny += dy[d];
					if(nx < 0 || ny < 0 || nx >= n || ny >= n) break; 
					visited[nx][ny] += 1; 
				}		
			}
			
			//그 다음 순회 
			dfs(n, curRow+1);
			//return 된 거에 맞게 처리 -> 퀸 자리, 공격 범위 복구 
			
			queen[curRow][j] = 0; 
			for(int d=0; d<8; d++) {
				int nx = curRow ;
				int ny = j ;
				while(true) {
					nx += dx[d];
					ny += dy[d];
					if(nx < 0 || ny < 0 || nx >= n || ny >= n) break; 
					visited[nx][ny] -= 1; 
				}		
			}
		}
		
	}
}

