import java.util.*;

class Pos{
    public int i;
    public int j;
    
    Pos(int i, int j){
        this.i = i;
        this.j = j;
    }
}

class Solution {
    //방향배열
    static int[] di={-1,1,0,0}, dj={0,0,-1,1};
    
    public int solution(int[][] maps) {
        //방문처리이자 시작점부터 현재까지의 이동 거리 수가 저장되어 있는 배열
        int[][] visited = new int[maps.length][maps[0].length];
		//0,0부터 BFS 탐색 시작 
        return bfs(new Pos(0,0), maps, visited);
   
    }
    
    public static int bfs(Pos pos, int[][] maps, int[][] visited){
        Queue<Pos> queue = new LinkedList<>();
        
        //현재 좌표를 큐에 넣고 방문처리 
        queue.offer(pos);
        visited[pos.i][pos.j] = 1;
         
        while(!queue.isEmpty()){
            //큐에 있던 좌표를 하나 선택 -> 방문할 좌표 
            Pos s = queue.poll();
            
            //만약 지금 꺼낸 좌표가 목적지라면, visited 배열에 저장되어 있던 수가 최단거리 이므로 visited배열 반환
            if(s.i== maps.length-1  && s.j==maps[0].length-1) return visited[s.i][s.j];
            
            //목적지가 아니라면 이제 BFS 탐색 -> 현재 위치 기준으로 4방향을 탐색하면서 다음으로 갈 수 있는지 아닌지 여부를 따짐
            for(int d=0; d<4; d++){
                int ni = s.i + di[d];
                int nj = s.j + dj[d];
                
                //다음 좌표가 범위 안 이면서, 갈 수 있는 길이고, 아직 방문 전이라면 
                if(ni>=0 && ni < maps.length && nj>=0 && nj < maps[0].length &&
                   maps[ni][nj]==1 && visited[ni][nj]==0){
                    //큐에 저장 (방문할 좌표 추가)
                    queue.offer(new Pos(ni,nj));
                    //방문처리이자 최단거리 업데이트 
                    visited[ni][nj] = visited[s.i][s.j] + 1;
                }
            }
        }
        //큐가 다 비었는데도 목적지에 도달하지 못했다면 경로가 없는 것. 
        return -1;   
    }
    
}